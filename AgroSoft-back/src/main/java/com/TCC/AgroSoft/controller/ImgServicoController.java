package com.TCC.AgroSoft.controller;


import com.TCC.AgroSoft.model.ImgServico;
import com.TCC.AgroSoft.service.ImgServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{imgServ}")
public class ImgServicoController {

    @Autowired
    private ImgServicoService imgServicoService;

    @GetMapping
    public List<ImgServico> buscarTodos() {
        return imgServicoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImgServico> buscarPorId(@PathVariable int id) {
        ImgServico imgServicoEncontrada = imgServicoService.buscarPorId(id);
        if (imgServicoEncontrada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(imgServicoEncontrada);
    }

    @PostMapping
    public ResponseEntity<ImgServico> adicionar(@RequestBody ImgServico imgServico) {
        return ResponseEntity.ok(imgServicoService.salvar(imgServico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImgServico> alterar(@RequestBody ImgServico imgServico, @PathVariable int id) {
        ImgServico imgServicoEncontrada = imgServicoService.buscarPorId(id);
        if (imgServicoEncontrada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(imgServicoService.salvar(imgServico));
    }

    public ResponseEntity<ImgServico> excluir(@PathVariable int id) {
        ImgServico imgServicoEncontrada = imgServicoService.buscarPorId(id);
        if (imgServicoEncontrada == null) {
            return ResponseEntity.notFound().build();
        }
        imgServicoService.excluir(imgServicoEncontrada);
        return ResponseEntity.ok(imgServicoEncontrada);
    }


}
