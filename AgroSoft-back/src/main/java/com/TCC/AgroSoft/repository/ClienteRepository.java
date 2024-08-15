package com.TCC.AgroSoft.repository;

import com.TCC.AgroSoft.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
