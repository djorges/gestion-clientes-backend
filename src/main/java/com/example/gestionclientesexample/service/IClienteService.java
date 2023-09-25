package com.example.gestionclientesexample.service;

import com.example.gestionclientesexample.entity.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> listarClientes();
    Cliente guardarCliente(Cliente cliente);
    void borrarCliente(Long id);
    Cliente obtenerClientePorId(Long id);
    Cliente actualizarCliente(Long id, Cliente cliente);
}
