package org.generation.toddes.controller;

import java.util.List;

import org.generation.toddes.model.Postagem;
import org.generation.toddes.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*") 
public class PostagemController {
	@Autowired
	private PostagemRepository tb_postagem_from_db;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> findAll()
	{
		return ResponseEntity.ok(tb_postagem_from_db.findAll());
	}
	
	@GetMapping("/{id_postagem}")
	public ResponseEntity<Postagem> findAllById(@PathVariable long id_postagem)
	{
		return tb_postagem_from_db.findById(id_postagem).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{tituloPostagem}")
	public ResponseEntity<List<Postagem>> getByDescricao(@PathVariable String tituloPostagem)
	{
		return ResponseEntity.ok(tb_postagem_from_db.findAllByTituloPostagemContainingIgnoreCase(tituloPostagem));
	}

	@PostMapping
	public ResponseEntity<Postagem> postTema(@RequestBody Postagem json_postagem)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(tb_postagem_from_db.save(json_postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> putTema(@RequestBody Postagem json_postagem)
	{
		return ResponseEntity.status(HttpStatus.OK).body(tb_postagem_from_db.save(json_postagem));
	}
	
	@DeleteMapping("/{id_postagem}")
	public void deleteTema(@PathVariable long id_postagem)
	{
		tb_postagem_from_db.deleteById(id_postagem);
	}
	
}
