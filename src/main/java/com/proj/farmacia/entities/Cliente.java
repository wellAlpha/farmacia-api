package com.proj.farmacia.entities;

import jakarta.persistence.*;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, length = 150)
	private String nome;

	@Column(nullable = false, length = 15)
	private String cpf;
	
	@Column(nullable = false, length = 11)
	private String celular;
	
	@Column(nullable = false, length = 30)
	private String email;

	@Column(nullable = false)
	private Boolean ativo = true;
	
	// @Column(nullable = false)
	// private Integer endereco_id;

	@OneToOne()
//    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
	
	
	public Cliente() {
	}

	

	

}
