package com.alpha.farmacia.dtos.categoria;

import java.io.Serializable;

public class CreateCategoriaDto implements Serializable {
	public String descricao;
	
	public CreateCategoriaDto() {}
	public CreateCategoriaDto(String descricao) {
		this.descricao = descricao;
	}
	
	
}
