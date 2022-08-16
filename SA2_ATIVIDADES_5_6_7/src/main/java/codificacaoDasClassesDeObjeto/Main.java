package codificacaoDasClassesDeObjeto;

import criacaoDeAcessoParaManipulacaoDeDados.CarrinhoDAO;
import criacaoDeAcessoParaManipulacaoDeDados.ProdutosDAO;

public class Main {
    public static void main(String[] args) {
        Carrinho c1 = new Carrinho("Clever", 120.00, 4);
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
//        carrinhoDAO.insert(c1);
        c1.setIdCarrinho(2);
        c1.setValorTotal(200.00);
//        carrinhoDAO.update(c1);
//        carrinhoDAO.deleteById(1);
        System.out.println(carrinhoDAO.selectAll());

        Produtos p1 = new Produtos("Carne",
                30.00, "2 kg", 2);
        ProdutosDAO produtosDAO = new ProdutosDAO();
//        produtosDAO.insert(p1);
        p1.setQuantidade("6,6 kg");
        p1.setValor(100.00);
        produtosDAO.update(p1);
        System.out.println(produtosDAO.selectAll());
    }
}
