public class Anunciante extends Usuario {

    private int cpf;
    private String endereco;
    private int produtosVenda;

    public int getProdutosVenda() {
        return produtosVenda;
    }

    public void setProdutosVenda(int produtosVenda) {
        this.produtosVenda = produtosVenda;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Anunciante(String gmail, String senha) {
        super(gmail, senha);
    }
}
