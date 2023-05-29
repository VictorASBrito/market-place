import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Objects;

class SneakerStore {
    private final List<Sneaker> sneakers;
    private String loggedInUser;
    private int nextId;

    Scanner scanner = new Scanner(System.in);

    public SneakerStore() {
        sneakers = new ArrayList<>();
        loggedInUser = null;
        nextId = 1;
    }

    public void printFinalMessages(String input, String color) {
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

    public static boolean isString(String input) {
        return input.matches("[a-zA-Z]+");
    }

    public void addSneaker(String name, String description, double price, String creator) {
        Sneaker sneaker = new Sneaker(nextId, name, description, price, creator);
        sneakers.add(sneaker);
        nextId++;
        printFinalMessages("Sneaker Adicionado Com Sucesso!", "green");
    }

    public void removerSneaker(int id) {

        for (int i = 0; i < sneakers.size(); i++) {
            Sneaker sneaker = sneakers.get(i);
            if (sneaker.getId() == id) {
                if (sneaker.getCreator().equals(loggedInUser) || isAdmin()) {
                    sneakers.remove(i);
                    printFinalMessages("O Sneaker Foi Removido Com Sucesso!", "green");
                } else {
                    printFinalMessages("Desculpe, Mas Voce Nao Possui Permissao Para Remover O Sneaker!", "red");
                }
                return;
            }
        }
        printFinalMessages("Sneaker Nao Foi Encontrado!", "red");
    }

    public void modifySneaker(int id) {
        for (Sneaker sneaker : sneakers) {
            if (sneaker.getId() == id) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Informe o novo Nome do Sneaker: ");
                String newName = scanner.nextLine();
                while (!isString(newName)) {
                    System.out.println(ANSI_RED + "Entrada inválida. Por favor, informe uma [STRING]" + ANSI_RESET);
                    newName = scanner.next();
                }

                System.out.print("Informe a nova Descricao do Sneaker: ");
                String newDescription = scanner.nextLine();
                while (!isString(newDescription)) {
                    System.out.println(ANSI_RED + "Entrada inválida. Por favor, informe uma [STRING]" + ANSI_RESET);
                    newDescription = scanner.next();
                }

                System.out.print("Informe o novo preco do Sneaker: ");
                double newPrice;
                do {
                    while (!scanner.hasNextInt()) {
                        System.out.println(ANSI_RED + "Entrada inválida. Por favor, informe um [NUMERO]." + ANSI_RESET);
                        scanner.next();
                    }
                    newPrice = scanner.nextInt();
                } while (newPrice <= 0);
                scanner.nextLine(); // Clear the scanner buffer

                sneaker.name = newName;
                sneaker.description = newDescription;
                sneaker.price = newPrice;
                printFinalMessages("Status do Sneaker Foi Modificado", "green");

            }
            printFinalMessages("O Sneaker Em Questao Nao Foi Encontrado Na Base de Dados", "red");
            return;
        }

    }

    public Sneaker searchSneakerById(int id) {
        for (Sneaker sneaker : sneakers) {
            if (sneaker.getId() == id) {
                return sneaker;
            } else {
                printFinalMessages("Sneaker Com ID Incorreto!", "red");
                return null;
            }
        }
        return null;
    }

    public User login(String username, String password, UserManager userManager) {

        List<User> users = userManager.getUsers();

        for (User user : users) {
            if (username.equals(user.getName()) && password.equals(user.getPassword())
                    && Objects.equals(user.getRole(), "superAdmin")) {
                loggedInUser = "admin";
                printFinalMessages("LOGADO COM SUCESSO COMO SUPER-ADMINISTRADOR", "green");
                return user;

            }
            if (username.equals(user.getName()) && password.equals(user.getPassword())) {
                loggedInUser = username;
                printFinalMessages("LOGADO COM SUCESSO COMO ADMINISTRADOR REGULAR", "green");
                return user;

            }
            if (!username.equals(user.getName()) || !password.equals(user.getPassword())) {
                printFinalMessages("SENHA OU NOME INCORRETOS", "red");
                return null;
            }
        }

        return null;
    }

    public void logout() {
        loggedInUser = null;
    }

    public void listaSneakers() {
        if (sneakers.isEmpty()) {
            printFinalMessages("Sem Sneaker no Menu :(", "red");
        } else {
            printFinalMessages("Listando Todos Os Sneakers Em Estoque", "green");
            for (Sneaker sneaker : sneakers) {
                System.out.println("\n|---------------------------------|");
                System.out.println("|  ID          | " + sneaker.getId());
                System.out.println("|---------------------------------|");
                System.out.println("|  NOME        | " + sneaker.getName());
                System.out.println("|---------------------------------|");
                System.out.println("|  DESCRICAO   | " + sneaker.getDescription());
                System.out.println("|---------------------------------|");
                System.out.println("|  PRECO       | " + sneaker.getPrice());
                System.out.println("|---------------------------------|\n");
                scanner.nextLine();
            }
        }
    }

    private boolean isAdmin() {
        return loggedInUser != null && loggedInUser.equals("admin");
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

}
