package com.maumas.maumaslog.maxuellogapi.api.controller;

import com.maumas.maumaslog.maxuellogapi.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("João");
        cliente1.setEmail("teste@.gmail.com");
        cliente1.setTelefone("11 945999-11111");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Maria");
        cliente2.setTelefone("11 945999-11111");
        cliente2.setEmail("maria@.gmail.com");

        return Arrays.asList(cliente1, cliente2);
    }
}
