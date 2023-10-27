package com.proj.farmacia.entities;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "nome {notblank}")
	@NotNull(message = "nome {notnull}")
	@Length(max = 150, message = "nome {len}")
	@Column(nullable = false, length = 150)
	private String nome;

	@NotBlank(message = "cpf {notblank}")
	@NotNull(message = "cpf {notnull}")
	@Length(max = 15, message = "cpf {len}")
	@Column(nullable = false, length = 15, unique = true)
	private String cpf;
	
	@NotBlank(message = "celular {notblank}")
	@NotNull(message = "celular {notnull}")
	@Length(max = 11, message = "celular {len}")
	@Column(nullable = false, length = 11)
	private String celular;
	
	@NotBlank(message = "email {notblank}")
	@NotNull(message = "email {notnull}")
	@Email(message = "{email}")
	@Length(max = 30)
	@Column(nullable = false, length = 30)
	private String email;

	@Column(nullable = false)
	private Boolean ativo = true;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	// @NotNull(message = "endereço {notnull}")
	@Valid
    private Endereco endereco;
	
	
	public Cliente() {}


	public Cliente(String nome, String cpf, String celular, String email, Boolean ativo, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.email = email;
		this.ativo = ativo;
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
		this.celular = celular;
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
