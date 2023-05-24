public class Usuario {
    private String gmail;
    private String senha;

    // Obriga o usuario a ter um username e senha para registrar um novo usuario
    public Usuario(String gmail, String senha) {
        this.gmail = gmail;
        this.senha = senha;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

}
