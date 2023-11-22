package com.proj.farmacia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.dtos.endereco.CreateEnderecoDTO;
import com.proj.farmacia.dtos.fabricante.CreateFabricanteDTO;
import com.proj.farmacia.dtos.fabricante.UpdateFabricanteDTO;
import com.proj.farmacia.entities.Endereco;
import com.proj.farmacia.entities.Fabricante;
import com.proj.farmacia.exceptions.BadRequestException;
import com.proj.farmacia.exceptions.NotFoundException;
import com.proj.farmacia.repositories.FabricanteRepository;

@Service
public class FabricanteService {
    @Autowired FabricanteRepository fabricanteRepository;
  
    
    public List<Fabricante> listAtivos(){
			List<Fabricante> fabricantes = fabricanteRepository.findByAtivoTrue();

        return fabricantes;
    }

	public Fabricante get (Integer id) {
		Optional<Fabricante> fabricanteOp = fabricanteRepository.findById(id);

		if (fabricanteOp.isEmpty()) {
			throw new NotFoundException("Este Fabricante não está cadastrado.");
		}

		Fabricante fabricante = fabricanteOp.get();
		
		return fabricante;
	}

	public Fabricante create (CreateFabricanteDTO fabricanteDTO) {
		CreateEnderecoDTO enderecoDto = fabricanteDTO.getEndereco();

		Endereco endereco = new Endereco();
		
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setCep(enderecoDto.getCep());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setEstado(enderecoDto.getEstado());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setMunicipio(enderecoDto.getMunicipio());
		endereco.setNumero(enderecoDto.getNumero());	
	
		Fabricante newFabricante = new Fabricante();

		newFabricante.setNome(fabricanteDTO.getNome());
		newFabricante.setCnpj(fabricanteDTO.getCnpj());
		newFabricante.setEndereco(endereco);

		Fabricante fabricante  = fabricanteRepository.findByCnpj(newFabricante.getCnpj());
 	
		if (fabricante != null) {
			throw new BadRequestException("Já existe um fabricante cadastrado com este CNPJ.");
		}
		

		Fabricante fabricanteSalvo = fabricanteRepository.save(newFabricante);

		return fabricanteSalvo;
	}
			
	public Fabricante update (Integer id, UpdateFabricanteDTO fabricanteDto) {
		Optional<Fabricante> fabricanteOp = fabricanteRepository.findById(id);
		
		if (fabricanteOp.isEmpty()) {
			throw new NotFoundException("Este fabricante não está cadastrado.");
		}
		Fabricante fabricante = fabricanteOp.get();
		
		var enderecoDto = fabricanteDto.getEndereco();
		
		
		var endereco = fabricante.getEndereco();

		endereco.setCep(enderecoDto.getCep());
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setEstado(enderecoDto.getEstado());
		endereco.setMunicipio(enderecoDto.getMunicipio());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setNumero(enderecoDto.getNumero());

		
		fabricante.setNome(fabricanteDto.getNome());
		fabricante.setCnpj(fabricanteDto.getCnpj());
		fabricante.setEndereco(endereco);

		Fabricante fabricanteUpdated = fabricanteRepository.save(fabricante);

		return fabricanteUpdated;
	}

	public void delete (Integer id) {
		Optional<Fabricante> fabricanteOp = fabricanteRepository.findById(id);
		
		if (fabricanteOp.isEmpty()) {
			throw new NotFoundException("Este fabricante não está cadastrado.");
		}

		Fabricante fabricante = fabricanteOp.get();
		
		fabricanteRepository.delete(fabricante);
	}
}
    



