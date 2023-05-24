public class Comprador extends Usuario {

    private float saldo;

    public Comprador(String gmail, String senha) {
        super(gmail, senha);
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}