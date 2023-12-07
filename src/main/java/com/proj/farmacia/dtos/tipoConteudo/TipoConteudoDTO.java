package com.proj.farmacia.dtos.tipoConteudo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TipoConteudoDTO {
    @Positive
    @NotNull
	private Integer id;

}
