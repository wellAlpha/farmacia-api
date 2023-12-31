package com.proj.farmacia.dtos.tipoConteudo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class TipoConteudoDTO {
    @Positive (message = "tipoMedicacao deve ser inteiro")
    @NotNull  (message = "tipoMedicacao não pode ser nulo")
	private Integer id;
    
	private String descricao;
	
	private Boolean ativo;





}
