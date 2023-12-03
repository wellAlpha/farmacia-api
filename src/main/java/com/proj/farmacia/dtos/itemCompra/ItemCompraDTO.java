package com.proj.farmacia.dtos.itemCompra;

import com.proj.farmacia.dtos.medicacao.MedicacaoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCompraDTO {
    private Integer id;

    @NotNull(message = "precoUnitario {notnull}")
    @Positive(message = "precoUnitario {positive}")
	private Double precoUnitario;

    @NotNull(message = "quantidade {notnull}")
    @Positive(message = "quantidade {positive}")
	private Integer quantidade;

    @Valid
    @NotNull(message = "medicacao {notnull}")
    private MedicacaoDTO medicacao;
}
