package com.TCC.AgroSoft.controller;


import com.TCC.AgroSoft.model.ImgProd;
import com.TCC.AgroSoft.model.ImgServico;
import com.TCC.AgroSoft.service.ImgProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{imgProd}")
public class ImgProdController {


    @Autowired
    private ImgProdService imgProdService;

    @GetMapping
    public List<ImgProd> buscarTodos() {
        return imgProdService.buscarTodos();

    }

    @GetMapping("/{id}")
    public ResponseEntity<ImgProd> buscarPorId(@PathVariable int id) {
        ImgProd imgProdEncontrada = imgProdService.buscarPorId(id);
        if (imgProdEncontrada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(imgProdEncontrada);
    }

    @PostMapping
    public ResponseEntity<ImgProd> adicionar(@RequestBody ImgProd imgProd, @PathVariable int id) {
        return ResponseEntity.ok(imgProdService.salvar(imgProd));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImgProd> alterar(@RequestBody ImgProd imgProd, @PathVariable int id) {
        ImgProd imgProdEncontrada = imgProdService.buscarPorId(id);
        if (imgProdEncontrada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(imgProdService.salvar(imgProd));
    }

    public ResponseEntity<ImgProd> excluir(@PathVariable int id) {
        ImgProd imgProdEncontrada = imgProdService.buscarPorId(id);
        if (imgProdEncontrada == null) {
            return ResponseEntity.notFound().build();
        }
        imgProdService.excluir(imgProdEncontrada);
        return ResponseEntity.ok(imgProdEncontrada);
    }


}
