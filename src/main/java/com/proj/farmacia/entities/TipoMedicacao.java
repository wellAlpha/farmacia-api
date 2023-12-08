package com.proj.farmacia.entities;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
@Data
@Entity
@Where(clause = "ativo = true")
@SQLDelete(sql = "UPDATE tipo_medicacao SET ativo = false WHERE id=?;")
public class TipoMedicacao {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 100, unique = true)
	private String descricao;

	@Column(nullable = false)
    @ColumnDefault("true")
	private Boolean ativo = true;

	@JsonBackReference
	@ManyToMany(mappedBy = "tipos", fetch = FetchType.LAZY)
	private List<Medicacao> medicacoes;
}
