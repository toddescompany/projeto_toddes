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
@Table(name="tb_tema") //cria uma tabela com o nome tb_usuario dentro do banco de dados
public class Tema {
	
	//atributos
		@Id //determina a chave primaria	
		@GeneratedValue(strategy = GenerationType.IDENTITY) //determina auto increment
		private long idTema;
		
		@NotNull //determina que o atributo não pode ser nulo
		@Size(min=1, max=255) //define o tamanho do atributo
		private String nomeTema; 
		
		@NotNull //determina que o atributo não pode ser nulo
		@Size(min=1, max=500) //define o tamanho do atributo
		private String descricao;
		
		@NotNull //determina que o atributo não pode ser nulo
		@Size(min=1, max=255) //define o tamanho do atributo
		private String subtemaTema;
		
		@OneToMany(mappedBy="fk_tema", cascade=CascadeType.ALL) //chave estrangeira
		@JsonIgnoreProperties("fk_tema")
		private List<Postagem> postagem; //cria uma lista com todas as postagens com o tema*/

		//encapsulamento
		
		

		public long getIdTema() {
			return idTema;
		}

		public void setIdTema(long idTema) {
			this.idTema = idTema;
		}

		public String getNomeTema() {
			return nomeTema;
		}

		public void setNomeTema(String nomeTema) {
			this.nomeTema = nomeTema;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getSubtemaTema() {
			return subtemaTema;
		}

		public void setSubtemaTema(String subtemaTema) {
			this.subtemaTema = subtemaTema;
		}


		public List<Postagem> getPostagem() {
			return postagem;
		}

		public void setPostagem(List<Postagem> postagem) {
			this.postagem = postagem;
		}


}
