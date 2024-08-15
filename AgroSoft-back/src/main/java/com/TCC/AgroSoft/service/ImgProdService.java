package com.TCC.AgroSoft.service;


import com.TCC.AgroSoft.model.ImgProd;
import com.TCC.AgroSoft.repository.ImgProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgProdService {

    @Autowired
    private ImgProdRepository imgProdRepository;

    public List<ImgProd> buscarTodos() {
        return imgProdRepository.findAll();
    }

    public ImgProd buscarPorId(int id) {
        return imgProdRepository.findById(id).orElse(null);
    }

    public ImgProd salvar(ImgProd imgProd) {
        return imgProdRepository.save(imgProd);
    }

    public void excluir(ImgProd imgProd) {
        imgProdRepository.delete(imgProd);
    }

}
