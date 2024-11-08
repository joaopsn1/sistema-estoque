package test;

import domain.Produtos;

import java.text.NumberFormat;
import java.util.Locale;

public class EstoqueTest {
    public static void main(String[] args) {
        Locale localeDefault = Locale.getDefault();
        NumberFormat nfa = NumberFormat.getCurrencyInstance(localeDefault);

        Produtos produtos = new Produtos(1L, "Parafuso", "3/4\"", 100);
        Produtos produtos1 = new Produtos(2L, "Porca", "3/4\"", 100);
        produtos.adicionarProdutoEstoqueID(produtos);
        produtos1.adicionarProdutoEstoqueID(produtos1);
        Produtos.verificarEstoque();
//        System.out.println(nfa.format(produtos.valorProdutoEstoque()));
    }
}
