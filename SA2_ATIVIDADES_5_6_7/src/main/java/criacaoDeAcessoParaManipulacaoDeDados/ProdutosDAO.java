package criacaoDeAcessoParaManipulacaoDeDados;

import codificacaoDasClassesDeObjeto.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {
    //    Faz o insert de dados na tabela produtos
    public void insert(Produtos produtos) {

        String sql = "INSERT INTO produtos (nomeProduto,"
                + "valor,"
                + "quantidade,"
                + "carrinho_idCarrinho)"
                + " VALUES (?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = Conexao.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, produtos.getNomeProduto());
            statement.setDouble(2, produtos.getValor());
            statement.setString(3, produtos.getQuantidade());
            statement.setInt(4, produtos.getIdCarrinho());

            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar o produto"
                    + ex.getMessage(), ex);
        } finally {
            Conexao.closeConnection(connection, statement);
        }

    }

    //    Faz o update dos dados na tabela produtos de acordo com o id do produto
    public void update(Produtos produtos) {

        String sql = "UPDATE produtos SET "
                + "nomeProduto = ?, "
                + "valor = ?, "
                + "quantidade = ?, "
                + "Carrinho_idCarrinho = ? "
                + "WHERE idProdutos = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = Conexao.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, produtos.getNomeProduto());
            statement.setDouble(2, produtos.getValor());
            statement.setString(3, produtos.getQuantidade());
            statement.setInt(4, produtos.getIdCarrinho());
            statement.setInt(5, produtos.getIdProduto());

            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar o produto"
                    + ex.getMessage(), ex);
        } finally {
            Conexao.closeConnection(connection, statement);
        }

    }

    //    Faz o delete de um dado especifico atraves de seu id
    public void deleteById(int idProduto) {

        String sql = "DELETE FROM produtos WHERE idProdutos = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = Conexao.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProduto);
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar produto"
                    + ex.getMessage());
        } finally {
            Conexao.closeConnection(connection, statement);
        }
    }

    //    Seleciona uma lista de todos os produtos da tabela
    public List<Produtos> selectAll() {

        String sql = "SELECT * FROM produtos";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Produtos> produtos = new ArrayList<Produtos>();

        try {

            connection = Conexao.getConnection();
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Produtos produto = new Produtos();
                produto.setIdProduto(resultSet.getInt("idProdutos"));
                produto.setNomeProduto(resultSet.getString("nomeProduto"));
                produto.setValor(resultSet.getDouble("valor"));
                produto.setQuantidade(resultSet.getString("quantidade"));
                produto.setIdCarrinho(resultSet.getInt("Carrinho_idCarrinho"));
                produtos.add(produto);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao selecionar produto"
                    + ex.getMessage());
        } finally {
            Conexao.closeConnection(connection, statement, resultSet);
        }

        return produtos;

    }
}
