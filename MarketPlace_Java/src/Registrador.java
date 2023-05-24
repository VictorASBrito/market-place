import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Registrador {
    private String email;
    private String senha;

    Scanner scanner = new Scanner(System.in);
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public void registra() {
        System.out.println("Digite o email a ser registrado: ");
        email = scanner.next();
        System.out.println("Digite a senha: ");
        senha = scanner.next();
        Usuario usuario = new Usuario(email, senha);
        usuarios.add(usuario);
        System.out.println("Usuário registrado.");
    }
}