package com.TCC.AgroSoft.service;


import com.TCC.AgroSoft.model.Gestor;
import com.TCC.AgroSoft.repository.GestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestorService {


    @Autowired
    private GestorRepository gestorRepository;

    public List<Gestor> buscarTodos() {
        return gestorRepository.findAll();
    }

    public Gestor buscarPorId(int id) {
        return gestorRepository.findById(id).orElse(null);
    }

    public Gestor salvar(Gestor gestor) {
        return gestorRepository.save(gestor);
    }

    public void excluir(Gestor gestor) {
        gestorRepository.delete(gestor);
    }
}
