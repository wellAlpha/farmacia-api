package com.proj.farmacia.dtos.fabricante;

import com.proj.farmacia.entities.Endereco;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FabricanteDto {

    @Positive
    @NotNull
	private Integer id;

    private String nome;

    private String cnpj;

    private Endereco endereco;


    



}
