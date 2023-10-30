package com.proj.farmacia.entities;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "logradouro {notblank}")
	@NotNull(message = "logradouro {notnull}")
	@Length(max = 100, message = "logradouro {len}")
	@Column(nullable = false, length = 100)
	private String logradouro;

	@NotBlank(message = "cep {notblank}")
	@NotNull(message = "cep {notnull}")
	@Length(max = 10, message = "cep {len}")
	@Column(nullable = false, length = 10)
	private String cep;

	@NotBlank(message = "município {notblank}")
	@NotNull(message = "município {notnull}")
	@Length(max = 30, message = "municipio {len}")
	@Column(nullable = false, length = 30)
	private String municipio;

	@Length(max = 10, message = "número {len}")
	@Column(nullable = true, length = 10)
	private String numero;

	@Length(max = 100, message = "complemento {len}")
	@Column(nullable = true, length = 100)
	private String complemento;

	@NotBlank(message = "bairro {notblank}")
	@NotNull(message = "bairro {notnull}")
	@Length(max = 50, message = "bairro {len}")
	@Column(nullable = false, length = 50)
	private String bairro;

	@NotBlank(message = "estado {notblank}")
	@NotNull(message = "estado {notnull}")
	@Length(max = 50, message = "estado {len}")
	@Column(nullable = false, length = 50)
	private String estado;

	@Column(nullable = false)
	private Boolean ativo = true;

	public Endereco() {}

	public Endereco(String logradouro, String cep, String municipio, String numero, String complemento, String bairro,
			String estado) {
		this.logradouro = logradouro;
		this.cep = cep.replaceAll("[\\.\\-]", "");
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
		this.cep = cep.replaceAll("[\\.\\-]", "");
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
