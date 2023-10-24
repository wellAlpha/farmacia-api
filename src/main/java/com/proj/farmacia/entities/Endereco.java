package com.proj.farmacia.entities;

import jakarta.persistence.*;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String logradouro;

	@Column(nullable = false, length = 10)
	private String cep;

	@Column(nullable = false, length = 30)
	private String municipio;

	@Column(nullable = false, length = 10)
	private String numero;

	@Column(nullable = false, length = 100)
	private String complemento;

	@Column(nullable = false, length = 50)
	private String bairro;

	@Column(nullable = false, length = 50)
	private String estado;

	@Column(nullable = false)
	private Boolean ativo = true;

	public Endereco() {
	}

	public Endereco(String logradouro, String cep, String municipio, String numero, String complemento, String bairro,
			String estado) {
		this.logradouro = logradouro;
		this.cep = cep;
		this.municipio = municipio;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
