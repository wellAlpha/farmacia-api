package com.proj.farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.entities.TipoConteudo;
import com.proj.farmacia.repositories.TipoConteudoRepository;

@Service
public class TipoConteudoService {
	@Autowired TipoConteudoRepository tipoConteudoRepository;

	public List<TipoConteudo> listAtivos () {
		List<TipoConteudo> cargos = tipoConteudoRepository.findByAtivoTrue();

		return cargos;
	}

}
