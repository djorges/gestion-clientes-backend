package com.example.gestionclientesexample.service;

import com.example.gestionclientesexample.entity.Cliente;
import com.example.gestionclientesexample.exception.ClienteNotFoundException;
import com.example.gestionclientesexample.repository.IClienteRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{
    @Autowired
    private IClienteRepository repository;

    @Override
    public List<Cliente> listarClientes() {
        return repository.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void borrarCliente(Long id) {
        repository.findById(id)
                .orElseThrow(()->new ClienteNotFoundException("Cliente no encontrado"));
        repository.deleteById(id);
    }

    @Override
    public Cliente obtenerClientePorId(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new ClienteNotFoundException("Cliente no encontrado"));
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente cliente) {
        val entity = repository.findById(id)
                .orElseThrow(()->new ClienteNotFoundException("Cliente no encontrado"));

        entity.setNombre(cliente.getNombre());
        entity.setApellido(cliente.getApellido());
        entity.setEmail(cliente.getEmail());

        repository.save(entity);

        return entity;
    }
}
