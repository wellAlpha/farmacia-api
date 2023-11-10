package com.proj.farmacia.dtos.fornecedor;

import org.hibernate.validator.constraints.Length;

import com.proj.farmacia.entities.Endereco;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateFornecedor {
    
    @NotBlank(message = "nome {notblank}")
	@NotNull(message = "nome {notnull}")
	@Length(max = 100, message = "nome {len}") 
    private String nome;
    
    @NotBlank(message = "cnpj {notblank}")
    @NotNull(message = "cnpj {notnull}")
	@Length(max = 30, message = "cnpj {len}") 
	private String cnpj;

    
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
    
}
