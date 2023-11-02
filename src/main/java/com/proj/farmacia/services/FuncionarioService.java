package com.proj.farmacia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.farmacia.entities.Funcionario;
import com.proj.farmacia.exceptions.BadRequestException;
import com.proj.farmacia.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listAtivoTrue(){
        return funcionarioRepository.findByAtivoTrue();
    }

    public void delete(Integer id){
        Optional<Funcionario> funcOp = funcionarioRepository.findById(id);
		
		if (funcOp.isEmpty()) {
			throw new BadRequestException("Este cliente não está cadastrado.");
		}
        funcionarioRepository.deleteById(id);
    }
}
