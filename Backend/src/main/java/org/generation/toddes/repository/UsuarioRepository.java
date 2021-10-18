package org.generation.toddes.repository;

import java.util.List;
import java.util.Optional;

import org.generation.toddes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByNomeUsuario(String nomeUsuario);
	
	public List<Usuario> findAllByNomeUsuarioContainingIgnoreCase (String nomeUsuario);
	
	//public Usuario findByNomeUsuario (String nomeUsuario);
}

