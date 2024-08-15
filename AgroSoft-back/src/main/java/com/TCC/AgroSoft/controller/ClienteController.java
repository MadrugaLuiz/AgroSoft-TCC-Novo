package com.TCC.AgroSoft.controller;


import com.TCC.AgroSoft.model.Cliente;
import com.TCC.AgroSoft.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> buscarTodos() {
        return clienteService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable int id) {
        Cliente clienteId = clienteService.buscarPorId(id);
        if (clienteId == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteId); ///Verificar  pois não temos o atriubuto ID na classe, conforme diagrama
    }

    @PostMapping
    public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.salvar(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> alterar(@RequestBody Cliente cliente, @PathVariable int id) {
        Cliente clienteId = clienteService.buscarPorId(id);
        if (clienteId == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteService.salvar(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> excluir(@PathVariable int id) {
        Cliente clienteId = clienteService.buscarPorId(id);
        if (clienteId == null) {
            return ResponseEntity.notFound().build();
        }
        clienteService.excluir(clienteId);
        return ResponseEntity.ok(clienteId);
    }
}
