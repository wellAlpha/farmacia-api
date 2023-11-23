package com.proj.farmacia.dtos.fabricante;
import org.hibernate.validator.constraints.Length;

import com.proj.farmacia.dtos.endereco.UpdateEnderecoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateFabricanteDTO {

    @NotBlank(message = "nome {notblank}")
	@NotNull(message = "nome {notnull}")
	@Length(max = 100, message = "nome {len}") 
    private String nome;
    
    @NotBlank(message = "cnpj {notblank}")
    @NotNull(message = "cnpj {notnull}")
	@Length(max = 30, message = "cnpj {len}") 
	private String cnpj;

    @Valid
    private UpdateEnderecoDTO endereco;
    
}
