package com.proj.farmacia.dtos.categoria.cliente;

import org.hibernate.validator.constraints.Length;

import com.proj.farmacia.dtos.categoria.endereco.CreateEnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateClienteDto {
	@NotBlank(message = "nome {notblank}")
	@NotNull(message = "nome {notnull}")
	@Length(max = 150, message = "nome {len}")
	private String nome;

	@NotBlank(message = "cpf {notblank}")
	@NotNull(message = "cpf {notnull}")
	@Length(max = 15, message = "cpf {len}")
	private String cpf;
	
	@NotBlank(message = "celular {notblank}")
	@NotNull(message = "celular {notnull}")
	private String celular;
	
	@NotBlank(message = "email {notblank}")
	@NotNull(message = "email {notnull}")
	@Email(message = "{email}")
	@Length(max = 30)
	private String email;

	@Valid
    private CreateEnderecoDto endereco;

    
    public CreateClienteDto(
            @NotBlank(message = "nome {notblank}") @NotNull(message = "nome {notnull}") @Length(max = 150, message = "nome {len}") String nome,
            @NotBlank(message = "cpf {notblank}") @NotNull(message = "cpf {notnull}") @Length(max = 15, message = "cpf {len}") String cpf,
            @NotBlank(message = "celular {notblank}") @NotNull(message = "celular {notnull}") @Length(max = 11, message = "celular {len}") String celular,
            @NotBlank(message = "email {notblank}") @NotNull(message = "email {notnull}") @Email(message = "{email}") @Length(max = 30) String email,
            @Valid CreateEnderecoDto endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CreateEnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(CreateEnderecoDto endereco) {
        this.endereco = endereco;
    }

    
}
