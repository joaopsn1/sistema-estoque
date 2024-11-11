package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class CadastroProduto extends CompraProduto{
    private Long id;
    private static List<CadastroProduto> estoque = new ArrayList<>();

    public CadastroProduto(CompraProduto compraProduto) {
        super(compraProduto.getNome(), compraProduto.getDescricao(), compraProduto.getQuantidade(), compraProduto.getPrecoCompra());
        this.id = ThreadLocalRandom.current().nextLong(0, 1000);
    }

    public void adicionarProdutoEstoque() {
        CadastroProduto produtoExistente = verificarSeProdutoExiste(this.nome, this.descricao);
        if (produtoExistente != null) {
            produtoExistente.setQuantidade(produtoExistente.getQuantidade() + this.getQuantidade());
        } else {
            estoque.add(this);
            System.out.println("Produto cadastrado com sucesso. Id de Cadastro: " + this.id);
        }
    }

    private CadastroProduto verificarSeProdutoExiste(String nome, String descricao) {
        for (CadastroProduto produto : estoque) {
            if (produto.getNome().equalsIgnoreCase(nome) && produto.getDescricao().equalsIgnoreCase(descricao)) {
                return produto;
            }
        }
        return null;
    }

    public static void exibirEstoque() {
        System.out.println("Estoque Atual:");
        for (CadastroProduto produto : estoque) {
            System.out.println(produto);
        }
    }

    public void removerDoEstoque(int quantidadeParaRemover) {
        CadastroProduto produtoNoEstoque = verificarSeProdutoExiste(this.getNome(), this.getDescricao());
        if (produtoNoEstoque != null) {
            if (produtoNoEstoque.getQuantidade() > quantidadeParaRemover) {
                produtoNoEstoque.setQuantidade(produtoNoEstoque.getQuantidade() - quantidadeParaRemover);
                System.out.println("Quantidade atualizada: " + produtoNoEstoque.getQuantidade());
            } else if (produtoNoEstoque.getQuantidade() == quantidadeParaRemover) {
                estoque.remove(produtoNoEstoque);
                System.out.println("Produto removido do estoque.");
            } else {
                System.out.println("Erro: Quantidade para remover maior que a disponível.");
            }
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CadastroProduto produto = (CadastroProduto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Produto: " + getNome() +
                "\nDescricao= " + getDescricao() +
                "\nQuantidade= " + getQuantidade() +
                "\nPreço de Compra= " + getPrecoCompra() +
                "\nId de Cadastro: " + id;
    }
}
