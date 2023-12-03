package com.proj.farmacia.dtos.funcionario;

import org.hibernate.validator.constraints.Length;

import com.proj.farmacia.dtos.cargo.CreateCargoDTO;
import com.proj.farmacia.dtos.endereco.CreateEnderecoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

	private String nome;

	private String cpf;
	
	private String telefone;
	
	private String email;

    private CreateEnderecoDTO endereco;

    private CreateCargoDTO cargo;
}
