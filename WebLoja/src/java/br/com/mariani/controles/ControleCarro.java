package br.com.mariani.controles;

import br.com.mariani.dao.DaoCarro;
import br.com.mariani.modelos.Carro;
import com.google.gson.Gson;
import java.sql.SQLException;

/**
 *
 * @author maryucha
 */
public class ControleCarro {

    /*----------------------------------------------*/
    static final Gson GSON = new Gson();
    
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
}
