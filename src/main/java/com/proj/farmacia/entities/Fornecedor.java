package com.proj.farmacia.entities;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Data
@Entity
@Where(clause = "ativo = true")
@SQLDelete(sql = "UPDATE fornecedor SET ativo = false WHERE id=?;")
public class Fornecedor {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false)
	@ColumnDefault("true")
	private Boolean ativo = true;

    @Column(nullable = false, length = 30)
	private String cnpj;

    
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.DETACH, mappedBy = "fornecedor", fetch = FetchType.LAZY, orphanRemoval = false)
    private Set<Medicacao> medicacoes = new HashSet<>();
}
