package org.generation.toddes.model;

public class UserLogin {
	
	private long id;
	
	private String emailUsuario;
	
	private String nomeUsuario;
	
	private String senhaUsuario;
	
	private String token;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	//ecaps
	
	
	
	
	

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	
}
