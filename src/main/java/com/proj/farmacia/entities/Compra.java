package com.proj.farmacia.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
@Data
@Entity
public class Compra implements Serializable{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Double precoTotal;

	@Column(nullable = false)
	private Integer parcelas = 1;

	@Column(nullable = false)
	private LocalDateTime dataCompra = LocalDateTime.now();


	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "forma_pagamento_id", referencedColumnName = "id", nullable = false)
    private FormaPagamento formaPagamento;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "funcionario_id", referencedColumnName = "id", nullable = true)
    private Funcionario funcionario;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = true)
    private Cliente cliente;

	@JsonManagedReference
	@OneToMany(mappedBy = "compra", fetch = FetchType.EAGER)
	private List<ItemCompra> itens;

	public void setParcelas (Integer parcelas) {
		if (parcelas != null && parcelas > 1) {
			this.parcelas = parcelas;
		}
	}
}
