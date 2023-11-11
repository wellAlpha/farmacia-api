package com.proj.farmacia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.dtos.cliente.CreateClienteDTO;
import com.proj.farmacia.dtos.cliente.UpdateClienteDTO;
import com.proj.farmacia.dtos.endereco.CreateEnderecoDTO;
import com.proj.farmacia.entities.Cliente;
import com.proj.farmacia.entities.Endereco;
import com.proj.farmacia.exceptions.BadRequestException;
import com.proj.farmacia.exceptions.NotFoundException;
import com.proj.farmacia.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired ClienteRepository clienteRepository;

	public List<Cliente> listAtivos () {
		List<Cliente> clientes = clienteRepository.findByAtivoTrue();

		return clientes;
	}
	
	public Cliente get (Integer id) {
		Optional<Cliente> clienteOp = clienteRepository.findById(id);

		if (clienteOp.isEmpty()) {
			throw new NotFoundException("Este cliente não está cadastrado.");
		}

		Cliente cliente = clienteOp.get();
		
		return cliente;
	}

	public Cliente create (CreateClienteDTO clienteDto) {
		CreateEnderecoDTO enderecoDto = clienteDto.getEndereco();

		Endereco endereco = new Endereco();
		
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setCep(enderecoDto.getCep());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setEstado(enderecoDto.getEstado());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setMunicipio(enderecoDto.getMunicipio());
		endereco.setNumero(enderecoDto.getNumero());

		Cliente newCliente = new Cliente();

		newCliente.setNome(clienteDto.getNome());
		newCliente.setCpf(clienteDto.getCpf());
		newCliente.setTelefone(clienteDto.getTelefone());
		newCliente.setEmail(clienteDto.getEmail());
		newCliente.setEndereco(endereco);

		Cliente cliente = clienteRepository.findByCpf(newCliente.getCpf());
		
		if (cliente != null) {
			throw new BadRequestException("Já existe um cliente cadastrado com este CPF.");
		}
		Cliente clientes = clienteRepository.save(newCliente);

		return clientes;
	}
	
	public Cliente update (Integer id, UpdateClienteDTO clienteDto) {
		Optional<Cliente> clienteOp = clienteRepository.findById(id);
		
		if (clienteOp.isEmpty()) {
			throw new NotFoundException("Este cliente não está cadastrado.");
		}
		Cliente cliente = clienteOp.get();
		
		var enderecoDto = clienteDto.getEndereco();
		
		
		var endereco = cliente.getEndereco();

		endereco.setCep(enderecoDto.getCep());
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setEstado(enderecoDto.getEstado());
		endereco.setMunicipio(enderecoDto.getMunicipio());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setNumero(enderecoDto.getNumero());

		cliente.setNome(clienteDto.getNome());
		cliente.setCpf(clienteDto.getCpf());
		cliente.setTelefone(clienteDto.getTelefone());
		cliente.setEmail(clienteDto.getEmail());
		cliente.setEndereco(endereco);

		Cliente clienteUpdated = clienteRepository.save(cliente);

		return clienteUpdated;
	}

	public void delete (Integer id) {
		Optional<Cliente> clienteOp = clienteRepository.findById(id);
		
		if (clienteOp.isEmpty()) {
			throw new NotFoundException("Este cliente não está cadastrado.");
		}
		Cliente cliente = clienteOp.get();
		
		clienteRepository.delete(cliente);
	}
}
