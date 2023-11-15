package com.proj.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.farmacia.entities.TipoMedicacao;
import com.proj.farmacia.services.TipoMedicacaoService;

@RestController()
@RequestMapping("/api/tipos-medicacoes")
public class TipoMedicacaoController {
    @Autowired TipoMedicacaoService tipoMedicacaoService;
    @GetMapping()
	public ResponseEntity<List<TipoMedicacao>> listTiposMedicacoes (){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(tipoMedicacaoService.listAtivos());
	}
}
