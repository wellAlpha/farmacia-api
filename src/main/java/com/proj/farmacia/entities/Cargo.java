package com.proj.farmacia.entities;



import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Where(clause = "ativo = true")
@SQLDelete(sql = "UPDATE cargo SET ativo = false WHERE id=?;")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false)
	private Boolean ativo = true;

	@OneToMany(cascade = CascadeType.DETACH, mappedBy = "cargo", fetch = FetchType.LAZY, orphanRemoval = false)
	private Set<Funcionario> funcionarios = new HashSet<>();
	
}
