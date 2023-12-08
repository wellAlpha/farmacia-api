package com.proj.farmacia.dtos.composicao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ComposicaoDTO {

    @Positive
    @NotNull
	private Integer id;
   
	private String descricao;
	
	private Boolean ativo;

   

}