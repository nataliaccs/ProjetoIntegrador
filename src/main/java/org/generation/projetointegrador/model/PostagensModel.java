package org.generation.projetointegrador.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagens")
public class PostagensModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = " O atributo título é obrigatório e não pode utilizar espaços em branco!")
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres.")
	private String titulo;

	@NotNull(message = " O atributo texto é obrigatório!")
	@Size(min = 10, max = 2000, message = "O atributo texto deve conter no mínimo 10 e no máximo 2000 caracteres.")
	private String texto;

	@UpdateTimestamp
	private LocalDateTime data;
	
	@NotNull(message = " O atributo foto é obrigatório!")
	private String foto;
	
	@ManyToOne
    @JsonIgnoreProperties("postagens")
    private SubtemasModel subtemas;

	@ManyToOne
	@JsonIgnoreProperties("postagens")
	private UsuariosModel usuarios;
	
	public SubtemasModel getSubtemas() {
		return subtemas;
	}

	public void setSubtemas(SubtemasModel subtemas) {
		this.subtemas = subtemas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public UsuariosModel getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(UsuariosModel usuarios) {
		this.usuarios = usuarios;
	}

	}


