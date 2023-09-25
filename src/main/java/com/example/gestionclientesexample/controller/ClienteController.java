package com.example.gestionclientesexample.controller;

import com.example.gestionclientesexample.entity.Cliente;
import com.example.gestionclientesexample.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private IClienteService service;

    @GetMapping("/")
    public List<Cliente> listarClientes() {
        return service.listarClientes();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente guardarCliente(
        @RequestBody Cliente cliente
    ){
        return service.guardarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void borrarCliente(@PathVariable Long id) {
        service.borrarCliente(id);
    }

    @GetMapping("/{id}")
    public Cliente obtenerClientePorId(
        @PathVariable Long id
    ){
        return service.obtenerClientePorId(id);
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(
        @PathVariable Long id,
        @RequestBody Cliente cliente
    ){
        return service.actualizarCliente(id, cliente);
    }
}