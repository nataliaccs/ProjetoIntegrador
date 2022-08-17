package org.generation.projetointegrador.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "tb_subtemas")
public class SubtemasModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotBlank(message = "O atributo descrição é obrigatório e não pode utilizar espaços em branco!") 
	private String descricao;

	@OneToMany(mappedBy = "subtemas", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("subtemas")
    private List<PostagensModel> postagens;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<PostagensModel> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<PostagensModel> postagens) {
		this.postagens = postagens;
	}
	

}



