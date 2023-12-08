package com.proj.farmacia.dtos.fornecedor;

import com.proj.farmacia.entities.Endereco;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FornecedorDto {

    @Positive
    @NotNull
	private Integer id;

    private String nome;

    private String cnpj;

    private Endereco endereco;

}
