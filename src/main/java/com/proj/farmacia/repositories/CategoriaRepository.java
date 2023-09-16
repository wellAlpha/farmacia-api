package com.proj.farmacia.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.farmacia.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	List<Categoria> findByAtivoTrue();
}
