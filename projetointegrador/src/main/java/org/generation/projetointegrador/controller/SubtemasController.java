package org.generation.projetointegrador.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.projetointegrador.model.SubtemasModel;
import org.generation.projetointegrador.repository.SubtemasRepository;
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
@RequestMapping("/subtemas")
@CrossOrigin("*")
public class SubtemasController {
	
	@Autowired
	private SubtemasRepository subtemasRepository;
	
	@GetMapping
	public ResponseEntity<List<SubtemasModel>> GetAll() {
		return ResponseEntity.ok(subtemasRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SubtemasModel> GetById(@PathVariable Long id){
		return subtemasRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<SubtemasModel>> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(subtemasRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<SubtemasModel> postSubtemas (@Valid @RequestBody SubtemasModel subtemas){
		return ResponseEntity.status(HttpStatus.CREATED).body(subtemasRepository.save(subtemas));
	}
	
	@PutMapping
	public ResponseEntity<SubtemasModel> putSubtemas(@RequestBody SubtemasModel subtemas){
		return ResponseEntity.status(HttpStatus.OK).body(subtemasRepository.save(subtemas));
	}
	
	@DeleteMapping("/{id}")
	public void deleteSubtemas(@PathVariable Long id) {
		subtemasRepository.deleteById(id);
	}	



	

	

	

	

}
