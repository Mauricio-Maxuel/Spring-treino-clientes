package com.maumas.maumaslog.maxuellogapi.api.controller;

import com.maumas.maumaslog.maxuellogapi.domain.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private EntityManager entityManager;


    @GetMapping("/clientes")
    public List<Cliente> listar() {
        return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
    }

    
}
