package com.proj.farmacia.dtos.endereco;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateEnderecoDTO {
    @NotBlank(message = "logradouro {notblank}")
	@NotNull(message = "logradouro {notnull}")
	@Length(max = 100, message = "logradouro {len}")
	private String logradouro;

	@NotBlank(message = "cep {notblank}")
	@NotNull(message = "cep {notnull}")
	@Length(max = 10, message = "cep {len}")
	private String cep;

	@NotBlank(message = "município {notblank}")
	@NotNull(message = "município {notnull}")
	@Length(max = 30, message = "municipio {len}")
	private String municipio;

	@Length(max = 10, message = "número {len}")
	private String numero;

	@Length(max = 100, message = "complemento {len}")
	private String complemento;

	@NotBlank(message = "bairro {notblank}")
	@NotNull(message = "bairro {notnull}")
	@Length(max = 50, message = "bairro {len}")
	private String bairro;

	@NotBlank(message = "estado {notblank}")
	@NotNull(message = "estado {notnull}")
	@Length(max = 50, message = "estado {len}")
	private String estado;

}
