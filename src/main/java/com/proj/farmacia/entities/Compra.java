package com.proj.farmacia.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
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
import lombok.Data;

@Data
@Entity
@Where(clause = "ativo = true")
@SQLDelete(sql = "UPDATE compra SET ativo = false WHERE id=?;")
public class Compra {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private BigDecimal precoTotal;

	@Column(nullable = false)
	private Integer parcelas = 1;

	@Column(nullable = false)
	private LocalDateTime dataCompra = LocalDateTime.now();

    @Column(nullable = false)
	@ColumnDefault("true")
	private Boolean ativo = true;


	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "forma_pagamento_id", referencedColumnName = "id")
    private FormaPagamento formaPagamento;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private Funcionario funcionario;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;
}
