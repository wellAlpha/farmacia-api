package com.proj.farmacia.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.farmacia.entities.Composicao;

public interface ComposicaoRepository extends JpaRepository<Composicao, Integer>{
	List<Composicao> findByAtivoTrue();
}
