package com.proj.farmacia.dtos.funcionario;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {
	@NotNull(message = "id {notnull}")
    @Positive(message = "id {positive}")
	private Integer id;

}
