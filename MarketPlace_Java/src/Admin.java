public class Admin extends Usuario {

    private String admkey;

    public String getAdmkey() {
        return admkey;
    }

    public void setAdmkey(String admkey) {
        this.admkey = admkey;
    }

    public Admin(String gmail, String senha) {
        super(gmail, senha);
    }

}
