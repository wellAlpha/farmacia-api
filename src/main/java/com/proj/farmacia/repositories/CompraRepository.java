package com.proj.farmacia.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.farmacia.entities.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer>{
    // List<Compra> findAllWithItens();
    List<Compra> findByClienteId(Integer clienteId);
}
