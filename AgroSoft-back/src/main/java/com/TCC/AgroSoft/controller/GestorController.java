package com.TCC.AgroSoft.controller;


import com.TCC.AgroSoft.model.Gestor;
import com.TCC.AgroSoft.service.GestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestor")
public class GestorController {

    @Autowired
    private GestorService gestorService;

    @GetMapping
    public List<Gestor> buscarTodos() {
        return gestorService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gestor> buscarPorId(@PathVariable int id) {
        Gestor gestorEncontrado = gestorService.buscarPorId(id);
        if (gestorEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gestorEncontrado);
    }

    @PostMapping
    public ResponseEntity<Gestor> adicionar(@RequestBody Gestor gestor) {
        return ResponseEntity.ok(gestorService.salvar(gestor));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Gestor> alterar(@RequestBody Gestor gestor, @PathVariable int id) {
        Gestor gestorEncontrado = gestorService.buscarPorId(id);
        if (gestorEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gestorService.salvar(gestor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Gestor> excluir(@PathVariable int id) {
        Gestor gestorEncontrado = gestorService.buscarPorId(id);
        if (gestorEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        gestorService.excluir(gestorEncontrado);
        return ResponseEntity.ok(gestorEncontrado);
    }

}
