package test;

import domain.Produtos;

import java.text.NumberFormat;
import java.util.Locale;

public class EstoqueTest {
    public static void main(String[] args) {
        Locale localeDefault = Locale.getDefault();
        NumberFormat nfa = NumberFormat.getCurrencyInstance(localeDefault);

        Produtos produtos = new Produtos("Parafuso", 100);
        Produtos produtos1 = new Produtos("Porca", 100);
        produtos.adicionarProdutoEstoque();
//        produtos1.adicionarProdutoEstoque();
//        System.out.println("Valor Total Estoque: " + nfa.format(produtos.valorProdutoEstoque() + produtos1.valorProdutoEstoque()));
        produtos.verificarEstoque();
        System.out.println(nfa.format(produtos.valorProdutoEstoque()));
    }
}
