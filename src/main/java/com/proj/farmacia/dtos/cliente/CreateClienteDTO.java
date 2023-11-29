package com.proj.farmacia.dtos.cliente;

import org.hibernate.validator.constraints.Length;

import com.proj.farmacia.dtos.endereco.CreateEnderecoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateClienteDTO {
	private Integer id;

	@NotBlank(message = "nome {notblank}")
	@NotNull(message = "nome {notnull}")
	@Length(max = 150, message = "nome {len}")
	private String nome;

	@NotBlank(message = "cpf {notblank}")
	@NotNull(message = "cpf {notnull}")
	@Length(max = 15, message = "cpf {len}")
	private String cpf;
	
	@NotBlank(message = "telefone {notblank}")
	@NotNull(message = "telefone {notnull}")
    @Pattern(regexp = "^\\(?(?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[134579])\\)? ?(?:[2-8]|9[0-9])[0-9]{3}\\-?[0-9]{4}$",
            message = "Telefone inválido!"
    )
	private String telefone;
	
	@NotBlank(message = "email {notblank}")
	@NotNull(message = "email {notnull}")
	@Email(message = "{email}")
	@Length(max = 30)
	private String email;

	@Valid
    private CreateEnderecoDTO endereco;

    

    
}
