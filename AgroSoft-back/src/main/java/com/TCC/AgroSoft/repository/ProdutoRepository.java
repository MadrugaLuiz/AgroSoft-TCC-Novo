package com.TCC.AgroSoft.repository;

import com.TCC.AgroSoft.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
