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

import com.proj.farmacia.dtos.medicacao.MedicacaoCreateDTO;
import com.proj.farmacia.dtos.medicacao.UpdateMedicacaoDTO;
import com.proj.farmacia.entities.Medicacao;
import com.proj.farmacia.services.MedicacaoService;

import jakarta.validation.Valid;
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

	@PostMapping()
	public ResponseEntity<Medicacao> create(@RequestBody @Valid MedicacaoCreateDTO medicacaoDto) throws Exception{
			return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(medicacaoService.create(medicacaoDto));
	}

	   @PutMapping(path = "/{id}")
	public ResponseEntity<Medicacao> update(@PathVariable @Positive Integer id, @RequestBody @Valid UpdateMedicacaoDTO medicacaoDto) throws Exception{
			return ResponseEntity.ok().body(medicacaoService.update(id, medicacaoDto));
	
	}

}
