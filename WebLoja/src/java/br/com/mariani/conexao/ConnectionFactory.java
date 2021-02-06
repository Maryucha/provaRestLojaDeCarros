package br.com.mariani.conexao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;


/**
 *
 * @author maryucha
 */
public class ConnectionFactory {
      private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/db_lojacarro";

    private static final String USER = "postgres";
    private static final String PASS = "191007";

    public static Connection getConnection() {

        try {

            Class.forName(DRIVER);
            System.out.println("conectou");
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException("Erro na conexão.", ex);

        }

    }

    public static void fecharConexao(Connection con) throws SQLException {
        try {
            if (con != null) {
                con.close();

            }
        } catch (SQLException e) {
            System.err.println("Conexão aberta");
        }

    }

    public static void fecharConexao(Connection con, PreparedStatement stm) throws SQLException {
        try {
            if (stm != null) {
                stm.close();
            }
            fecharConexao(con);
        } catch (SQLException e) {
            System.err.println("Conexão aberta");
        }

    }

    public static void fecharConexao(Connection con, PreparedStatement stm, ResultSet rs) throws SQLException {
        try {
            if (rs != null) {
                rs.close();
            }
            fecharConexao(con, stm);
        } catch (SQLException e) {
            System.err.println("Conexão aberta");
        }

    }  
}
