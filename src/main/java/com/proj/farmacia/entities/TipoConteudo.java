package com.proj.farmacia.entities;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@SQLDelete(sql = "UPDATE tipo_conteudo SET ativo = false WHERE id=?;")
public class TipoConteudo implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 20, unique = true)
	private String descricao;

	@Column(nullable = true, length = 20)
	private String sigla;

	@Column(nullable = false)
	@ColumnDefault("true")
	private Boolean ativo = true;

	@JsonBackReference
	@OneToMany(cascade = CascadeType.DETACH, mappedBy = "tipoConteudo", fetch = FetchType.LAZY, orphanRemoval = false)
	private Set<Medicacao> medicacoes = new HashSet<>();
	
}
