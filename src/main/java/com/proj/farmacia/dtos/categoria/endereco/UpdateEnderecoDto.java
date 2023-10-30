package com.proj.farmacia.dtos.categoria.endereco;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateEnderecoDto {
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

    public UpdateEnderecoDto(
            @NotBlank(message = "logradouro {notblank}") @NotNull(message = "logradouro {notnull}") @Length(max = 100, message = "logradouro {len}") String logradouro,
            @NotBlank(message = "cep {notblank}") @NotNull(message = "cep {notnull}") @Length(max = 10, message = "cep {len}") String cep,
            @NotBlank(message = "município {notblank}") @NotNull(message = "município {notnull}") @Length(max = 30, message = "municipio {len}") String municipio,
            @Length(max = 10, message = "número {len}") String numero,
            @Length(max = 100, message = "complemento {len}") String complemento,
            @NotBlank(message = "bairro {notblank}") @NotNull(message = "bairro {notnull}") @Length(max = 50, message = "bairro {len}") String bairro,
            @NotBlank(message = "estado {notblank}") @NotNull(message = "estado {notnull}") @Length(max = 50, message = "estado {len}") String estado) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.municipio = municipio;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
