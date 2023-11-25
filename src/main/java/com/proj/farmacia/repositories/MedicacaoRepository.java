package com.proj.farmacia.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.farmacia.entities.Medicacao;

public interface MedicacaoRepository extends JpaRepository<Medicacao, Integer>{
	List<Medicacao> findByAtivoTrue();
}
