package com.proj.farmacia.entities;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
@Where(clause = "ativo = true")
@SQLDelete(sql = "UPDATE medicacao SET ativo = false WHERE id=?;")
public class Medicacao {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Column(columnDefinition = "INT UNSIGNED NOT NULL")
    private Integer conteudo;

	@Column(nullable = false)
	private String nome; 

    @Column(nullable = false)
	@ColumnDefault("true")
	private Boolean ativo = true;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "tipo_conteudo_id", referencedColumnName = "id", nullable = false)
    private TipoConteudo tipoConteudo;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "fabricante_id", referencedColumnName = "id")
    private Fabricante fabricante;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "fornecedor_id", referencedColumnName = "id")
    private Fornecedor fornecedor;

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "medicacao_composicao",
        joinColumns = @JoinColumn(name = "medicacao_id"),
        inverseJoinColumns = @JoinColumn(name = "composicao_id"))
	private List<Composicao> medicacao;	

	
}
