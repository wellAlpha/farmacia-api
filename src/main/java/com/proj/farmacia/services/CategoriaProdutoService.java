package com.proj.farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.entities.CategoriaProduto;
import com.proj.farmacia.repositories.CategoriaProdutoRepository;

@Service
public class CategoriaProdutoService {
    @Autowired CategoriaProdutoRepository categoriaProdutoRepository;

	public List<CategoriaProduto> listAtivos () {
		List<CategoriaProduto> categorias = categoriaProdutoRepository.findByAtivoTrue();

		return categorias;
	}

}
