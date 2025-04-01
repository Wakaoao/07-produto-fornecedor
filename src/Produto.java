public class Produto {

    private String nome;
    private double valoUnitario;
    private int qtdEstoque;
    private Fornecedor fornecedor;

    public Produto(String nomeProd, double valor, int qtd, Fornecedor fornecedor) {
        this.nome = nomeProd;
        this.valoUnitario = valor;
        this.qtdEstoque = qtd;
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValoUnitario() {
        return valoUnitario;
    }

    public void setValoUnitario(double valoUnitario) {
        this.valoUnitario = valoUnitario;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
