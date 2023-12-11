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
import com.proj.farmacia.entities.Medicacao;
import com.proj.farmacia.exceptions.NotFoundException;
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
		Compra compra = new Compra();
		if(compraDTO.getCliente() != null){
			Cliente cliente = new Cliente();

			cliente.setId(compraDTO.getCliente().getId());
			cliente.setCpf(compraDTO.getCliente().getCpf());
			cliente.setEmail(compraDTO.getCliente().getEmail());
			cliente.setTelefone(compraDTO.getCliente().getTelefone());
			cliente.setNome(compraDTO.getCliente().getNome());
			compra.setCliente(cliente);
		}
		

		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.setId(compraDTO.getFormaPagamento().getId());
		formaPagamento.setDescricao(compraDTO.getFormaPagamento().getDescricao());
		formaPagamento.setAtivo(compraDTO.getFormaPagamento().getAtivo());
		compra.setFormaPagamento(formaPagamento);

		if(compraDTO.getFuncionario() != null) {
			Funcionario funcionario = new Funcionario();
			funcionario.setId(compraDTO.getFuncionario().getId());
			funcionario.setNome(compraDTO.getFuncionario().getNome());
			funcionario.setCpf(compraDTO.getFuncionario().getCpf());
			funcionario.setEmail(compraDTO.getFuncionario().getEmail());

			compra.setFuncionario(funcionario);
		}

		compra.setParcelas(compraDTO.getParcelas());
		compra.setPrecoTotal(compraDTO.getTotal());
		Compra compraSaved = compraRepository.save(compra);

		Set<ItemCompra> itensCompra = new HashSet<>();

		for (ItemCompraDTO itemCompraDto : compraDTO.getItensCompra()) {
			ItemCompra itemCompra = new ItemCompra();
			

			itemCompra.setPrecoUnitario(itemCompraDto.getPrecoUnitario());
			itemCompra.setCompra(compraSaved);
			itemCompra.setQuantidade(itemCompraDto.getQuantidade());
	
			Medicacao med = new Medicacao();
			med.setId(itemCompraDto.getMedicacao().getId());
			med.setNome(itemCompraDto.getMedicacao().getNome());
			itemCompra.setMedicacao(med);

			itensCompra.add(itemCompra);
		}

		var itens = itemCompraRepository.saveAll(itensCompra);

		Optional<Compra> compraUpdated = compraRepository.findById(compraSaved.getId());

		return compraUpdated.get();
	}

}
