package com.alpha.farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.farmacia.dtos.categoria.CreateCategoriaDto;
import com.alpha.farmacia.entities.Categoria;
import com.alpha.farmacia.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired CategoriaRepository categoriaRepository;

	public List<Categoria> list () {
		List<Categoria> categorias = categoriaRepository.findByAtivoTrue();

		return categorias;
	}
	
	public Categoria create (CreateCategoriaDto createCategoriaDto) {
		Categoria categoria = categoriaRepository.save(new Categoria(createCategoriaDto.descricao));

		return categoria;
	}
}
