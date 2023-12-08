package com.proj.farmacia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.entities.Medicacao;
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
			throw new NotFoundException("Este cliente não está cadastrado.");
		}

		Medicacao medicacao = medicacaoOp.get();
		return medicacao;
	}	
	

	// public Cliente create (CreateClienteDTO clienteDto) {
	// 	CreateEnderecoDTO enderecoDto = clienteDto.getEndereco();

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
