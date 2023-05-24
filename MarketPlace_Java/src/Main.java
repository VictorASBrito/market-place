import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Registrador registro = new Registrador();
        Login login = new Login();

        int opcao = 0;

        do {
            System.out.println("===================================");
            System.out.println("MARKET PLACE");
            System.out.println("===================================");
            System.out.println("(01) - LOGIN\n(02) - REGISTRO\n(99) - SAIR");
            System.out.print("Digite a opção: ");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    login.login();
                    break;
                case 2:
                    registro.registra();
                    break;
                case 99:
                    System.out.println("Fechando programa...");
                    break;
                default:
                    System.out.println("Opção Invalida");
                    break;
            }

        } while (opcao != 99);

    }
}
