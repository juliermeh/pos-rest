package br.ifpb.pos.api;

import br.ifpb.pos.application.ServiceDeClientes;
import br.ifpb.pos.domain.Cliente;
import java.net.URI;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 08/08/2019, 08:31:48
 */
@Stateless
// localhos:8080/app/api/clientes
@Path("clientes")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ResoucesClientes {

    @Inject
    private ServiceDeClientes service;

    @GET
    public Response todosOsClientes() {
        List<Cliente> clientes = this.service.clientes();

        GenericEntity<List<Cliente>> entity = new GenericEntity<List<Cliente>>(
            clientes) {
        };
        return Response.ok()
            .entity(entity)
            .build();
    }

    // localhos:8080/app/api/clientes/123
    @GET
    @Path("{cpf}")
    public Response clienteCPF(@PathParam("cpf") String cpf) {
//        Cliente cliente = new Cliente("123","eamil@com","kiko");
        Cliente cliente = this.service.localizaClientePorCPF(cpf);
        return Response.ok()
            .entity(cliente)
            .build();
    }

    @POST
    public Response novo(JsonObject object) {

        this.service.criarNovoCliente(
            object.getString("cpf"),
            object.getString("email"),
            object.getString("nome")
        );
        String uri = "http://localhost:8080/app/api/clientes/" + object.getString("cpf");
        return Response.created(
            URI.create(uri)
        ).build();
    }
}
