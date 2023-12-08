package com.proj.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.farmacia.entities.Cargo;
import com.proj.farmacia.services.CargoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/api/cargos")
public class CargoController {
    @Autowired CargoService cargoService;
    @GetMapping()
	public ResponseEntity<List<Cargo>> listClientes (){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(cargoService.listAtivos());
	}
}
