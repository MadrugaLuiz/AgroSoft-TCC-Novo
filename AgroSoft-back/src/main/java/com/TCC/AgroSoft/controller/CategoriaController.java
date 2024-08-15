package com.TCC.AgroSoft.controller;


import com.TCC.AgroSoft.model.Categoria;
import com.TCC.AgroSoft.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> buscarTodos() {

        return categoriaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable int id) {
        Categoria categoriaOptions = categoriaService.buscarPorId(id);
        if (categoriaOptions == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoriaOptions);
    }

    @PostMapping
    public ResponseEntity<Categoria> adicionar(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.salvar(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> alterar(@RequestBody Categoria categoria, @PathVariable int id) {

        Categoria categoriaOptions = categoriaService.buscarPorId(id);
        if (categoriaOptions == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoriaService.salvar(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> excluir(@PathVariable int id) {
        Categoria categoriaOptions = categoriaService.buscarPorId(id);
        if (categoriaOptions == null) {
            return ResponseEntity.notFound().build();
        }
        categoriaService.excluir(categoriaOptions);
        return ResponseEntity.ok(categoriaOptions);
    }

}
