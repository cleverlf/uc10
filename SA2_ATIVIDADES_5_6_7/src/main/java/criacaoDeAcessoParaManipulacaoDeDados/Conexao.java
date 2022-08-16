package criacaoDeAcessoParaManipulacaoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Conexao {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/coma_bem";
    public static final String USER = "root";
    public static final String PASS = "root";

    //     Fazendo a conexao com o bando de dados mysql
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Erro na conexão com o banco de dados", ex);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados", ex);
        }
    }

    //       Fechando a conexao e o preparedstatement
    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados", ex);
        }
    }

    //        Fechando a conexao, preparedstatement e o resultset
    public static void closeConnection(Connection connection,
                                       PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados", ex);
        }
    }
}
