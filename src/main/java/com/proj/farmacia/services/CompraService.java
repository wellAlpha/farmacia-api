package com.proj.farmacia.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.dtos.compra.CompraDTO;
import com.proj.farmacia.dtos.itemCompra.ItemCompraDTO;
import com.proj.farmacia.entities.Cliente;
import com.proj.farmacia.entities.Compra;
import com.proj.farmacia.entities.FormaPagamento;
import com.proj.farmacia.entities.Funcionario;
import com.proj.farmacia.entities.ItemCompra;
import com.proj.farmacia.exceptions.NotFoundException;
import com.proj.farmacia.mappers.ClienteMapper;
import com.proj.farmacia.mappers.FormaPagamentoMapper;
import com.proj.farmacia.mappers.FuncionarioMapper;
import com.proj.farmacia.mappers.ItemCompraMapper;
import com.proj.farmacia.repositories.CompraRepository;
import com.proj.farmacia.repositories.ItemCompraRepository;

@Service
public class CompraService {
	@Autowired CompraRepository compraRepository;
	@Autowired ItemCompraRepository itemCompraRepository;

	public List<Compra> list () {
		List<Compra> compras = compraRepository.findAll();

		return compras;
	}

	public Compra findById (Integer id) {
		Optional<Compra> compra = compraRepository.findById(id);

		if(compra.isEmpty())
			throw new NotFoundException("Compra não consta em nossos registros.");

		return compra.get();

	}

	public List<Compra> findByClienteId (Integer id) {
		List<Compra> compras = compraRepository.findByClienteId(id);
		return compras;

	}

	public Compra store (CompraDTO compraDTO) {
		Cliente cliente = ClienteMapper.INSTANCE.clienteDtoToCliente(compraDTO.getCliente());
		FormaPagamento formaPagamento = FormaPagamentoMapper.INSTANCE.formaPagamentoDtoToFormaPagamento(compraDTO.getFormaPagamento());
		Funcionario funcionario = FuncionarioMapper.INSTANCE.funcionarioDtoToFuncionario(compraDTO.getFuncionario());

		Compra compra = new Compra();
		compra.setCliente(cliente);
		compra.setFormaPagamento(formaPagamento);
		compra.setFuncionario(funcionario);
		compra.setParcelas(compraDTO.getParcelas());
		compra.setPrecoTotal(compraDTO.getTotal());
		Compra compraSaved = compraRepository.save(compra);
		Set<ItemCompra> itensCompra = new HashSet<>();

		for (ItemCompraDTO itemCompraDto : compraDTO.getItensCompra()) {
			ItemCompra itemCompra = ItemCompraMapper.INSTANCE.ItemCompraDtoToItemCompra(itemCompraDto);
			itemCompra.setCompra(compraSaved);
			itensCompra.add(itemCompra);
		}
		var itens = itemCompraRepository.saveAll(itensCompra);
		compraSaved.setItens(itens);
		return compraSaved;
	}

}
