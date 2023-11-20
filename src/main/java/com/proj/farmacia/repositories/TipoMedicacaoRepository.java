package com.proj.farmacia.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.farmacia.entities.TipoMedicacao;

public interface TipoMedicacaoRepository extends JpaRepository<TipoMedicacao, Integer>{
	List<TipoMedicacao> findByAtivoTrue();
}
