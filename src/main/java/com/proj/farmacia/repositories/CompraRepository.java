package com.proj.farmacia.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.farmacia.entities.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer>{}
