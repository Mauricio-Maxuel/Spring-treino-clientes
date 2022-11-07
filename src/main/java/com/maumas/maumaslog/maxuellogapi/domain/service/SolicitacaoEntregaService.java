package com.maumas.maumaslog.maxuellogapi.domain.service;

import com.maumas.maumaslog.maxuellogapi.domain.exception.NegocioException;
import com.maumas.maumaslog.maxuellogapi.domain.model.Cliente;
import com.maumas.maumaslog.maxuellogapi.domain.model.Entrega;
import com.maumas.maumaslog.maxuellogapi.domain.model.StatusEntrega;
import com.maumas.maumaslog.maxuellogapi.domain.repository.ClienteRepository;
import com.maumas.maumaslog.maxuellogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private EntregaRepository entregaRepository;
    private CatalogoClienteService catalogoClienteService;
    @Transactional
    public Entrega solicitar(Entrega entrega) {

        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);
    }
}
