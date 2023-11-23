package com.proj.farmacia.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.farmacia.entities.TipoConteudo;

public interface TipoConteudoRepository extends JpaRepository<TipoConteudo, Integer>{
	List<TipoConteudo> findByAtivoTrue();
}
