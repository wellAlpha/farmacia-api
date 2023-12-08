package com.proj.farmacia.dtos.TipoMedicacao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class TipoMedicacaoDTO {

    @Positive (message = "tipoMedicacao deve ser inteiro")
    @NotNull  (message = "tipoMedicacao não pode ser nulo")
	private Integer id;
   
	private String descricao;
	
	private Boolean ativo;

}