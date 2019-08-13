package br.ifpb.pos.infra;

import br.ifpb.pos.domain.Produtos;
import br.ifpb.pos.domain.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JuliermeH
 */
@Stateless
public class ProdutosEmJPA implements Produtos {
    
     @PersistenceContext
    private EntityManager em;
    
     @Override
    public void novo(Produto produto){
        em.persist(produto);
    }

     @Override
    public Produto localizarPorDescricao(String descricao){
        return em.find(Produto.class,descricao);
    }

     @Override
    public List<Produto> todosProdutos() {
        return em.createQuery("FROM Produto p",Produto.class)
            .getResultList();
    }
    
}
