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
		private long id_postagem;
		
		@NotNull //determina que o atributo não pode ser nulo
		@Size(min=1, max=255) //define o tamanho do atributo
		private String nome_tema; 
		
		@NotNull //determina que o atributo não pode ser nulo
		@Size(min=1, max=500) //define o tamanho do atributo
		private String descricao_tema;
		
		@NotNull //determina que o atributo não pode ser nulo
		@Size(min=1, max=255) //define o tamanho do atributo
		private String subtema_tema; 
		
		/*@OneToMany(mappedBy="fk_tema", cascade=CascadeType.ALL) //chave estrangeira
		@JsonIgnoreProperties("fk_tema")
		private List<Postagem> postagem; //cria uma lista com todas as postagens com o tema*/

		//encapsulamento
		public long getId_postagem() {
			return id_postagem;
		}

		public void setId_postagem(long id_postagem) {
			this.id_postagem = id_postagem;
		}

		public String getNome_tema() {
			return nome_tema;
		}

		public void setNome_tema(String nome_tema) {
			this.nome_tema = nome_tema;
		}

		public String getDescricao_tema() {
			return descricao_tema;
		}

		public void setDescricao_tema(String descricao_tema) {
			this.descricao_tema = descricao_tema;
		}

		public String getSubtema_tema() {
			return subtema_tema;
		}

		public void setSubtema_tema(String subtema_tema) {
			this.subtema_tema = subtema_tema;
		}

		/*public List<Postagem> getPostagem() {
			return postagem;
		}

		public void setPostagem(List<Postagem> postagem) {
			this.postagem = postagem;
		}*/


}
