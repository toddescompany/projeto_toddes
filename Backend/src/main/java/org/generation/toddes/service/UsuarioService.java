package org.generation.toddes.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generation.toddes.model.UserLogin;
import org.generation.toddes.model.Usuario;
import org.generation.toddes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	public Usuario CadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(usuario.getSenha_usuario());
		usuario.setSenha_usuario(senhaEncoder);
		
		return repository.save(usuario);
	}

	public Optional<UserLogin> Logar(Optional<UserLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByUsuario(user.get().getEmail_usuario());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha_usuario(), usuario.get().getSenha_usuario())) {

				String auth = user.get().getEmail_usuario() + ":" + user.get().getSenha_usuario();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);
				user.get().setNome_usuario(usuario.get().getNome_usuario());

				return user;
			}
		}

		return null;
	}
}