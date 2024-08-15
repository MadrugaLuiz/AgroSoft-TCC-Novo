package com.TCC.AgroSoft.controller;
//aqui segue outro padrão por ser a classe principal


import com.TCC.AgroSoft.model.Orcamento;
import com.TCC.AgroSoft.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{orcamento}")
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService;

    @GetMapping
    public List<Orcamento> buscarTodos() {
        return orcamentoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orcamento> buscarPorId(@PathVariable int id) {
        Orcamento orcamentoEncontrado = orcamentoService.buscarPorId(id);
        if (orcamentoEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orcamentoEncontrado);
    }

    @PostMapping
    public ResponseEntity<Orcamento> adicionar(@RequestBody Orcamento orcamento) {
        return ResponseEntity.ok(orcamentoService.salvar(orcamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orcamento> alterar(@RequestBody Orcamento orcamento, @PathVariable int id) {
        Orcamento orcamentoEncontrado = orcamentoService.buscarPorId(id);
        if (orcamentoEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orcamentoService.salvar(orcamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Orcamento> excluir(@PathVariable int id) {
        Orcamento orcamentoEncontrado = orcamentoService.buscarPorId(id);
        if (orcamentoEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        orcamentoService.excluir(orcamentoEncontrado);
        return ResponseEntity.ok(orcamentoEncontrado);

    }
}
