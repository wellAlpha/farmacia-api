package com.proj.farmacia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String logradouro;

	@Column(nullable = false, length = 10)
	private String cep;

	@Column(nullable = false, length = 30)
	private String municipio;

	@Column(nullable = true, length = 10)
	private String numero;

	@Column(nullable = true, length = 100)
	private String complemento;

	@Column(nullable = false, length = 50)
	private String bairro;

	@Column(nullable = false, length = 50)
	private String estado;

	public void setCep(String cep) {
		this.cep = cep.replaceAll("[\\.\\-]", "");
	}

}
