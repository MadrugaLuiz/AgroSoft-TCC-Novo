package com.TCC.AgroSoft.controller;


import com.TCC.AgroSoft.model.Vendedor;
import com.TCC.AgroSoft.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{vendedor}")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public List<Vendedor> buscarTodos() {
        return vendedorService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> buscarPorId(@PathVariable int id) {
        Vendedor vendedorEncontrado = vendedorService.buscarPorId(id);
        if (vendedorEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vendedorEncontrado);
    }

    @PostMapping
    public ResponseEntity<Vendedor> adicionar(@RequestBody Vendedor vendedor) {
        return ResponseEntity.ok(vendedorService.salvar(vendedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> alterar(@RequestBody Vendedor vendedor, @PathVariable int id) {
        Vendedor vendedorEncontrado = vendedorService.buscarPorId(id);
        if (vendedorEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vendedorService.salvar(vendedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vendedor> excluir(@PathVariable int id) {
        Vendedor vendedorEncontrado = vendedorService.buscarPorId(id);
        if (vendedorEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        vendedorService.excluir(vendedorEncontrado);
        return ResponseEntity.ok(vendedorEncontrado);
    }
}
