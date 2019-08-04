package br.edu.ifpb.infra;

import br.edu.ifpb.domain.produto.Produto;
import br.edu.ifpb.domain.produto.Produtos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 08/05/2019, 10:33:23
 */
@Stateless
public class ProdutosEmJPA implements Produtos {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void novo(Produto prod) {
        em.persist(prod);
    }

    @Override
    public List<Produto> todos() {
        return em.createQuery("FROM Produto p",Produto.class)
            .getResultList();
    }

}
