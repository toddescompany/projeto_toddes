package org.generation.toddes.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //define que a classe é uma entidade
@Table(name="tb_usuario") //cria uma tabela com o nome tb_usuario dentro do banco de dados
public class Usuario {
    
    //atributos
    @Id //determina a chave primaria    
    @GeneratedValue(strategy = GenerationType.IDENTITY) //determina auto increment
    private long id_postagem;
    
    @NotNull //determina que o atributo não pode ser nulo
    @Size(min=1, max=255) //define o tamanho do atributo
    private String email_usuario; 
    
    @NotNull //determina que o atributo não pode ser nulo
    @Size(min=1, max=255) //define o tamanho do atributo
    private String nome_usuario;
    
    @NotNull //determina que o atributo não pode ser nulo
    @Size(min=6, max=255) //define o tamanho da senha minimo 6
    private String senha_usuario; 
    
    @OneToMany(mappedBy="fk_usuario", cascade=CascadeType.ALL) //chave estrangeira
    @JsonIgnoreProperties("fk_usuario")
    private List<Postagem> postagem; //cria uma lista com todas as postagens do usuario

    //encapsulamento
    public long getId_postagem() {
        return id_postagem;
    }

    public void setId_postagem(long id_postagem) {
        this.id_postagem = id_postagem;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

    public List<Postagem> getPostagem() {
        return postagem;
    }

    public void setPostagem(List<Postagem> postagem) {
        this.postagem = postagem;
    }


}