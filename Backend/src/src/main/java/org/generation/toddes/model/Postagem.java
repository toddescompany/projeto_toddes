package org.generation.toddes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity //define que a classe é uma entidade
@Table(name="tb_postagem") //cria uma tabela com o nome tb_postagem dentro do banco de dados
public class Postagem {
    
    //atributos
    @Id //determina a chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //determina auto increment
    private long id_postagem;
    
    @NotNull(message = "Título obrigatório.") //determina que o atributo não pode ser nulo
    @Size(min=1, max=255) //define o tamanho do atributo
    private String tituloPostagem; 

    @NotNull(message = "Texto obrigatório.") //determina que o atributo não pode ser nulo
    @Size(min=1, max=1000, message = "Descrição deve conter entr 1 e 1000 caracteres.") //define o tamanho do atributo
    private String texto_postagem;
    
    @Temporal(TemporalType.TIMESTAMP) //define a data atual do sistema
    private Date data_postagem = new java.sql.Date(System.currentTimeMillis());
    
    @Column(name="anonimo_postagem",nullable=false) //determina se a postagem é anonima ou não
    private boolean anonimo_postagem = false;
    
    private String imagem;
    
    @ManyToOne //chave estrangeira
    @JsonIgnoreProperties("postagem")
    private Tema fk_tema;

    @ManyToOne //relacionamentos muitos para um
    @JsonIgnoreProperties("postagem")
    private Usuario fk_usuario;

    //encapsulamento
    public long getId_postagem() {
        return id_postagem;
    }

    public void setId_postagem(long id_postagem) {
        this.id_postagem = id_postagem;
    }

    public String getTituloPostagem() {
		return tituloPostagem;
	}

	public void setTituloPostagem(String tituloPostagem) {
		this.tituloPostagem = tituloPostagem;
	}

	public String getTexto_postagem() {
        return texto_postagem;
    }

    public void setTexto_postagem(String texto_postagem) {
        this.texto_postagem = texto_postagem;
    }

    public Date getData_postagem() {
        return data_postagem;
    }

    public void setData_postagem(Date data_postagem) {
        this.data_postagem = data_postagem;
    }

    public boolean isAnonimo_postagem() {
        return anonimo_postagem;
    }

    public void setAnonimo_postagem(boolean anonimo_postagem) {
        this.anonimo_postagem = anonimo_postagem;
    }

    public Tema getFk_tema() {
        return fk_tema;
    }

    public void setFk_tema(Tema fk_tema) {
        this.fk_tema = fk_tema;
    }

    public Usuario getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(Usuario fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
        

}