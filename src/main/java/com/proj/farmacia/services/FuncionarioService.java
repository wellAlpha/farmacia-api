package com.proj.farmacia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proj.farmacia.entities.Funcionario;
import com.proj.farmacia.repositories.FuncionarioRepository;

public class FuncionarioService {
    @Autowired FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listAtivoTrue(){
        return funcionarioRepository.findByAtivoTrue();
    }
}
