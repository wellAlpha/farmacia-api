package com.proj.farmacia.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.farmacia.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
	List<Funcionario> findByAtivoTrue();
	Funcionario findByCpf(String cpf);
}
