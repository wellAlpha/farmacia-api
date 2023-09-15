package com.alpha.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.farmacia.dtos.categoria.CreateCategoriaDto;
import com.alpha.farmacia.entities.Categoria;
import com.alpha.farmacia.services.CategoriaService;

@RestController()
@RequestMapping("/api/categorias")
public class CategoriaController {
	@Autowired CategoriaService categoriaService;
	
	@GetMapping()
	public ResponseEntity<List<Categoria>> listCategoria (){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(categoriaService.list());
	}
	
	@PostMapping()
	public ResponseEntity<Categoria> create(@RequestBody CreateCategoriaDto createCategoriaDto){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(categoriaService.create(createCategoriaDto));
	}
}
