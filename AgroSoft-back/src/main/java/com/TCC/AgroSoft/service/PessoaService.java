package com.TCC.AgroSoft.service;


import com.TCC.AgroSoft.model.Orcamento;
import com.TCC.AgroSoft.model.Pessoa;
import com.TCC.AgroSoft.repository.OrcamentoRepository;
import com.TCC.AgroSoft.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;


    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPorId(int id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void excluir(Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
    }
}


