package com.proj.farmacia.entities;

import org.hibernate.annotations.ColumnDefault;
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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Where(clause = "ativo = true")
@SQLDelete(sql = "UPDATE funcionario SET ativo = false WHERE id=?;")
public class Funcionario {
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

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cargo_id", referencedColumnName = "id", nullable = false)
    // Para evitar futuros problemas com dependência circular.
    // @JsonProperty(access = Access.WRITE_ONLY)
    private Cargo cargo;
	
    public void setCpf(String cpf) {
        this.cpf = cpf.replaceAll("[\\.\\-]", "");
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone.replaceAll("[-()\\s]", "");
    }
    
}
