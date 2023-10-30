package com.proj.farmacia.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.farmacia.entities.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer>{
	List<Cargo> findByAtivoTrue();
}
