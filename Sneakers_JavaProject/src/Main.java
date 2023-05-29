import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void printFinalMessages(String input, String color) {

        Scanner scanner = new Scanner(System.in);
        String message = String.format("|  %s  ", input);
        String colorAdvise = null;

        if (Objects.equals(color, "red")) {
            colorAdvise = "\u001B[31m";
        } else {
            colorAdvise = "\u001B[32m";
        }
        System.out.println(colorAdvise + "\n|-----------------------------------------------");
        System.out.println(message);
        System.out.println("|-----------------------------------------------\n" + ANSI_RESET);

        scanner.nextLine();
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static boolean isString(String input) {
        return input.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        /* Instanciando classes */
        ShoppingCart shoppingCart = new ShoppingCart();
        SneakerStore program = new SneakerStore();
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();

        boolean runningAllSwitch = true;

        while (runningAllSwitch) {
            System.out.println("\n|-------------------------------------------------|");
            System.out.println("|          MENU INICIAL - [SNEAKERS]              |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|  01   |    Criar superUsuario                   |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|  02   |    Logar                                |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|  03   |    Entrar como cliente [Acesso publico] |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|  0    |    Sair do programa                     |");
            System.out.println("|-------------------------------------------------|\n");
            System.out.print("Opcao: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Informe o Nome do Usuario: ");
                    String name = scanner.nextLine();
                    while (!isString(name)) {
                        System.out.println(ANSI_RED + "Entrada inválida. Por favor, informe uma [STRING]" + ANSI_RESET);
                        name = scanner.next();
                    }

                    System.out.println("Digite a idade do usuario:");
                    int age;
                    do {
                        while (!scanner.hasNextInt()) {
                            System.out.println(
                                    ANSI_RED + "Entrada inválida. Por favor, informe um [NUMERO]." + ANSI_RESET);

                        }
                        age = scanner.nextInt();
                    } while (age <= 0);
                    scanner.nextLine();

                    System.out.println(ANSI_RED + "\n|-------------------------------------------------|");
                    System.out.println("|          ATENCAO! -[INFORME O CARGO DO USUARIO] |");
                    System.out.println("|-------------------------------------------------|");
                    System.out.println("|  01   |     ADMINISTRADOR-[TOTAL ACESSO]        |");
                    System.out.println("|-------------------------------------------------|");
                    System.out.println("|  02   |     VENDENDOR-[ACESSO PARCIAL]          |");
                    System.out.println("|-------------------------------------------------|\n" + ANSI_RESET);
                    System.out.print("Informe a Role do Usuario:  ");
                    int roleOption = scanner.nextInt();
                    String role = null;
                    switch (roleOption) {
                        case 1 -> role = "superAdmin";
                        case 2 -> role = "admin";
                    }
                    if (Objects.equals(role, "superAdmin")) {
                        System.out.println(ANSI_RED
                                + "Importante! - Essa role vai dar total acesso ao usuario cadastrado!" + ANSI_RESET);
                        scanner.nextLine();
                    }

                    System.out.print("Informe a senha:  ");
                    String password = scanner.next();
                    while (!isString(password)) {
                        System.out.println(ANSI_RED + "Entrada inválida. Por favor, informe uma [STRING]" + ANSI_RESET);
                        password = scanner.next();
                    }

                    userManager.addUser(name, age, role, password);

                    printFinalMessages("USUARIO ADICIONADO COM SUCESSO !", "green");
                }
                case 2 -> {
                    printFinalMessages("BEM VINDO AO LOGIN", "green");

                    System.out.print("Por favor infome seu nome: ");
                    String username = scanner.nextLine();
                    System.out.print("Por favor informe sua senha: ");
                    String password = scanner.nextLine();

                    User userExists = program.login(username, password, userManager);

                    if (userExists == null) {
                        break;
                    }

                    boolean runningUserLoggedSwitch = true;
                    while (runningUserLoggedSwitch) {
                        System.out.println(ANSI_GREEN + "\n|-------------------------------------------------|");
                        System.out.println("|          GERENCIAMENTO DE ESTOQUE               |");
                        System.out.println("|-------------------------------------------------|" + ANSI_RESET);
                        System.out.println("|          BEM VINDO (A) - [ " + username + " ]");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  01   |    Adicionar um Sneaker no [estoque]       |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  02   |    Remover um Sneaker do [estoque]         |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  03   |    Modificar um Sneaker do [estoque]       |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  04   |    Listar todos os Sneakers no [estoque]   |");
                        System.out.println("|-------------------------------------------------|\n");
                        System.out.println(ANSI_GREEN + "|-------------------------------------------------|");
                        System.out.println("|          GERENCIADOR DE FUNCIONARIOS            |");
                        System.out.println("|-------------------------------------------------|" + ANSI_RESET);
                        System.out.println("|  05   |    Listar todos funcionarios            |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  06   |    Remover um Funcionario               |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  07   |    Mudar Role de um funcionario         |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  08   |    Fazer LogOut                         |");
                        System.out.println("|-------------------------------------------------|\n");
                        System.out.println("Informe sua opcao: ");
                        int loggedInUserOption = scanner.nextInt();

                        switch (loggedInUserOption) {
                            case 1 -> {
                                scanner.nextLine();
                                System.out.print("Informe o nome do Sneaker: ");
                                String name = scanner.nextLine();
                                while (!isString(name)) {
                                    System.out.println(ANSI_RED + "Entrada inválida. Por favor, informe uma [STRING]"
                                            + ANSI_RESET);
                                    name = scanner.next();
                                }

                                System.out.print("Informe a descricao do cafe: ");
                                String description = scanner.nextLine();
                                while (!isString(description)) {
                                    System.out.println(ANSI_RED + "Entrada inválida. Por favor, informe uma [STRING]"
                                            + ANSI_RESET);
                                    description = scanner.next();
                                }
                                System.out.print("Informe o preco do Sneaker: ");
                                double price;
                                do {
                                    while (!scanner.hasNextInt()) {
                                        System.out.println(ANSI_RED
                                                + "Entrada inválida. Por favor, informe um [NUMERO]." + ANSI_RESET);
                                        scanner.next();
                                    }
                                    price = scanner.nextDouble();
                                } while (price <= 0);

                                scanner.nextLine();
                                program.addSneaker(name, description, price, program.getLoggedInUser());
                            }
                            case 2 -> {
                                System.out.print("Informe o ID do Sneaker que deseja remover do estoque: ");
                                int idToRemove;
                                do {
                                    while (!scanner.hasNextInt()) {
                                        System.out.println(ANSI_RED
                                                + "Entrada inválida. Por favor, informe um [NUMERO]." + ANSI_RESET);
                                        scanner.next();
                                    }
                                    idToRemove = scanner.nextInt();
                                } while (idToRemove <= 0);
                                scanner.nextLine(); // Clear the scanner buffer
                                program.removerSneaker(idToRemove);
                            }
                            case 3 -> {
                                System.out.print("Informe o ID do Sneaker que deseja modificar: ");
                                int idToModify;
                                do {
                                    while (!scanner.hasNextInt()) {
                                        System.out.println(ANSI_RED
                                                + "Entrada inválida. Por favor, informe um [NUMERO]." + ANSI_RESET);
                                        scanner.next();
                                    }
                                    idToModify = scanner.nextInt();
                                } while (idToModify <= 0);
                                scanner.nextLine(); // Clear the scanner buffer
                                program.modifySneaker(idToModify);
                            }
                            case 4 -> program.listaSneakers();
                            case 5 -> {
                                List<User> users = userManager.getUsers();
                                printFinalMessages("LISTANDO TODOS USUARIOS CADASTRADOS", "green");
                                for (User user : users) {
                                    System.out.println("\n|---------------------------------|");
                                    System.out.println("|  ID      | " + user.getId());
                                    System.out.println("|---------------------------------|");
                                    System.out.println("|  NOME    | " + user.getName());
                                    System.out.println("|---------------------------------|");
                                    System.out.println("|  IDADE   | " + user.getAge());
                                    System.out.println("|---------------------------------|");
                                    System.out.println("|  ROLE    | " + user.getRole());
                                    System.out.println("|---------------------------------|\n");
                                    scanner.nextLine();
                                }

                            }
                            case 6 -> {
                                if (!Objects.equals(userExists.getRole(), "superAdmin")) {
                                    printFinalMessages("VOCE NAO TEM PERMISSAO PARA REMOVER FUNCIONARIOS", "red");
                                    break;
                                }
                                System.out.print("Informe o ID do usuario que deseja remover: ");
                                int idToRemove;
                                do {
                                    while (!scanner.hasNextInt()) {
                                        System.out.println(ANSI_RED
                                                + "Entrada inválida. Por favor, informe um [NUMERO]." + ANSI_RESET);
                                        scanner.next();
                                    }
                                    idToRemove = scanner.nextInt();
                                } while (idToRemove <= 0);

                                scanner.nextLine(); // Clear the scanner buffer
                                boolean userExclude = userManager.removeUser(idToRemove);
                                if (!userExclude) {
                                    printFinalMessages("USUARIO NAO ENCONTRADO", "red");
                                }
                                printFinalMessages("USUARIO REMOVIDO COM SUCESSO!", "green");
                            }
                            case 7 -> {
                                if (!Objects.equals(userExists.getRole(), "superAdmin")) {
                                    printFinalMessages("VOCE NAO TEM PERMISSAO PARA ALTERAR ESSA ROLE", "red");
                                    break;
                                }
                                System.out.print("Informe qual ID do usuario que deseja modificar a role: ");
                                int idToChangeRole;
                                do {
                                    while (!scanner.hasNextInt()) {
                                        System.out.println(ANSI_RED
                                                + "Entrada inválida. Por favor, informe um [NUMERO]." + ANSI_RESET);
                                        scanner.next();
                                    }
                                    idToChangeRole = scanner.nextInt();
                                } while (idToChangeRole <= 0);
                                scanner.nextLine(); // Clear the scanner buffer

                                System.out.println(ANSI_RED + "\n|-------------------------------------------------|");
                                System.out.println("|     ATENCAO! -[INFORME A NOVA ROLE DO USUARIO]  |");
                                System.out.println("|-------------------------------------------------|");
                                System.out.println("|  01   |     SuperAdmin-[TOTAL ACESSO]           |");
                                System.out.println("|-------------------------------------------------|");
                                System.out.println("|  02   |     Admin-[ACESSO PARCIAL]              |");
                                System.out
                                        .println("|-------------------------------------------------|\n" + ANSI_RESET);
                                System.out.print("Informe a Role do Usuario:  ");
                                int roleOption = scanner.nextInt();
                                String role = null;
                                switch (roleOption) {
                                    case 1 -> role = "superAdmin";
                                    case 2 -> role = "admin";
                                }
                                if (Objects.equals(role, "superAdmin")) {
                                    System.out.println(ANSI_RED
                                            + "Importante! - Essa role vai dar total acesso ao usuario cadastrado!"
                                            + ANSI_RESET);
                                    scanner.nextLine();
                                }
                                boolean userRoleChanged = userManager.changeUserRole(idToChangeRole, role);
                                if (!userRoleChanged) {
                                    printFinalMessages("USUARIO NAO ENCONTRADO", "red");

                                }
                            }

                            case 8 -> {
                                program.logout();
                                printFinalMessages("USUARIO DESLOGADO COM SUCESSO!", "green");
                                runningUserLoggedSwitch = false;
                            }
                            default -> printFinalMessages("OPCAO INVALIDA", "red");
                        }
                    }
                }
                case 3 -> {
                    System.out.println(ANSI_GREEN + "\n\n|-------------------------------------------------|");
                    System.out.println("          BEM VINDO (A) AO Sneaker Shop         ");
                    System.out.println("|-------------------------------------------------|\n" + ANSI_RESET);
                    System.out.println(
                            "Antes que seja possivel alguma entrada de dados necessitamos do seu nome para registro: ");
                    String clientName = scanner.next();
                    boolean runningClientSwitch = true;
                    while (runningClientSwitch) {
                        System.out.println("\n|          BEM VINDO (A) - [ " + clientName + " ]");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  01   | Listar todos Sneaker no [Menu]             |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  02   | Adicionar um Sneaker ao Carrinho de compras|");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  03   | Remover um Sneaker do Carrinho de compras  |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  04   | Listar os Sneakers do Carrinho de compras  |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  05   | Retornar ao menu inicial                |");
                        System.out.println("|-------------------------------------------------|\n");
                        int optionCart = scanner.nextInt();

                        switch (optionCart) {
                            case 1 -> program.listaSneakers();
                            case 2 -> {
                                System.out.print("Informe o ID do Sneaker que deseja adicionar ao carrinho: ");
                                int idToAdd;
                                do {
                                    while (!scanner.hasNextInt()) {
                                        System.out.println(ANSI_RED
                                                + "Entrada inválida. Por favor, informe um [NUMERO]." + ANSI_RESET);
                                        scanner.next();
                                    }
                                    idToAdd = scanner.nextInt();
                                } while (idToAdd <= 0);

                                scanner.nextLine(); // Clear the scanner buffer
                                Sneaker sneakerAdd = program.searchSneakerById(idToAdd);
                                shoppingCart.addProduct(sneakerAdd);
                            }
                            case 3 -> {
                                System.out.print("Informe o ID do Sneaker que deseja remover do carrinho: ");
                                int idToRemove;
                                do {
                                    while (!scanner.hasNextInt()) {
                                        System.out.println(ANSI_RED
                                                + "Entrada inválida. Por favor, informe um [NUMERO]." + ANSI_RESET);
                                        scanner.next();
                                    }
                                    idToRemove = scanner.nextInt();
                                } while (idToRemove <= 0);

                                scanner.nextLine(); // Clear the scanner buffer
                                shoppingCart.removeProduct(idToRemove);
                            }
                            case 4 -> shoppingCart.displayCart();
                            case 5 -> {
                                runningClientSwitch = false;
                                printFinalMessages("RETORNANDO AO MENU INICIAL", "green");
                            }

                            default -> printFinalMessages("OPCAO INVALIDA", "red");
                        }
                    }
                }
                case 0 -> runningAllSwitch = false;
                default -> printFinalMessages("OPCAO INVALIDA", "red");
            }
        }
        scanner.close();
    }
}
