package com.proj.farmacia.entities;

import java.io.Serializable;
import java.util.Set;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
@Where(clause = "ativo = true")
@SQLDelete(sql = "UPDATE cliente SET ativo = false WHERE id=?;")
public class Cliente implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 150)
	private String nome;

	@Column(nullable = false, length = 15, unique = true)
	private String cpf;
	
	@Column(nullable = false, length = 11)
	private String telefone;
	
	@Column(nullable = false, length = 30)
	private String email;

	@Column(nullable = false)
	@ColumnDefault("true")
	private Boolean ativo = true;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

	@OneToMany(cascade = CascadeType.DETACH)
    private Set<Compra> compra;

	public void setCpf(String cpf) {
		this.cpf = cpf.replaceAll("[\\.\\-]", "");
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone.replaceAll("[-()\\s]", "");
	}

}
