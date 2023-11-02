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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.farmacia.entities.Funcionario;
import com.proj.farmacia.services.FuncionarioService;

import jakarta.validation.constraints.Positive;

@Validated
@RestController()
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
@Autowired FuncionarioService funcionarioService;
	
	@GetMapping()
	public ResponseEntity<List<Funcionario>> listClientes (){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(funcionarioService.listAtivoTrue());
	}
	
	@PostMapping()
	public ResponseEntity<Funcionario> create(/*@RequestBody @Valid CreateClienteDto clienteDto*/) throws Exception{
			return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(funcionarioService.create());
	}

	// @PutMapping(path = "/{id}")
	// public ResponseEntity<Cliente> update(@PathVariable @Positive Integer id, @RequestBody @Valid UpdateClienteDto clienteDto) throws Exception{
	// 		return ResponseEntity.ok().body(clienteService.update(id, clienteDto));
	// }

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable @Positive Integer id) throws Exception{
			funcionarioService.delete(id);
			return ResponseEntity.noContent().<Void>build();
	}
}
