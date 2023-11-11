package com.proj.farmacia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.dtos.endereco.CreateEnderecoDTO;
import com.proj.farmacia.dtos.fornecedor.CreateFornecedorDTO;
import com.proj.farmacia.dtos.fornecedor.UpdateFornecedorDTO;
import com.proj.farmacia.entities.Endereco;
import com.proj.farmacia.entities.Fornecedor;
import com.proj.farmacia.exceptions.BadRequestException;
import com.proj.farmacia.exceptions.NotFoundException;
import com.proj.farmacia.repositories.FornecedorRepository;

@Service
public class FornecedorService {
	@Autowired FornecedorRepository fornecedorRepository;

	public List<Fornecedor> listAtivos () {
		List<Fornecedor> fornecedores = fornecedorRepository.findByAtivoTrue();

		return fornecedores;
	}

	public Fornecedor get (Integer id) {
		Optional<Fornecedor> fornecedorOp = fornecedorRepository.findById(id);

		if (fornecedorOp.isEmpty()) {
			throw new NotFoundException("Este fornecedor não está cadastrado.");
		}

		Fornecedor fornecedor= fornecedorOp.get();
		return fornecedor;
	}	

	public Fornecedor create (CreateFornecedorDTO fornecedorDTO) {
		CreateEnderecoDTO enderecoDto = fornecedorDTO.getEndereco();

		Endereco endereco = new Endereco();
		
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setCep(enderecoDto.getCep());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setEstado(enderecoDto.getEstado());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setMunicipio(enderecoDto.getMunicipio());
		endereco.setNumero(enderecoDto.getNumero());

		Fornecedor newFornecedor = new Fornecedor ();

		newFornecedor.setNome(fornecedorDTO.getNome());
		newFornecedor.setCnpj(fornecedorDTO.getCnpj());
		newFornecedor.setEndereco(endereco);

		Fornecedor fornecedor  = fornecedorRepository.findByCnpj(newFornecedor.getCnpj());
 	
		if (fornecedor != null) {
			throw new BadRequestException("Já existe um fornecedor cadastrado com este CNPJ.");
		}

		Fornecedor fornecedorSalvo = fornecedorRepository.save(newFornecedor);

		return fornecedorSalvo;
	}

	public Fornecedor update (Integer id, UpdateFornecedorDTO fornecedorDto) {
		Optional<Fornecedor> fornecedorOp = fornecedorRepository.findById(id);
		
		if (fornecedorOp.isEmpty()) {
			throw new NotFoundException("Este fornecedor não está cadastrado.");
		}
		Fornecedor fornecedor = fornecedorOp.get();
		
		var enderecoDto = fornecedorDto.getEndereco();
		
		
		var endereco = fornecedor.getEndereco();

		endereco.setCep(enderecoDto.getCep());
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setEstado(enderecoDto.getEstado());
		endereco.setMunicipio(enderecoDto.getMunicipio());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setNumero(enderecoDto.getNumero());

		
		fornecedor.setNome(fornecedorDto.getNome());
		fornecedor.setCnpj(fornecedorDto.getCnpj());
		fornecedor.setEndereco(endereco);

		Fornecedor fornecedorUpdated = fornecedorRepository.save(fornecedor);

		return fornecedorUpdated;
	}

	public void delete (Integer id) {
		Optional<Fornecedor> fornecedorOp = fornecedorRepository.findById(id);
		
		if (fornecedorOp.isEmpty()) {
			throw new NotFoundException("Este cliente não está cadastrado.");
		}
		Fornecedor fornecedor = fornecedorOp.get();
		
		fornecedorRepository.delete(fornecedor);
	}
}

