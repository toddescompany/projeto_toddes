package org.generation.toddes.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //define que a classe é uma entidade
@Table(name="tb_usuario") //cria uma tabela com o nome tb_usuario dentro do banco de dados
public class Usuario {
    
    //atributos
    @Id //determina a chave primaria    
    @GeneratedValue(strategy = GenerationType.IDENTITY) //determina auto increment
    private long id;
    
    @NotBlank(message = "O atributo emailUsuario é obrigatorio") //determina que o atributo não pode ser nulo
    @Size(min=1, max=255) //define o tamanho do atributo
    private String emailUsuario; 
    
    //O LOGIN ATUALMENTE É FEITO ATRAVÉS DO NOME DE USUÁRIO POR ISSO
    //NÃO VAMOS INCLUIR AS ANOTATIONS @ApiModelProperty E @Email
    
    @NotBlank(message = "O atributo nomeUsuario é obrigatorio") //determina que o atributo não pode ser nulo
    @Size(min=1, max=255) //define o tamanho do atributo
    private String nomeUsuario;
    
    @NotBlank(message = "O atributo senhaUsuario é obrigatorio") //determina que o atributo não pode ser nulo
    @Size(min=6, max=255, message = "Descrição deve conter no mínimo 6 caracteres.") //define o tamanho da senha minimo 6
    private String senhaUsuario; 
    
    private String foto;
    
    private String tipo;
    
    @OneToMany(mappedBy="fk_usuario", cascade=CascadeType.ALL) //chave estrangeira
    @JsonIgnoreProperties("fk_usuario")
    private List<Postagem> postagem; //cria uma lista com todas as postagens do usuario

    //encapsulamento


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


}