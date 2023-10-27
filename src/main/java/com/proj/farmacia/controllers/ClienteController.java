package com.proj.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.farmacia.entities.Cliente;
import com.proj.farmacia.services.ClienteService;

import jakarta.validation.Valid;

@Validated
@RestController()
@RequestMapping("/api/clientes")
public class ClienteController {
@Autowired ClienteService clienteService;
	
	@GetMapping()
	public ResponseEntity<List<Cliente>> listClientes (){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(clienteService.list());
	}
	
	@PostMapping()
	public ResponseEntity<Cliente> create(@RequestBody @Valid Cliente cliente) throws Exception{
			return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(clienteService.create(cliente));
	}
}
