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

import com.proj.farmacia.dtos.funcionario.CreateFuncionarioDTO;
import com.proj.farmacia.dtos.funcionario.UpdateFuncionarioDTO;
import com.proj.farmacia.entities.Funcionario;
import com.proj.farmacia.services.FuncionarioService;

import jakarta.validation.Valid;
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
	
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Funcionario> get(@PathVariable @Positive Integer id) throws Exception{
			return ResponseEntity.ok().body(funcionarioService.get(id));
	}
	@PostMapping()
	public ResponseEntity<Funcionario> create(@RequestBody @Valid CreateFuncionarioDTO funcionarioDto) throws Exception{
			return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(funcionarioService.create(funcionarioDto));
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Funcionario> update(@PathVariable @Positive Integer id, @RequestBody @Valid UpdateFuncionarioDTO funcionarioDto) throws Exception{
			return ResponseEntity.ok().body(funcionarioService.update(id, funcionarioDto));
	}
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable @Positive Integer id) throws Exception{
			funcionarioService.delete(id);
			return ResponseEntity.noContent().<Void>build();
	}
}
