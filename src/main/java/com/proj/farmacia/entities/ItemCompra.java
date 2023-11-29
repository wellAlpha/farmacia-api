package com.proj.farmacia.entities;

import java.math.BigDecimal;

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
@SQLDelete(sql = "UPDATE item_compra SET ativo = false WHERE id=?;")
public class ItemCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
	private BigDecimal precoUnitario;

    @Column(nullable = false)
	private Integer quantidade = 1;

    @OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "compra_id", referencedColumnName = "id")
    private Compra compra;

    @OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "medicacao_id", referencedColumnName = "id", nullable = true)
    private Medicacao medicacao;
}
