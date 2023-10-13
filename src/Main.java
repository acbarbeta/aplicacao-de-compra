import java.util.Collections;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o limite do cartão: ");
        double limite = scanner.nextDouble();

        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Digite a descrição da compra: ");
            String descricao = scanner.next();

            System.out.println("Digite o preço da compra: ");
            double preco = scanner.nextDouble();

            Compra compra = new Compra(descricao, preco);
            boolean compraPermitida = cartao.processaCompra(compra);

            if (compraPermitida) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para finalizar ou 1 para continuar");
                if (scanner.nextInt() == 0) {
                    continuar = false;
                }

            } else {
                System.out.println("Saldo insuficiente!");
                continuar = false;
            }
        }

        System.out.println("********************");
        System.out.println("COMPRAS REALIZADAS:\n");
        Collections.sort(cartao.getCompras());
        for (Compra compra : cartao.getCompras()) {
            System.out.println(compra.getDescricao() + "-" + compra.getPreco());
        }
        System.out.println("\n********************");
        System.out.println("\n Saldo do cartão: " + cartao.getSaldo());
    }
}