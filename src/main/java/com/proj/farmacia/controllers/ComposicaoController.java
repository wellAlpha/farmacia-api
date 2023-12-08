package com.proj.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.farmacia.entities.Composicao;
import com.proj.farmacia.services.ComposicaoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/api/composicoes")
public class ComposicaoController {
    @Autowired ComposicaoService composicaoService;
    @GetMapping()
	public ResponseEntity<List<Composicao>> listTiposMedicacoes (){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(composicaoService.listAtivos());
	}
}
