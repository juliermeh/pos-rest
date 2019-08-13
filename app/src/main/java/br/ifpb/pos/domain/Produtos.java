package br.ifpb.pos.domain;

import java.util.List;

/**
 *
 * @author JuliermeH
 */
public interface Produtos {
    
    public void novo(Produto produto);

    public Produto localizarPorDescricao(String descricao);

    public List<Produto> todosProdutos();
    
}
