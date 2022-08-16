package codificacaoDasClassesDeObjeto;

public class Carrinho {
    private int idCarrinho;
    private String nomeCliente;
    private double valorTotal;
    private int qtdProdutos;

    public Carrinho() {
    }

    public Carrinho(String nomeCliente, double valorTotal, int qtdProdutos) {

        this.nomeCliente = nomeCliente;
        this.valorTotal = valorTotal;
        this.qtdProdutos = qtdProdutos;
    }

    public int getIdCarrinho() {
        return this.idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "idCarrinho=" + idCarrinho +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", valorTotal=" + valorTotal +
                ", qtdProdutos=" + qtdProdutos +
                '}';
    }
}
