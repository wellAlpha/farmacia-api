package com.proj.farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.dtos.categoria.cliente.CreateClienteDto;
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
	
	public Cliente update (Cliente newCliente) {
		Cliente clientes = clienteRepository.save(newCliente);

		return clientes;
	}
}
