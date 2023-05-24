import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Login {
    private String email;
    private String senha;

    Scanner scanner = new Scanner(System.in);
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public void login() {
        System.out.println("Digite o email: ");
        email = scanner.nextLine();
        System.out.println("Digite a senha: ");
        senha = scanner.nextLine();

        if (validarLogin(email, senha)) {
            System.out.println("Login Realizado");
        } else {
            System.out.println("Email ou Senha invalidos");
        }
    }

    private boolean validarLogin(String email, String senha) {

        for (Usuario user : usuarios) {
            if (user.getSenha().equals(senha) && user.getGmail().equals(email)) {
                return true;
            }
        }
        return false;

    }

}
