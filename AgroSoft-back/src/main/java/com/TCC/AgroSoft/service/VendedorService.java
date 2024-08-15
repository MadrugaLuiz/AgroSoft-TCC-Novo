package com.TCC.AgroSoft.service;


import com.TCC.AgroSoft.model.Vendedor;
import com.TCC.AgroSoft.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {
    @Autowired
    private VendedorRepository vendedorRepository;

    public List<Vendedor> buscarTodos() {
        return vendedorRepository.findAll();
    }

    public Vendedor buscarPorId(int id) {
        return vendedorRepository.findById(id).orElse(null);
    }

    public Vendedor salvar(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public void excluir(Vendedor vendedor) {
        vendedorRepository.delete(vendedor);
    }
}
