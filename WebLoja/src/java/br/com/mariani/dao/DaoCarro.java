package br.com.mariani.dao;

import br.com.mariani.conexao.ConnectionFactory;
import br.com.mariani.modelos.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maryucha
 */
public class DaoCarro {

    private Connection con = null;

    public DaoCarro() {
        con = ConnectionFactory.getConnection();
    }

    /*------------------------------------------------------------*/
    public void addCarroNoBanco(Carro carro) throws SQLException {
        String sql = "insert into carro (renavan,modelo,montadora,cor,ano,preco,situacao) values(?,?,?,?,?,?,?)";
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, carro.getRenavan());
            stm.setString(2, carro.getModelo());
            stm.setString(3, carro.getMontadora());
            stm.setString(4, carro.getCor());
            stm.setInt(5, carro.getAno());
            stm.setDouble(6, carro.getPreco());
            stm.setBoolean(7, carro.isSituacao());
            stm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro salvar no banco " + e);
        } finally {
            ConnectionFactory.fecharConexao(con, stm);
        }
    }

    /*------------------------------------------------------------*/
    public List<Carro> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM carro";

        List<Carro> list = new ArrayList<>();

        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Carro carro = new Carro();
                carro.setRenavan(rs.getString("renavan"));
                carro.setModelo(rs.getString("modelo"));
                carro.setMontadora(rs.getString("montadora"));
                carro.setCor(rs.getString("cor"));
                carro.setAno(rs.getInt("ano"));
                carro.setPreco(rs.getDouble("preco"));
                carro.setSituacao(rs.getBoolean("situacao"));
                carro.setRenavan(rs.getString("renavan"));
                list.add(carro);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar lista do banco. " + e);
        } finally {
            ConnectionFactory.fecharConexao(con, stm, rs);
        }
        return list;
    }

    /*------------------------------------------------------------*/
    public List<Carro> pegarDisponiveis() throws SQLException {
        String sql = "SELECT * FROM carro where situacao = true";

        List<Carro> list = new ArrayList<>();

        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Carro carro = new Carro();
                carro.setRenavan(rs.getString("renavan"));
                carro.setModelo(rs.getString("modelo"));
                carro.setMontadora(rs.getString("montadora"));
                carro.setCor(rs.getString("cor"));
                carro.setAno(rs.getInt("ano"));
                carro.setPreco(rs.getDouble("preco"));
                carro.setRenavan(rs.getString("renavan"));
                carro.setSituacao(rs.getBoolean("situacao"));
                list.add(carro);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar lista do banco. " + e);
        } finally {
            ConnectionFactory.fecharConexao(con, stm, rs);
        }
        return list;
    }

    /*------------------------------------------------------------*/
    public void updateCarro(int id, Carro carro) throws SQLException {
        String sql = "update carro set renavan = ?, modelo =?, montadora=?, cor =?, ano = ?, preco = ?, situacao =? where id = ?";

        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, carro.getRenavan());
            stm.setString(2, carro.getModelo());
            stm.setString(3, carro.getMontadora());
            stm.setString(4, carro.getCor());
            stm.setInt(5, carro.getAno());
            stm.setDouble(6, carro.getPreco());
            stm.setBoolean(7, carro.isSituacao());
            stm.setInt(8, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o banco. " + e);
        } finally {
            ConnectionFactory.fecharConexao(con, stm);
        }
    }

    /*------------------------------------------------------------*/
    public Carro buscarNoBancoPeloId(int id) throws SQLException {
        String sql = "select * from carro where id = ?";
        PreparedStatement stm = null;
        ResultSet rs = null;
        Carro carro = new Carro();

        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            if (rs.next()) {
                carro.setRenavan(rs.getString("renavan"));
                carro.setModelo(rs.getString("modelo"));
                carro.setMontadora(rs.getString("montadora"));
                carro.setCor(rs.getString("cor"));
                carro.setAno(rs.getInt("ano"));
                carro.setPreco(rs.getDouble("preco"));
                carro.setSituacao(rs.getBoolean("situacao"));
                carro.setRenavan(rs.getString("renavan"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar o Carro no banco. " + e);
        } finally {
            ConnectionFactory.fecharConexao(con, stm, rs);
        }
        return carro;
    }

    /*------------------------------------------------------------*/
    public void deletarCarro(int id) throws SQLException {
        String sql = "DELETE FROM carro WHERE id = ?";

        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);

            stm.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Deu erro em excluir do banco." + e);
        } finally {
            ConnectionFactory.fecharConexao(con, stm);
        }
    }

}
