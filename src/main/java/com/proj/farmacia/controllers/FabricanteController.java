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

import com.proj.farmacia.dtos.fabricante.CreateFabricanteDTO;
import com.proj.farmacia.dtos.fabricante.UpdateFabricanteDTO;
import com.proj.farmacia.entities.Fabricante;
import com.proj.farmacia.services.FabricanteService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@Validated
@RestController()
@RequestMapping("/api/fabricantes")

public class FabricanteController {
@Autowired FabricanteService fabricanteService;

@GetMapping 
public ResponseEntity<List<Fabricante>> listFabricante () throws Exception {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(fabricanteService.listAtivos());
	} 
	@GetMapping(path = "/{id}")
	public ResponseEntity<Fabricante> get(@PathVariable @Positive Integer id) throws Exception{
			return ResponseEntity.ok().body(fabricanteService.get(id));
	}
    	@PostMapping()
	public ResponseEntity<Fabricante> create(@RequestBody @Valid CreateFabricanteDTO fabricanteDto) throws Exception{
			return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(fabricanteService.create(fabricanteDto));
	}   
	
	    @PutMapping(path = "/{id}")
	public ResponseEntity<Fabricante> update(@PathVariable @Positive Integer id, @RequestBody @Valid UpdateFabricanteDTO fabricanteDto) throws Exception{
			return ResponseEntity.ok().body(fabricanteService.update(id, fabricanteDto));
	
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable @Positive Integer id) throws Exception{
			fabricanteService.delete(id);
			return ResponseEntity.noContent().<Void>build();
	}
}
	

