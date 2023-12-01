package com.proj.farmacia.dtos.medicacao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicacaoDTO {

	@NotNull(message = "id {notnull}")
    @Positive(message = "id {positive}")
	private Integer id;

}
