package com.proj.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.farmacia.dtos.compra.CreateCompraDTO;
import com.proj.farmacia.entities.Compra;
import com.proj.farmacia.services.CompraService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/api/compras")
public class CompraController {
    @Autowired  CompraService compraService;
    @GetMapping()
	public ResponseEntity<List<Compra>> listCompras (){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(compraService.listAtivos());
	}

	@PostMapping()
	public ResponseEntity<Compra> create (@RequestBody @Valid CreateCompraDTO createCompraDTO) {
		return ResponseEntity
		.status(HttpStatus.CREATED)
		.body(compraService.store(createCompraDTO));
	}
}
