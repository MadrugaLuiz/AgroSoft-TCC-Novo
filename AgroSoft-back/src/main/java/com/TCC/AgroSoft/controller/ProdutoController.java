package com.TCC.AgroSoft.controller;


import com.TCC.AgroSoft.model.Produto;
import com.TCC.AgroSoft.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{produto}")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    public List<Produto> buscarTodos() {
        return produtoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable int id) {
        Produto produtoEncontrado = produtoService.buscarPorId(id);
        if (produtoEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoEncontrado);
    }

    @PostMapping
    public ResponseEntity<Produto> adicionar(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.salvar(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> alterar(@RequestBody Produto produto, @PathVariable int id) {
        Produto produtoEncontrado = produtoService.buscarPorId(id);
        if (produtoEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoService.salvar(produto));
    }

    public ResponseEntity<Produto> excluir(@PathVariable int id) {
        Produto produtoEncontrado = produtoService.buscarPorId(id);
        if (produtoEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        produtoService.excluir(produtoEncontrado);
        return ResponseEntity.ok(produtoService.salvar(produtoEncontrado));
    }


}