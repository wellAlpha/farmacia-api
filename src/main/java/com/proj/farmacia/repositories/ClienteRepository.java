package com.proj.farmacia.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.farmacia.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	List<Cliente> findByAtivoTrue();
	Cliente findByCpf(String cpf);
	List<Cliente> findByCpfContains(String cpf);
}
