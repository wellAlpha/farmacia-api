package com.proj.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.farmacia.entities.FormaPagamento;
import com.proj.farmacia.services.FormaPagamentoService;

@RestController()
@RequestMapping("/api/formas-pagamento")
public class FormaPagamentoController {
    @Autowired FormaPagamentoService formaPagamentoService;
    @GetMapping()
	public ResponseEntity<List<FormaPagamento>> listFormasPagamento (){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(formaPagamentoService.listAtivos());
	}
}
