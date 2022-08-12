package org.generation.projetointegrador.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.projetointegrador.model.PostagensModel;
import org.generation.projetointegrador.repository.PostagensRepository;
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
@CrossOrigin("*")
public class PostagensController {

		@Autowired
		private PostagensRepository postagensRepository;
		
		@GetMapping
		public ResponseEntity<List<PostagensModel>> GetAll(){
			return ResponseEntity.ok(postagensRepository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<PostagensModel> GetById(@PathVariable Long id){
			return postagensRepository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/titulo/{titulo}")
		public ResponseEntity<List<PostagensModel>> GetByTitulo(@PathVariable String titulo){
			return ResponseEntity.ok(postagensRepository.findAllByTituloContainingIgnoreCase(titulo));		
		}
	
		@PostMapping
		public ResponseEntity<PostagensModel> postPostagens (@Valid @RequestBody PostagensModel  postagens ){
			//if (subtemasRepository.existsById(postagens.getSubtemas().getId()))
				return ResponseEntity.status(HttpStatus.CREATED).body(postagensRepository.save(postagens));
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		@PutMapping
		public ResponseEntity <PostagensModel> putPostagens (@RequestBody PostagensModel postagens){
			return ResponseEntity.status(HttpStatus.OK).body(postagensRepository.save(postagens));
		}
		
		@DeleteMapping ("/{id}")
		public void deletePostagens (@PathVariable Long id) {
			postagensRepository.deleteById(id);
		}
}

