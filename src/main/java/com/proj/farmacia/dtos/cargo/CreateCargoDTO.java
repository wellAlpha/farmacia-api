package com.proj.farmacia.dtos.cargo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCargoDTO {
    @NotNull(message = "id {notnull}")
    @Positive(message = "id {positive}")
	private Integer id;

}
