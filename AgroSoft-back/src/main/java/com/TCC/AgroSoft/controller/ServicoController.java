package com.TCC.AgroSoft.controller;


import com.TCC.AgroSoft.model.Servico;
import com.TCC.AgroSoft.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{servico}")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<Servico> buscarTodos() {
        return servicoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarPorId(@PathVariable int id) {
        Servico servicoEncontrado = servicoService.buscarPorId(id);
        if (servicoEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servicoEncontrado);
    }

    @PostMapping
    public ResponseEntity<Servico> adicionar(@RequestBody Servico servico) {
        return ResponseEntity.ok(servicoService.salvar(servico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> alterar(@RequestBody Servico servico, @PathVariable int id) {
        Servico servicoEncontrado = servicoService.buscarPorId(id);
        if (servicoEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servicoService.salvar(servico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Servico> excluir(@PathVariable int id) {
        Servico servicoEncontrado = servicoService.buscarPorId(id);
        if (servicoEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        servicoService.excluir(servicoEncontrado);
        return ResponseEntity.ok(servicoEncontrado);
    }
}
