package com.proj.farmacia.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.farmacia.entities.Fabricante;

public interface FabricanteRepository extends JpaRepository<Fabricante, Integer>{
	List<Fabricante> findByAtivoTrue();
	Fabricante findByCnpj(String cnpj);
}
