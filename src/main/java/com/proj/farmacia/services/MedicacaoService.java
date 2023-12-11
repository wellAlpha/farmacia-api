package com.proj.farmacia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.dtos.TipoMedicacao.TipoMedicacaoDTO;
import com.proj.farmacia.dtos.composicao.ComposicaoDTO;
import com.proj.farmacia.dtos.medicacao.MedicacaoCreateDTO;
import com.proj.farmacia.dtos.medicacao.UpdateMedicacaoDTO;
import com.proj.farmacia.entities.Cliente;
import com.proj.farmacia.entities.Composicao;
import com.proj.farmacia.entities.Fabricante;
import com.proj.farmacia.entities.Fornecedor;
import com.proj.farmacia.entities.Medicacao;
import com.proj.farmacia.entities.TipoConteudo;
import com.proj.farmacia.entities.TipoMedicacao;
import com.proj.farmacia.exceptions.NotFoundException;
import com.proj.farmacia.repositories.MedicacaoRepository;

@Service
public class MedicacaoService {
	@Autowired
	MedicacaoRepository medicacaoRepository;

	public List<Medicacao> listAtivos() {
		List<Medicacao> medicacoes = medicacaoRepository.findByAtivoTrue();

		return medicacoes;
	}

	public Medicacao get(Integer id) {
		Optional<Medicacao> medicacaoOp = medicacaoRepository.findById(id);

		if (medicacaoOp.isEmpty()) {
			throw new NotFoundException("Esta medicacao não foi encontrada.");
		}

		Medicacao medicacao = medicacaoOp.get();
		return medicacao;
	}

	public List<Medicacao> search (String nome) {
		List<Medicacao> medicacoes = medicacaoRepository.findByNomeContains(nome);

		return medicacoes;
	}

	public Medicacao create(MedicacaoCreateDTO medicacaoCreateDto) {

		Medicacao medicacao = new Medicacao();

		medicacao.setNome(medicacaoCreateDto.getNome());
		medicacao.setConteudo(medicacaoCreateDto.getConteudo());
		medicacao.setPreco(medicacaoCreateDto.getPreco());

		TipoConteudo tipoConteudo = new TipoConteudo();

		tipoConteudo.setDescricao(medicacaoCreateDto.getTipoConteudo().getDescricao());
		tipoConteudo.setId(medicacaoCreateDto.getTipoConteudo().getId());

		medicacao.setTipoConteudo(tipoConteudo);

		Fabricante fabricante = new Fabricante();

		fabricante.setNome(medicacaoCreateDto.getFabricante().getNome());
		fabricante.setId(medicacaoCreateDto.getFabricante().getId());

		medicacao.setFabricante(fabricante);

		Fornecedor fornecedor = new Fornecedor();

		fornecedor.setNome(medicacaoCreateDto.getFornecedor().getNome());
		fornecedor.setId(medicacaoCreateDto.getFornecedor().getId());

		medicacao.setFornecedor(fornecedor);

		List<Composicao> composicoes = new ArrayList<>();

		for (ComposicaoDTO composicaoDto : medicacaoCreateDto.getComposicoes()) {

			Composicao composicao = new Composicao();

			composicao.setId(composicaoDto.getId());
			composicao.setDescricao(composicaoDto.getDescricao());
			composicoes.add(composicao);
		}

		medicacao.setComposicoes(composicoes);

		List<TipoMedicacao> tiposMedicacaoes = new ArrayList<>();

		for (TipoMedicacaoDTO tipoMedicacaoDTO : medicacaoCreateDto.getTipoMedicacao()) {

			TipoMedicacao tipoMedicacao = new TipoMedicacao();

			tipoMedicacao.setId(tipoMedicacaoDTO.getId());
			tipoMedicacao.setDescricao(tipoMedicacaoDTO.getDescricao());
			tiposMedicacaoes.add(tipoMedicacao);
		}

		medicacao.setTipos(tiposMedicacaoes);

		Medicacao novaMedicacao = medicacaoRepository.save(medicacao);

		return novaMedicacao;

	}

	public Medicacao update(Integer id, UpdateMedicacaoDTO medicacaoUpdateDto) {
		Optional<Medicacao> medicacaoOp = medicacaoRepository.findById(id);

		if (medicacaoOp.isEmpty()) {
			throw new NotFoundException("Este medicação não está cadastrada.");
		}

		Medicacao medicacao = medicacaoOp.get();

		
		medicacao.setNome(medicacaoUpdateDto.getNome());
		medicacao.setConteudo(medicacaoUpdateDto.getConteudo());
		medicacao.setPreco(medicacaoUpdateDto.getPreco());

		TipoConteudo tipoConteudo = new TipoConteudo();

		tipoConteudo.setDescricao(medicacaoUpdateDto.getTipoConteudo().getDescricao());
		tipoConteudo.setId(medicacaoUpdateDto.getTipoConteudo().getId());

		medicacao.setTipoConteudo(tipoConteudo);

		Fabricante fabricante = new Fabricante();

		fabricante.setNome(medicacaoUpdateDto.getFabricante().getNome());
		fabricante.setId(medicacaoUpdateDto.getFabricante().getId());

		medicacao.setFabricante(fabricante);

		Fornecedor fornecedor = new Fornecedor();

		fornecedor.setNome(medicacaoUpdateDto.getFornecedor().getNome());
		fornecedor.setId(medicacaoUpdateDto.getFabricante().getId());

		medicacao.setFornecedor(fornecedor);

		List<Composicao> composicoes = new ArrayList<>();

		for (ComposicaoDTO composicaoDto : medicacaoUpdateDto.getComposicoes()) {

			Composicao composicao = new Composicao();

			composicao.setId(composicaoDto.getId());
			composicao.setDescricao(composicaoDto.getDescricao());
			composicoes.add(composicao);
		}

		medicacao.setComposicoes(composicoes);

		List<TipoMedicacao> tiposMedicacaoes = new ArrayList<>();

		for (TipoMedicacaoDTO tipoMedicacaoDTO : medicacaoUpdateDto.getTipoMedicacao()) {

			TipoMedicacao tipoMedicacao = new TipoMedicacao();

			tipoMedicacao.setId(tipoMedicacaoDTO.getId());
			tipoMedicacao.setDescricao(tipoMedicacaoDTO.getDescricao());
			tiposMedicacaoes.add(tipoMedicacao);
		}

		medicacao.setTipos(tiposMedicacaoes);

		Medicacao novaMedicacao = medicacaoRepository.save(medicacao);

		return novaMedicacao;
		
	}

	public void delete(Integer id) {
		Optional<Medicacao> medicacaoOp = medicacaoRepository.findById(id);

		if (medicacaoOp.isEmpty()) {
			throw new NotFoundException("Este medicamento não está cadastrado.");
		}
		Medicacao medicacao = medicacaoOp.get();

		medicacaoRepository.delete(medicacao);
	}

}
