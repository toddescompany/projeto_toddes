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
    private long idPostagem;
    
    @NotNull //determina que o atributo não pode ser nulo
    @Size(min=1, max=255) //define o tamanho do atributo
    private String emailUsuario; 
    
    @NotNull //determina que o atributo não pode ser nulo
    @Size(min=1, max=255) //define o tamanho do atributo
    private String nomeUsuario;
    
    @NotNull //determina que o atributo não pode ser nulo
    @Size(min=6, max=255, message = "Descrição deve conter no mínimo 6 caracteres.") //define o tamanho da senha minimo 6
    private String senhaUsuario; 
    
    @OneToMany(mappedBy="fk_usuario", cascade=CascadeType.ALL) //chave estrangeira
    @JsonIgnoreProperties("fk_usuario")
    private List<Postagem> postagem; //cria uma lista com todas as postagens do usuario

    //encapsulamento
    

   
    public long getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(long idPostagem) {
		this.idPostagem = idPostagem;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	
	public List<Postagem> getPostagem() {
	        return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
        this.postagem = postagem;
    }


}