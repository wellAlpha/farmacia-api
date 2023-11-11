package com.proj.farmacia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.dtos.cargo.CreateCargoDTO;
import com.proj.farmacia.dtos.endereco.CreateEnderecoDTO;
import com.proj.farmacia.dtos.funcionario.CreateFuncionarioDTO;
import com.proj.farmacia.dtos.funcionario.UpdateFuncionarioDTO;
import com.proj.farmacia.entities.Cargo;
import com.proj.farmacia.entities.Endereco;
import com.proj.farmacia.entities.Funcionario;
import com.proj.farmacia.exceptions.BadRequestException;
import com.proj.farmacia.exceptions.NotFoundException;
import com.proj.farmacia.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listAtivoTrue(){
        return funcionarioRepository.findByAtivoTrue();
    }

    public Funcionario get (Integer id) {
		Optional<Funcionario> funcionarioOp = funcionarioRepository.findById(id);

		if (funcionarioOp.isEmpty()) {
			throw new NotFoundException("Este funcionário não está cadastrado.");
		}

		Funcionario cliente = funcionarioOp.get();
		
		return cliente;
	}

	public Funcionario create (CreateFuncionarioDTO funcionarioDto) {
		CreateEnderecoDTO enderecoDto = funcionarioDto.getEndereco();
        CreateCargoDTO cargoDto = funcionarioDto.getCargo();

        Cargo cargo = new Cargo();
        cargo.setId(cargoDto.getId());

		Endereco endereco = new Endereco();
		
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setCep(enderecoDto.getCep());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setEstado(enderecoDto.getEstado());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setMunicipio(enderecoDto.getMunicipio());
		endereco.setNumero(enderecoDto.getNumero());

		Funcionario newFuncionario = new Funcionario();

		newFuncionario.setNome(funcionarioDto.getNome());
		newFuncionario.setCpf(funcionarioDto.getCpf());
		newFuncionario.setTelefone(funcionarioDto.getTelefone());
		newFuncionario.setEmail(funcionarioDto.getEmail());
		newFuncionario.setEndereco(endereco);
        newFuncionario.setCargo(cargo);

		Funcionario cliente = funcionarioRepository.findByCpf(newFuncionario.getCpf());
		
		if (cliente != null) {
			throw new BadRequestException("Já existe um funcionário cadastrado com este CPF.");
		}
		Funcionario clientes = funcionarioRepository.save(newFuncionario);

		return clientes;
	}
	
	public Funcionario update (Integer id, UpdateFuncionarioDTO funcionarioDto) {
		Optional<Funcionario> funcionarioOp = funcionarioRepository.findById(id);
		
		if (funcionarioOp.isEmpty()) {
			throw new NotFoundException("Este funcionário não está cadastrado.");
		}
		Funcionario funcionario = funcionarioOp.get();
        CreateCargoDTO cargoDto = funcionarioDto.getCargo();

        Cargo cargo = new Cargo();
        cargo.setId(cargoDto.getId());
		
		var enderecoDto = funcionarioDto.getEndereco();
		
		
		var endereco = funcionario.getEndereco();

		endereco.setCep(enderecoDto.getCep());
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setEstado(enderecoDto.getEstado());
		endereco.setMunicipio(enderecoDto.getMunicipio());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setNumero(enderecoDto.getNumero());

        funcionario.setNome(funcionarioDto.getNome());
		funcionario.setCpf(funcionarioDto.getCpf());
		funcionario.setTelefone(funcionarioDto.getTelefone());
		funcionario.setEmail(funcionarioDto.getEmail());
        funcionario.setEndereco(endereco);
        funcionario.setCargo(cargo);

		Funcionario funcUpdated = funcionarioRepository.save(funcionario);

		return funcUpdated;
	}
    public void delete(Integer id){
        Optional<Funcionario> funcOp = funcionarioRepository.findById(id);
		
		if (funcOp.isEmpty()) {
			throw new NotFoundException("Este funcionário não está cadastrado.");
		}
        funcionarioRepository.deleteById(id);
    }
}
