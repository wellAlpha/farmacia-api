package com.proj.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.farmacia.entities.CategoriaProduto;
import com.proj.farmacia.services.CategoriaProdutoService;

@RestController()
@RequestMapping("/api/categorias-produtos")
public class CategoriaProdutoController {
    @Autowired CategoriaProdutoService categoriaProdutoService;
    @GetMapping()
	public ResponseEntity<List<CategoriaProduto>> listClientes (){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(categoriaProdutoService.listAtivos());
	}
}
