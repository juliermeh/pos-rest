package br.ifpb.pos.application;

import br.ifpb.pos.domain.Cliente;
import br.ifpb.pos.domain.Clientes;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 08/08/2019, 08:26:38
 */
@Stateless
public class ServiceDeClientes {

    @Inject
    private Clientes clientes;

    public void criarNovoCliente(String cpf,String nome,String email) {
        // validando os parametros
        Objects.requireNonNull(cpf,"CPF precisa ser preenchido");
        //criando o objeto
        Cliente cliente = new Cliente(
            cpf,email,nome
        );
        //executando a lógica de negócio
        clientes.novo(cliente);
    }

    public List<Cliente> clientes() {
        return this.clientes.todos();
    }

    public Cliente localizaClientePorCPF(String cpf) {
        return this.clientes.localizarPorCpf(cpf);
    }
}
