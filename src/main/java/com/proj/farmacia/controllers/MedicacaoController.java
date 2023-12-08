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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.farmacia.entities.Fabricante;
import com.proj.farmacia.entities.Medicacao;
import com.proj.farmacia.services.FabricanteService;
import com.proj.farmacia.services.MedicacaoService;

import jakarta.validation.constraints.Positive;

@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
@RestController()
@RequestMapping("/api/medicacoes")
public class MedicacaoController {
    @Autowired MedicacaoService medicacaoService;

@GetMapping 
    public ResponseEntity<List<Medicacao>> listMedicacoes () throws Exception {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(medicacaoService.listAtivos());
	} 
	@GetMapping(path = "/{id}")
	public ResponseEntity<Medicacao> get(@PathVariable @Positive Integer id) throws Exception{
			return ResponseEntity.ok().body(medicacaoService.get(id));
	}

    @DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable @Positive Integer id) throws Exception{
			medicacaoService.delete(id);
			return ResponseEntity.noContent().<Void>build();
	}
}
