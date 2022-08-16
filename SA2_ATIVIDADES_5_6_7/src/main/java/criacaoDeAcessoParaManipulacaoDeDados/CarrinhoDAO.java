package criacaoDeAcessoParaManipulacaoDeDados;

import codificacaoDasClassesDeObjeto.Carrinho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDAO {
    //    Faz o insert de dados na tabela carrinho
    public void insert(Carrinho carrinho) {

        String sql = "INSERT INTO carrinho (nomeCliente,"
                + "valorTotal,"
                + "qtdProdutos)"
                + "VALUES (?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = Conexao.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, carrinho.getNomeCliente());
            statement.setDouble(2, carrinho.getValorTotal());
            statement.setInt(3, carrinho.getQtdProdutos());

            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar carrinho"
                    + ex.getMessage(), ex);
        } finally {
            Conexao.closeConnection(connection, statement);
        }

    }

    //    Faz o update dos dados na tabela carrinho de acordo com o id do carrinho
    public void update(Carrinho carrinho) {

        String sql = "UPDATE carrinho " +
                "SET nomeCliente = ?," +
                " valorTotal = ?," +
                " qtdProdutos = ?" +
                " WHERE idCarrinho = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = Conexao.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, carrinho.getNomeCliente());
            statement.setDouble(2, carrinho.getValorTotal());
            statement.setInt(3, carrinho.getQtdProdutos());
            statement.setInt(4, carrinho.getIdCarrinho());

            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar carrinho"
                    + ex.getMessage(), ex);
        } finally {
            Conexao.closeConnection(connection, statement);
        }

    }

    //    Faz o delete de um dado especifico atraves de seu id
    public void deleteById(int idCarrinho) {

        String sql = "DELETE FROM carrinho WHERE idCarrinho = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = Conexao.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idCarrinho);
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar carrinho"
                    + ex.getMessage());
        } finally {
            Conexao.closeConnection(connection, statement);
        }
    }

    //    Seleciona uma lista de todos os carrinhos da tabela
    public List<Carrinho> selectAll() {

        String sql = "SELECT * FROM carrinho";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Carrinho> carrinhos = new ArrayList<Carrinho>();

        try {

            connection = Conexao.getConnection();
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Carrinho carrinho = new Carrinho();
                carrinho.setIdCarrinho(resultSet.getInt("idCarrinho"));
                carrinho.setNomeCliente(resultSet.getString("nomeCliente"));
                carrinho.setValorTotal(resultSet.getDouble("valorTotal"));
                carrinho.setQtdProdutos(resultSet.getInt("qtdProdutos"));
                carrinhos.add(carrinho);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao selecionar carrinho"
                    + ex.getMessage());
        } finally {
            Conexao.closeConnection(connection, statement, resultSet);
        }

        return carrinhos;

    }
}
