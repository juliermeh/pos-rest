package br.edu.ifpb.domain.produto;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 04/08/2019, 18:07:55
 */
@Stateless
public class ServiceProdutos {

    @EJB
    private Produtos produtos;

    // Usado para capturar os erros, problemas nas transações
    public void novo(Produto prod) {
        this.produtos.novo(prod);
    }

    public List<Produto> todos() {
        return this.produtos.todos();
    }

}
