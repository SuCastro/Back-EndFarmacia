package com.exercicio.farmacia.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Categoria")
public class CategoriaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size (min = 5, max = 100)
	private String titulo;
	
	@NotBlank
	@Size (min = 10, max = 100)
	private String descricao;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private ProdutoModel produto;

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
		return descricao;
	}
	public void setTexto(String texto) {
		this.descricao = texto;
	}
	
	public ProdutoModel getTema() {
		return produto;
	}
	
	public void setTema(ProdutoModel tema) {
		this.produto = tema;
	}
}