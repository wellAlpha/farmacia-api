package com.proj.farmacia.entities;

import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;



@Entity
@Where(clause = "ativo = true")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 150)
	private String nome;

	@Column(nullable = false, length = 15, unique = true)
	private String cpf;
	
	@Column(nullable = false, length = 11)
	private String celular;
	
	@Column(nullable = false, length = 30)
	private String email;

    @Column(nullable = false, length = 100)
	private String passwordHash;

	@Column(nullable = false)
	private Boolean ativo = true;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @ManyToOne()
	@JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;
	
	
	public Funcionario() {}


    public Funcionario(Integer id, String nome, String cpf, String celular, String email, String passwordHash,
            Boolean ativo, @Valid Endereco endereco, @Valid Cargo cargo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf.replaceAll("[\\.\\-]", "");
        this.celular = celular.replaceAll("[-()\\s]", "");
        this.email = email;
        this.passwordHash = passwordHash;
        this.endereco = endereco;
        this.cargo = cargo;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf.replaceAll("[\\.\\-]", "");
    }


    public String getCelular() {
        return celular;
    }


    public void setCelular(String celular) {
        this.celular = celular.replaceAll("[-()\\s]", "");
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPasswordHash() {
        return passwordHash;
    }


    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }


    public Boolean getAtivo() {
        return ativo;
    }


    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }


    public Endereco getEndereco() {
        return endereco;
    }


    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public Cargo getCargo() {
        return cargo;
    }


    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
	
    
}
