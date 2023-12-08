package com.proj.farmacia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.dtos.TipoMedicacao.TipoMedicacaoDTO;
import com.proj.farmacia.dtos.composicao.ComposicaoDTO;
import com.proj.farmacia.dtos.medicacao.MedicacaoCreateDTO;
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
	@Autowired MedicacaoRepository medicacaoRepository;

	public List<Medicacao> listAtivos () {
		List<Medicacao> medicacoes = medicacaoRepository.findByAtivoTrue();

		return medicacoes;
	}
	
	public Medicacao get (Integer id) {
		Optional<Medicacao> medicacaoOp = medicacaoRepository.findById(id);

		if (medicacaoOp.isEmpty()) {
			throw new NotFoundException("Esta medicacao não foi encontrada.");
		}

		Medicacao medicacao = medicacaoOp.get();
		return medicacao;
	}	
	

	 public Medicacao create (MedicacaoCreateDTO medicacaoCreateDto) {
		
		Medicacao medicacao = new Medicacao();

		medicacao.setNome(medicacaoCreateDto.getNome());
		medicacao.setConteudo(medicacaoCreateDto.getConteudo());


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
		fornecedor.setId(medicacaoCreateDto.getFabricante().getId());

		medicacao.setFornecedor(fornecedor);

		
		List<Composicao> composicoes = new ArrayList<>();

		for (ComposicaoDTO composicaoDto :medicacaoCreateDto.getComposicoes()) {
			
			Composicao composicao = new Composicao();

			composicao.setId(composicaoDto.getId());
			composicao.setDescricao(composicaoDto.getDescricao());
			composicoes.add(composicao);
		}

		medicacao.setComposicoes(composicoes);

		List<TipoMedicacao> tiposMedicacaoes = new ArrayList<>();
		
		for (TipoMedicacaoDTO tipoMedicacaoDTO :medicacaoCreateDto.getTipoMedicacao()){

			TipoMedicacao tipoMedicacao = new TipoMedicacao();

			tipoMedicacao.setId(tipoMedicacaoDTO.getId());
			tipoMedicacao.setDescricao(tipoMedicacaoDTO.getDescricao());
			tiposMedicacaoes.add(tipoMedicacao);
		}

		medicacao.setTipos(tiposMedicacaoes);

	    Medicacao novaMedicacao = medicacaoRepository.save(medicacao);


		return novaMedicacao;

	 }
	//	CreateEnderecoDTO enderecoDto = clienteDto.getEndereco();

	// 	Endereco endereco = new Endereco();
		
	// 	endereco.setBairro(enderecoDto.getBairro());
	// 	endereco.setCep(enderecoDto.getCep());
	// 	endereco.setComplemento(enderecoDto.getComplemento());
	// 	endereco.setEstado(enderecoDto.getEstado());
	// 	endereco.setLogradouro(enderecoDto.getLogradouro());
	// 	endereco.setMunicipio(enderecoDto.getMunicipio());
	// 	endereco.setNumero(enderecoDto.getNumero());

	// 	Cliente newCliente = new Cliente();

	// 	newCliente.setNome(clienteDto.getNome());
	// 	newCliente.setCpf(clienteDto.getCpf());
	// 	newCliente.setTelefone(clienteDto.getTelefone());
	// 	newCliente.setEmail(clienteDto.getEmail());
	// 	newCliente.setEndereco(endereco);

	// 	Cliente cliente = medicacaoRepository.findByCpf(newCliente.getCpf());
		
	// 	if (cliente != null) {
	// 		throw new BadRequestException("Já existe um cliente cadastrado com este CPF.");
	// 	}
	// 	Cliente clientes = medicacaoRepository.save(newCliente);

	// 	return clientes;
	// }
	
	// public Medicacao update (Integer id, UpdateClienteDTO clienteDto) {
	// 	Optional<Medicacao> clienteOp = medicacaoRepository.findById(id);
		
	// 	if (clienteOp.isEmpty()) {
	// 		throw new NotFoundException("Este cliente não está cadastrado.");
	// 	}
	// 	Cliente cliente = clienteOp.get();
		
	// 	var enderecoDto = clienteDto.getEndereco();
		
		
	// 	var endereco = cliente.getEndereco();

	// 	endereco.setCep(enderecoDto.getCep());
	// 	endereco.setBairro(enderecoDto.getBairro());
	// 	endereco.setComplemento(enderecoDto.getComplemento());
	// 	endereco.setEstado(enderecoDto.getEstado());
	// 	endereco.setMunicipio(enderecoDto.getMunicipio());
	// 	endereco.setLogradouro(enderecoDto.getLogradouro());
	// 	endereco.setNumero(enderecoDto.getNumero());

	// 	cliente.setNome(clienteDto.getNome());
	// 	cliente.setCpf(clienteDto.getCpf());
	// 	cliente.setTelefone(clienteDto.getTelefone());
	// 	cliente.setEmail(clienteDto.getEmail());
	// 	cliente.setEndereco(endereco);

	// 	Medicacao medicacaoUpdated = medicacaoRepository.save(cliente);

	// 	return medicacaoUpdated;
	// }

	public void delete (Integer id) {
		Optional<Medicacao> medicacaoOp = medicacaoRepository.findById(id);
		
		if (medicacaoOp.isEmpty()) {
			throw new NotFoundException("Este medicamento não está cadastrado.");
		}
		Medicacao medicacao = medicacaoOp.get();
		
		medicacaoRepository.delete(medicacao);
	}
}
