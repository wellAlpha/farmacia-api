package com.proj.farmacia.dtos.cliente;

import com.proj.farmacia.dtos.endereco.CreateEnderecoDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
	@NotNull(message = "id {notnull}")
    @Positive(message = "id {positive}")
	private Integer id;

	private String nome;
	
	private String cpf;
	
	private String telefone;
	
	private String email;

    private CreateEnderecoDTO endereco;
}
