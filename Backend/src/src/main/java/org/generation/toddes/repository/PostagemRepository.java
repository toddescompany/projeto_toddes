package org.generation.toddes.repository;

import java.util.List;

import org.generation.toddes.model.Postagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	List<Postagem> findAllByTituloPostagemContainingIgnoreCase(String tituloPostagem);
}
