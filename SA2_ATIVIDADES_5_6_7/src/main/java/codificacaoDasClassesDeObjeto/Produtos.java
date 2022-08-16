package codificacaoDasClassesDeObjeto;

public class Produtos {
    private int idProduto;
    private String nomeProduto;
    private double valor;
    private String quantidade;
    private int idCarrinho;

    public Produtos() {
    }

    public Produtos(String nomeProduto, double valor, String quantidade, int idCarrinho) {

        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.quantidade = quantidade;
        this.idCarrinho = idCarrinho;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "idProduto=" + idProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", valor=" + valor +
                ", quantidade='" + quantidade + '\'' +
                ", idCarrinho=" + idCarrinho +
                '}';
    }
}
