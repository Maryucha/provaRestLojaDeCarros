package br.com.mariani.controles;

import br.com.mariani.dao.DaoCarro;
import br.com.mariani.modelos.Carro;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author maryucha
 */
public class ControleCarro {

    static final Gson GSON = new Gson();
    static double valorVendas = 0;
    static double lucro = 0.15;
    static double lucroReal = 0;
    static NumberFormat nf = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    /*----------------------------------------------*/
    static public String listarCarros() throws SQLException {
        DaoCarro dao = new DaoCarro();
        return GSON.toJson(dao.buscarTodos());
    }

    /*----------------------------------------------*/
    static public String pegarCarroPeloId(int id) throws SQLException {
        DaoCarro dao = new DaoCarro();
        Carro carro = dao.buscarNoBancoPeloId(id);
        return GSON.toJson(carro);
    }

    /*----------------------------------------------*/
    static public void addNovonoBanco(String body) throws SQLException {
        DaoCarro dao = new DaoCarro();
        Carro carro = GSON.fromJson(body, Carro.class);
        dao.addCarroNoBanco(carro);
    }

    /*----------------------------------------------*/
    static public void atualizarCarro(int id, String body) throws SQLException {
        DaoCarro dao = new DaoCarro();
        pegarCarroPeloId(id);
        Carro carro = GSON.fromJson(body, Carro.class);
        dao.updateCarro(id, carro);
    }

    /*----------------------------------------------*/
    static public void deletarCarro(int id) throws SQLException {
        DaoCarro dao = new DaoCarro();

        dao.deletarCarro(id);
    }

    /*----------------------------------------------*/
    static public String pegarOsDisponiveis() throws SQLException {
        DaoCarro dao = new DaoCarro();
        return GSON.toJson(dao.pegarDisponiveis());
    }

    /*----------------------------------------------*/
    static public String lucroSobreCarrosVendidos() throws SQLException {
        DaoCarro dao = new DaoCarro();
        valorVendas = dao.buscarNoBancoValorvendido(valorVendas);
        lucroReal = valorVendas * lucro;

        String teste = "Seu lucro sobre os carros vendidos foi de R$" + nf.format(lucroReal);
        return GSON.toJson(teste);
    }

    /*----------------------------------------------*/
    static public String mostraTaxa(){
        return GSON.toJson(lucro);
    }

    static public String atualizarTaxa(double lucropassado, String content) {
        System.out.println(lucro);
        lucropassado = GSON.fromJson(content, Double.TYPE);
        System.out.println(lucropassado);
       return GSON.toJson(lucro);
       
    }
    
}
