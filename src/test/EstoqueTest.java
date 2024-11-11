package test;

import domain.CompraProduto;
import domain.CadastroProduto;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class EstoqueTest {
    public static void main(String[] args) {
        Locale localeDefault = Locale.getDefault();
        NumberFormat nfa = NumberFormat.getCurrencyInstance(localeDefault);

        CompraProduto produto1 = new CompraProduto("Parafuso", "3/4\"", 100, 150);
        CadastroProduto cadastro1 = new CadastroProduto(produto1);
        cadastro1.adicionarProdutoEstoque();

        CompraProduto produto2 = new CompraProduto("Parafuso", "3/4\"", 100, 150);
        CadastroProduto cadastro2 = new CadastroProduto(produto2);
        cadastro2.adicionarProdutoEstoque();

        CadastroProduto.exibirEstoque();
        cadastro2.removerDoEstoque(50);
        System.out.println("-----------------------");
        CadastroProduto.exibirEstoque();

    }
}
