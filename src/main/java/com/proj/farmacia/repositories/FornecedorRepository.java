package com.proj.farmacia.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.farmacia.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>{
	List<Fornecedor> findByAtivoTrue();
}
