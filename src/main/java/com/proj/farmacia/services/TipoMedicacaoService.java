package com.proj.farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.entities.TipoMedicacao;
import com.proj.farmacia.repositories.TipoMedicacaoRepository;

@Service
public class TipoMedicacaoService {
    @Autowired TipoMedicacaoRepository tipoMedicacaoRepository;

	public List<TipoMedicacao> listAtivos () {
		List<TipoMedicacao> tipos = tipoMedicacaoRepository.findByAtivoTrue();

		return tipos;
	}

}
