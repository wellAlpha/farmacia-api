package com.proj.farmacia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.dtos.categoria.cliente.CreateClienteDto;
import com.proj.farmacia.dtos.categoria.cliente.UpdateClienteDto;
import com.proj.farmacia.entities.Cliente;
import com.proj.farmacia.entities.Endereco;
import com.proj.farmacia.exceptions.BadRequestException;
import com.proj.farmacia.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired ClienteRepository clienteRepository;

	public List<Cliente> listAtivos () {
		List<Cliente> clientes = clienteRepository.findByAtivoTrue();

		return clientes;
	}
	
	public Cliente create (CreateClienteDto clienteDto) throws Exception {
		var enderecoDto = clienteDto.getEndereco();
		Endereco endereco = new Endereco(enderecoDto.getLogradouro(), enderecoDto.getCep(), enderecoDto.getMunicipio(), enderecoDto.getNumero(), enderecoDto.getComplemento(), enderecoDto.getBairro(), enderecoDto.getEstado());
		var newCliente = new Cliente(clienteDto.getNome(), clienteDto.getCpf(), clienteDto.getCelular(), clienteDto.getEmail(), endereco);
		Cliente cliente = clienteRepository.findByCpf(newCliente.getCpf());
		
		if (cliente != null) {
			throw new BadRequestException("Já existe um cliente cadastrado com este CPF.");
		}
		Cliente clientes = clienteRepository.save(newCliente);

		return clientes;
	}
	
	public Cliente update (Integer id, UpdateClienteDto clienteDto) {
		Optional<Cliente> clienteOp = clienteRepository.findById(id);
		
		if (clienteOp.isEmpty()) {
			throw new BadRequestException("Este cliente não está cadastrado.");
		}
		Cliente cliente = clienteOp.get();
		
		var enderecoDto = clienteDto.getEndereco();
		
		cliente.setNome(clienteDto.getNome());
		cliente.setCpf(clienteDto.getCpf());
		cliente.setCelular(clienteDto.getCelular());
		cliente.setEmail(clienteDto.getEmail());
		var endereco = cliente.getEndereco();

		endereco.setCep(enderecoDto.getCep());
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setEstado(enderecoDto.getEstado());
		endereco.setMunicipio(enderecoDto.getMunicipio());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setNumero(enderecoDto.getNumero());

		Cliente clienteUpdated = clienteRepository.save(cliente);

		return clienteUpdated;
	}

	public void delete (Integer id) {
		Optional<Cliente> clienteOp = clienteRepository.findById(id);
		
		if (clienteOp.isEmpty()) {
			throw new BadRequestException("Este cliente não está cadastrado.");
		}
		Cliente cliente = clienteOp.get();
		
		clienteRepository.delete(cliente);
	}
}
