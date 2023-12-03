package com.proj.farmacia.entities;



import java.util.Set;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Where(clause = "ativo = true")
@SQLDelete(sql = "UPDATE forma_pagamento SET ativo = false WHERE id=?;")
public class FormaPagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 50, unique = true)
	private String descricao;

	@Column(nullable = false)
	@ColumnDefault("true")
	private Boolean ativo = true;

	@OneToMany(cascade = CascadeType.DETACH)
    private Set<Compra> compra;
	
}
