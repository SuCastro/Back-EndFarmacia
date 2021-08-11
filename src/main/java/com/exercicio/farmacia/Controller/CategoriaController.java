package com.exercicio.farmacia.Controller;

import java.util.List;
import javax.validation.Valid;
import com.exercicio.farmacia.Model.CategoriaModel;
import com.exercicio.farmacia.Repository.CategoriaRepository;
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
@RequestMapping("/Categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity <List<CategoriaModel>> GetAll() {
		return ResponseEntity.status(200).body(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <CategoriaModel> GetById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());	
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity <List<CategoriaModel>> GetByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity <CategoriaModel> post(@Valid @RequestBody CategoriaModel NovaCategoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(NovaCategoria));
	}

	@PutMapping
	public ResponseEntity <CategoriaModel> put(@Valid @RequestBody CategoriaModel NovaCategoria) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(NovaCategoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
		}	
}