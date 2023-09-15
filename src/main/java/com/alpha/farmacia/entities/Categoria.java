package com.alpha.farmacia.entities;

import jakarta.persistence.*;



@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Boolean ativo = true;

	public Categoria() {}
	public Categoria(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	

}
