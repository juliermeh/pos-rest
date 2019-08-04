package br.edu.ifpb.domain.cliente;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 04/08/2019, 18:07:55
 */
@Stateless
public class ServiceClientes {

    @EJB
    private Clientes clientes;

    // Usado para capturar os erros, problemas nas transações
    public void novo(Cliente cliente) {
        this.clientes.novo(cliente);
    }

    public List<Cliente> todos() {
        return this.clientes.todos();
    }

}
