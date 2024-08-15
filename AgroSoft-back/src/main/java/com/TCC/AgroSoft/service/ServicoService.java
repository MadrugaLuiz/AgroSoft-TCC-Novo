package com.TCC.AgroSoft.service;


import com.TCC.AgroSoft.model.Servico;
import com.TCC.AgroSoft.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;


    public List<Servico> buscarTodos() {
        return servicoRepository.findAll();
    }

    public Servico buscarPorId(int id) {
        return servicoRepository.findById(id).orElse(null);
    }

    public Servico salvar(Servico servico) {
        return servicoRepository.save(servico);
    }

    public void excluir(Servico servico) {
        servicoRepository.delete(servico);
    }

}
