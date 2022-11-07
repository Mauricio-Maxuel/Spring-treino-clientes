package com.maumas.maumaslog.maxuellogapi.domain.service;

import com.maumas.maumaslog.maxuellogapi.domain.exception.NegocioException;
import com.maumas.maumaslog.maxuellogapi.domain.model.Entrega;
import com.maumas.maumaslog.maxuellogapi.domain.model.StatusEntrega;
import com.maumas.maumaslog.maxuellogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private EntregaRepository entregaRepository;
    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public void finalizar(Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();

        entregaRepository.save(entrega);
    }

}
