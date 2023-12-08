package com.proj.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.farmacia.entities.TipoConteudo;
import com.proj.farmacia.services.TipoConteudoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/api/tipos-conteudo")
public class TipoConteudoController {
    @Autowired TipoConteudoService tipoConteudoService;
    @GetMapping()
	public ResponseEntity<List<TipoConteudo>> listTiposConteudo (){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(tipoConteudoService.listAtivos());
	}
}
