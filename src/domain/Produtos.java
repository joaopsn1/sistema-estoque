package domain;


import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Produtos {
    private String nome;
    private String descricao;
    private double precoCompra;
    private double precoVenda;
    private Long id;
    private int quantidade;
    Locale localeDefault = Locale.getDefault();
    NumberFormat nfa = NumberFormat.getCurrencyInstance(localeDefault);
    Scanner scanner = new Scanner(System.in);

    public Produtos(String nome, int quantidade) {
        this.nome = nome;
        this.id = ThreadLocalRandom.current().nextLong(0, 1000);
        this.quantidade = quantidade;
    }

    public void adicionarProdutoEstoque() {
        System.out.print("Descrição do Produto: ");
        this.descricao = scanner.nextLine();
        System.out.print("Preço de Compra Unitário do Produto: R$ ");
        this.precoCompra = scanner.nextDouble();
        Map<String, Double> descricaoPreco = new HashMap<>();
        descricaoPreco.put(descricao, precoCompra);
        for (Map.Entry<String, Double> entry : descricaoPreco.entrySet()) {
            System.out.println("Descrição: " + entry.getKey() + "\"\nPreço de Compra: " + nfa.format(entry.getValue()));
        }
    }

    public void verificarEstoque() {
        if (this.quantidade == 0) {
            System.out.println("Não há em estoque!");
        } else {
            System.out.println("Produto: " + this.nome + " / Descrição: " + this.descricao + "\" / Quantidade: " + this.quantidade + " un");
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
                '}';
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
