package com.TCC.AgroSoft.repository;

import com.TCC.AgroSoft.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
