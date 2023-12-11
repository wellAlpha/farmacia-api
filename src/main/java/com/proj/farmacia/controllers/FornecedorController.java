package com.proj.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.farmacia.dtos.fornecedor.CreateFornecedorDTO;
import com.proj.farmacia.dtos.fornecedor.UpdateFornecedorDTO;
import com.proj.farmacia.entities.Fornecedor;
import com.proj.farmacia.services.FornecedorService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
@RestController()
@RequestMapping("/api/fornecedores")
public class FornecedorController {
@Autowired FornecedorService fornecedorService;

@GetMapping   
public ResponseEntity<List<Fornecedor>> listFornecedores () throws Exception {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(fornecedorService.listAtivos());
	}
    
    @GetMapping(path = "/{id}")
	public ResponseEntity<Fornecedor> get(@PathVariable @Positive Integer id) throws Exception{
			return ResponseEntity.ok().body(fornecedorService.get(id));
	}
    	@PostMapping()
	public ResponseEntity<Fornecedor> create(@RequestBody @Valid CreateFornecedorDTO fornecedorDto) throws Exception{
			return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(fornecedorService.create(fornecedorDto));
	}
    @PutMapping(path = "/{id}")
	public ResponseEntity<Fornecedor> update(@PathVariable @Positive Integer id, @RequestBody @Valid UpdateFornecedorDTO fornecedorDto) throws Exception{
			return ResponseEntity.ok().body(fornecedorService.update(id, fornecedorDto));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable @Positive Integer id) throws Exception{
			fornecedorService.delete(id);
			return ResponseEntity.noContent().<Void>build();
	}

}
