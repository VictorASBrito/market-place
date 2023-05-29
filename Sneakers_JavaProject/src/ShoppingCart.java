import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ShoppingCart {
    private final List<Sneaker> SneakersInCart;

    public ShoppingCart() {
        SneakersInCart = new ArrayList<>();
    }

    public SneakerStore sneaker = new SneakerStore();
    Scanner scanner = new Scanner(System.in);

    public void addProduct(Sneaker product) {
        if (product == null) {
            sneaker.printFinalMessages("SNEAKER NAO ENCONTRADO!", "red");
        } else {
            SneakersInCart.add(product);
            sneaker.printFinalMessages("PRODUTO ADICIONADO AO CARRINHO DE COMPRAS", "green");
        }
    }

    public void removeProduct(int productId) {
        if (SneakersInCart.isEmpty()) {
            sneaker.printFinalMessages("VOCE NAO TEM PRODUTOS EM SEU CARRINHO", "red");
        } else {
            for (int i = 0; i < SneakersInCart.size(); i++) {
                if (SneakersInCart.get(i).getId() == productId) {
                    SneakersInCart.remove(i);
                    sneaker.printFinalMessages("PRODUTO REMOVIDO DO CARRINHO", "green");
                    return;
                }
            }
            sneaker.printFinalMessages("PRODUTO NAO ENCONTRADO!", "red");
        }
    }

    public void displayCart() {

        if (SneakersInCart.isEmpty()) {
            sneaker.printFinalMessages("CARRINHO DE COMPRAS VAZIO", "red");
        } else {
            sneaker.printFinalMessages("LISTANDO PRODUTOS NO CARRINHO DE COMPRAS", "green");
            double total = 0.0;
            for (Sneaker product : SneakersInCart) {

                System.out.println("\n|---------------------------------|");
                System.out.println("|  ID      | " + product.getId());
                System.out.println("|---------------------------------|");
                System.out.println("|  NOME    | " + product.getName());
                System.out.println("|---------------------------------|");
                System.out.println("|  PRECO   | " + product.getPrice());
                System.out.println("|---------------------------------|");

                total += product.getPrice();
                System.out.println("|  TOTAL   | " + total);
                System.out.println("|---------------------------------|\n");
                scanner.nextLine();

            }
        }
    }
}