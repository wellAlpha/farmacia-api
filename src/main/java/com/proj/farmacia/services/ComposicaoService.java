package com.proj.farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.entities.Composicao;
import com.proj.farmacia.repositories.ComposicaoRepository;

@Service
public class ComposicaoService {
    @Autowired ComposicaoRepository composicaoRepository;

	public List<Composicao> listAtivos () {
		List<Composicao> tiposComposicao = composicaoRepository.findByAtivoTrue();

		return tiposComposicao;
	}
}
