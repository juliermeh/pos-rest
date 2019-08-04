package br.edu.ifpb.domain.produto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 04/08/2019, 18:24:47
 */
@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String descricao;

    public Produto() {
    }

    public Produto(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
