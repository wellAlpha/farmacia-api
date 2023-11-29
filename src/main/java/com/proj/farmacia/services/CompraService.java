package com.proj.farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.dtos.compra.CreateCompraDTO;
import com.proj.farmacia.entities.Cliente;
import com.proj.farmacia.entities.Compra;
import com.proj.farmacia.entities.ItemCompra;
import com.proj.farmacia.mappers.ClienteMapper;
import com.proj.farmacia.repositories.CompraRepository;

@Service
public class CompraService {
	@Autowired CompraRepository compraRepository;

	public List<Compra> listAtivos () {
		List<Compra> compras = compraRepository.findByAtivoTrue();

		return compras;
	}

	public Compra store (CreateCompraDTO createCompraDTO) {
		Cliente cliente = ClienteMapper.INSTANCE.createClienteDtoToCliente(createCompraDTO.getCliente());
		Compra compra = new Compra();


		compra.setCliente(cliente);
		compra.setFormaPagamento(null);
		compra.setFuncionario(null);
		compra.setCliente(null);
		compra.setParcelas(null);
		compra.setPrecoTotal(null);

		// Compra compraSaved = compraRepository.save(compra);

		ItemCompra itemCompra = new ItemCompra();

		// itemCompra.setCompra(compraSaved);
		itemCompra.setMedicacao(null);
		itemCompra.setPrecoUnitario(null);
		itemCompra.setCompra(compra);
		itemCompra.setQuantidade(null);

		return compra;
	}

}
