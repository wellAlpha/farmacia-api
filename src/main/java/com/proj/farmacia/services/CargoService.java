package com.proj.farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.entities.Cargo;
import com.proj.farmacia.repositories.CargoRepository;

@Service
public class CargoService {
	@Autowired CargoRepository cargoRepository;

	public List<Cargo> listAtivos () {
		List<Cargo> cargos = cargoRepository.findByAtivoTrue();

		return cargos;
	}

}
