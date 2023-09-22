package com.example.gestionclientesexample.repository;

import com.example.gestionclientesexample.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
