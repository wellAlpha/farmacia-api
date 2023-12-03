package com.proj.farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.entities.FormaPagamento;
import com.proj.farmacia.repositories.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {
	@Autowired FormaPagamentoRepository formaPagamentoRepository;

	public List<FormaPagamento> listAtivos () {
		List<FormaPagamento> formas = formaPagamentoRepository.findByAtivoTrue();

		return formas;
	}

}
