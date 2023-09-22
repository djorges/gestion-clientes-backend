package com.example.gestionclientesexample.controller;

import com.example.gestionclientesexample.entity.Cliente;
import com.example.gestionclientesexample.exception.ClienteNotFoundException;
import com.example.gestionclientesexample.repository.IClienteRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private IClienteRepository repository;

    @GetMapping("/")
    public List<Cliente> listarClientes() {
        return repository.findAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente guardarCliente(
        @RequestBody Cliente cliente
    ){
        return repository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void borrarCliente(@PathVariable Long id) {
        repository.findById(id)
                .orElseThrow(()->new ClienteNotFoundException("Cliente no encontrado"));
        repository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Cliente obtenerClientePorId(
        @PathVariable Long id
    ){
        return repository.findById(id)
                .orElseThrow(()->new ClienteNotFoundException("Cliente no encontrado"));
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(
        @PathVariable Long id,
        @RequestBody Cliente cliente
    ){
        val entity = repository.findById(id)
                .orElseThrow(()->new ClienteNotFoundException("Cliente no encontrado"));

        entity.setNombre(cliente.getNombre());
        entity.setApellido(cliente.getApellido());
        entity.setEmail(cliente.getEmail());

        return entity;
    }
}