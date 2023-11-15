package com.proj.farmacia.entities;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Builder.Default;

@Data
@Entity
@Where(clause = "ativo = true")
@SQLDelete(sql = "UPDATE tipo_medicacao SET ativo = false WHERE id=?;")
public class TipoMedicacao {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String descricao;

	@Column(nullable = false)
    @ColumnDefault("true")
	private Boolean ativo = true;
}
