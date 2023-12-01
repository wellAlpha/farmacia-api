package com.proj.farmacia.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class ItemCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
	private Double precoUnitario;

    @Column(nullable = false)
	private Integer quantidade = 1;

    @ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "compra_id", referencedColumnName = "id", nullable = false)
    private Compra compra;

    @ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "medicacao_id", referencedColumnName = "id", nullable = false)
    private Medicacao medicacao;

    
}
