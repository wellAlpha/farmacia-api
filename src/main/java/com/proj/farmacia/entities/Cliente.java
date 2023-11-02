package com.proj.farmacia.entities;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@Where(clause = "ativo = true")
@SQLDelete(sql = "UPDATE cliente SET ativo = false WHERE id=?;")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 150)
	private String nome;

	@Column(nullable = false, length = 15, unique = true)
	private String cpf;
	
	@Column(nullable = false, length = 11)
	private String celular;
	
	@Column(nullable = false, length = 30)
	private String email;

	@Column(nullable = false)
	private Boolean ativo = true;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
	
	
	public Cliente() {}


	public Cliente(String nome, String cpf, String celular, String email, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf.replaceAll("[\\.\\-]", "");
		this.celular = celular.replaceAll("[-()\\s]", "");
		this.email = email;
		this.endereco = endereco;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf.replaceAll("[\\.\\-]", "");
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular.replaceAll("[-()\\s]", "");
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Boolean getAtivo() {
		return ativo;
	}


	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Integer getId() {
		return id;
	}

	

	

}
