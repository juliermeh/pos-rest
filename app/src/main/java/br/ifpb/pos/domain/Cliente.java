package br.ifpb.pos.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 08/08/2019, 08:19:31
 */
@Entity
@XmlRootElement
public class Cliente implements Serializable {

    @Id
    private String cpf;
    private String email;
    private String nome;

    public Cliente() {
    }

    public Cliente(String cpf,String email,String nome) {
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
