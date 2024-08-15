package com.TCC.AgroSoft.service;


import com.TCC.AgroSoft.model.ImgServico;
import com.TCC.AgroSoft.repository.ImgServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgServicoService {

    @Autowired
    private ImgServicoRepository imgServicoRepository;

    public List<ImgServico> buscarTodos() {
        return imgServicoRepository.findAll();
    }

    public ImgServico buscarPorId(int id) {
        return imgServicoRepository.findById(id).orElse(null);
    }

    public ImgServico salvar(ImgServico imgServico) {
        return imgServicoRepository.save(imgServico);
    }

    public void excluir(ImgServico imgServico) {
        imgServicoRepository.delete(imgServico);
    }
}
