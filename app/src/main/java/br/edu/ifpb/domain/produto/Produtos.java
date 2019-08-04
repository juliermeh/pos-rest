package br.edu.ifpb.domain.produto;

import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 08/05/2019, 11:29:06
 */
public interface Produtos {

    void novo(Produto cliente);

    List<Produto> todos();

}
