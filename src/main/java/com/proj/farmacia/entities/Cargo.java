package com.proj.farmacia.entities;

import jakarta.persistence.*;

@Entity
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false)
	private Boolean ativo = true;

	public Cargo() {}

	public Cargo(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}


}
