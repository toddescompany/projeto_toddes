package org.generation.toddes.repository;

import java.util.List;

import org.generation.toddes.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
	List<Tema> findAllByDescricaoTemaContainingIgnoreCase(String descricaoTema);
}
