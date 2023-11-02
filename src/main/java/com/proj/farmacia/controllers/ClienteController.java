package com.proj.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.farmacia.dtos.categoria.cliente.CreateClienteDto;
import com.proj.farmacia.dtos.categoria.cliente.UpdateClienteDto;
import com.proj.farmacia.entities.Cliente;
import com.proj.farmacia.services.ClienteService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@Validated
@RestController()
@RequestMapping("/api/clientes")
public class ClienteController {
@Autowired ClienteService clienteService;
	
	@GetMapping()
	public ResponseEntity<List<Cliente>> listClientes (){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(clienteService.listAtivos());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Cliente> get(@PathVariable @Positive Integer id) throws Exception{
			return ResponseEntity.ok().body(clienteService.get(id));
	}
	@PostMapping()
	public ResponseEntity<Cliente> create(@RequestBody @Valid CreateClienteDto clienteDto) throws Exception{
			return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(clienteService.create(clienteDto));
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable @Positive Integer id, @RequestBody @Valid UpdateClienteDto clienteDto) throws Exception{
			return ResponseEntity.ok().body(clienteService.update(id, clienteDto));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable @Positive Integer id) throws Exception{
			clienteService.delete(id);
			return ResponseEntity.noContent().<Void>build();
	}
}
