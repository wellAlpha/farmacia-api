package com.proj.farmacia.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
@Data
@Entity
@Where(clause = "ativo = true")
@SQLDelete(sql = "UPDATE medicacao SET ativo = false WHERE id=?;")
public class Medicacao implements Serializable{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Column(columnDefinition = "INT UNSIGNED NOT NULL")
    private Integer conteudo;

	@Column(nullable = false)
	private String nome; 

	@Column(nullable = false)
	private Double preco;

    @Column(nullable = false)
	@ColumnDefault("true")
	private Boolean ativo = true;

	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_conteudo_id", referencedColumnName = "id", nullable = true)
    private TipoConteudo tipoConteudo;

	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "fabricante_id", referencedColumnName = "id", nullable = true)
    private Fabricante fabricante;

	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "fornecedor_id", referencedColumnName = "id", nullable = true)
    private Fornecedor fornecedor;

	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
        name = "medicacao_composicao",
        joinColumns = @JoinColumn(name = "medicacao_id"),
        inverseJoinColumns = @JoinColumn(name = "composicao_id"))
	private List<Composicao> composicoes;	

	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
        name = "medicacao_tipo_medicacao",
        joinColumns = @JoinColumn(name = "medicacao_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "tipo_medicacao_id", referencedColumnName = "id"))
	private List<TipoMedicacao> tipos;	
	
	@OneToMany(cascade = CascadeType.DETACH)
    private Set<ItemCompra> itens;
}
