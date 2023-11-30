package com.proj.farmacia.dtos.itemCompra;

import java.math.BigDecimal;

import com.proj.farmacia.dtos.medicacao.MedicacaoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCompraDTO {
    private Integer id;

    @Positive
	private BigDecimal precoUnitario;

    @Positive
	private Integer quantidade;

    @Valid
    private MedicacaoDTO medicacao;
}
