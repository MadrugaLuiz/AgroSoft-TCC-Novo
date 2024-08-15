package com.TCC.AgroSoft.controller;


import com.TCC.AgroSoft.model.Pessoa;
import com.TCC.AgroSoft.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Retention;
import java.util.List;

@RestController
@RequestMapping("/{pessoa}")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> buscarTodos() {
        return pessoaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable int id) {
        Pessoa pessoaEncontrada = pessoaService.buscarPorId(id);
        if (pessoaEncontrada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pessoaEncontrada);
    }

    @PostMapping
    public ResponseEntity<Pessoa> adicionar(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(pessoaService.salvar(pessoa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> alterar(@RequestBody Pessoa pessoa, @PathVariable int id) {
        Pessoa pessoaEncontrada = pessoaService.buscarPorId(id);
        if (pessoaEncontrada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pessoaService.salvar(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> excluir(@PathVariable int id) {
        Pessoa pessoaEncontrada = pessoaService.buscarPorId(id);
        if (pessoaEncontrada == null) {
            return ResponseEntity.notFound().build();
        }
        pessoaService.excluir(pessoaEncontrada);
        return ResponseEntity.ok(pessoaService.salvar(pessoaEncontrada));
    }
}
