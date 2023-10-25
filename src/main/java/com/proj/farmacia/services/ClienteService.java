package com.proj.farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.entities.Cliente;
import com.proj.farmacia.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired ClienteRepository clienteRepository;

	public List<Cliente> list () {
		List<Cliente> clientes = clienteRepository.findByAtivoTrue();

		return clientes;
	}
	
	public Cliente create (Cliente newCliente) {
		Cliente clientes = clienteRepository.save(newCliente);

		return clientes;
	}
	
	public Cliente update (Cliente newCliente) {
		Cliente clientes = clienteRepository.save(newCliente);

		return clientes;
	}
}
