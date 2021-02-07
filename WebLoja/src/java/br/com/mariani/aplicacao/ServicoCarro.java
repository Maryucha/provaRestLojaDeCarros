package br.com.mariani.aplicacao;

import br.com.mariani.controles.ControleCarro;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author maryucha
 * 
 * *********ROTAS******
 * ADD CARRO > http://localhost:8080/WebLoja/carro
 * DELETAR CARRO > http://localhost:8080/WebLoja/carro/{ID}
 * ATUALIZAR CARRO > http://localhost:8080/WebLoja/carro/{ID}
 * BUSCAR CARRO > http://localhost:8080/WebLoja/carro/{ID}
 * BUSCAR TODOS > http://localhost:8080/WebLoja/carro
 * 
 * CORPO PARA TESTE
 *   {
    "renavan": "rdgs1254",
    "modelo": "saveiro",
    "montadora": "vw",
    "cor": "vermelha",
    "ano": 2013,
    "preco": 25255.0,
    "situacao": false
  }
 * 
 * 
 */
@Path("/carro")
public class ServicoCarro {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApiResource
     */
    public ServicoCarro() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listarCarros() throws SQLException {
        return ControleCarro.listarCarros();
    }

    /*----------------------------------------------*/
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarPeloId(@PathParam("id") int id) throws SQLException {
        return ControleCarro.pegarCarroPeloId(id);
    }
    /*----------------------------------------------*/
    @GET
    @Path("/trazerlucro")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLucro() throws SQLException{
        return ControleCarro.lucroSobreCarrosVendidos();
    }
    /*----------------------------------------------*/
    @GET
    @Path("/listardisponiveis")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String buscarOsDisponiveis() throws SQLException{
        return ControleCarro.pegarOsDisponiveis();
    }
    /*----------------------------------------------*/
    @GET
    @Path("/taxalucro")
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarTaxaLucro() throws SQLException{
        return ControleCarro.mostraTaxa();
    }
    /*----------------------------------------------*/
    @PUT
    @Path("/updatetaxalucro/{lucropassado}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String editarCarroPeloId(@PathParam("lucropassado") double lucropassado) throws SQLException {
        String resposta = ControleCarro.atualizarTaxa(lucropassado);
        return resposta;
    }
    /*----------------------------------------------*/
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addNovo(String body) throws SQLException {
        ControleCarro.addNovonoBanco(body);
        return body;
    }

    /*----------------------------------------------*/
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String editarCarroPeloId(@PathParam("id") int id, String content) throws SQLException {
        ControleCarro.atualizarCarro(id, content);
        return content;
    }
    /*----------------------------------------------*/
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void deletarCarro(@PathParam("id") int id) throws SQLException {
        ControleCarro.deletarCarro(id);
    }
    /*----------------------------------------------*/
    
    
}
