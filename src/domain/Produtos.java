package domain;


import java.text.NumberFormat;
import java.util.*;

public class Produtos {
    private static List<Produtos> produtoList = new ArrayList<>();
    private String nome;
    private String descricao;
    private double precoCompra;
    private double precoVenda;
    private Long id;
    private int quantidade;
    Locale localeDefault = Locale.getDefault();
    NumberFormat nfa = NumberFormat.getCurrencyInstance(localeDefault);

    public Produtos(Long id, String nome, String descricao, int quantidade) {
        this.nome = nome;
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public void adicionarProdutoEstoqueID(Produtos produtos) {
        produtoList.add(produtos);
    }

    public static void verificarEstoque() {
        if (produtoList.isEmpty()) {
            System.out.println("Não há em estoque!");
        } else {
            System.out.println(produtoList);
        }
    }

    public double valorProdutoEstoque() {
        return this.precoCompra * this.quantidade;
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", precoCompra=" + precoCompra +
                ", precoVenda=" + precoVenda +
                ", id=" + id +
                ", quantidade=" + quantidade +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produtos produtos = (Produtos) o;
        return Objects.equals(id, produtos.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
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
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void quantidadeEstoque() {

    }
}
