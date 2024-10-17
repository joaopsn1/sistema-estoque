package domain;

public class CompraProduto {
    protected String nome;
    protected String descricao;
    protected int quantidade;
    protected double precoCompra;

    public CompraProduto(String nome, String descricao, int quantidade, double precoCompra) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoCompra = precoCompra;
    }

    public void exibirInformacoesProduto() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Quantidade: " + this.quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        if (precoCompra < 0) {
            throw new IllegalArgumentException("O preço de compra não pode ser negativo.");
        }
        this.precoCompra = precoCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        this.quantidade = quantidade;
    }
}
