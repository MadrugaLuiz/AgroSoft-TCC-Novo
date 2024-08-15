package com.TCC.AgroSoft.service;


import com.TCC.AgroSoft.model.Orcamento;
import com.TCC.AgroSoft.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    public List<Orcamento> buscarTodos() {
        return orcamentoRepository.findAll();
    }

    public Orcamento buscarPorId(int id) {
        return orcamentoRepository.findById(id).orElse(null);
    }

    public Orcamento salvar(Orcamento orcamento) {
        return orcamentoRepository.save(orcamento);
    }

    public void excluir(Orcamento orcamento) {
        orcamentoRepository.delete(orcamento);
    }
}
