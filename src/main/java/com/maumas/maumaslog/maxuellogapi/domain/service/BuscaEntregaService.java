package com.maumas.maumaslog.maxuellogapi.domain.service;

import com.maumas.maumaslog.maxuellogapi.domain.exception.EntidadeNaoEncontradaException;
import com.maumas.maumaslog.maxuellogapi.domain.exception.NegocioException;
import com.maumas.maumaslog.maxuellogapi.domain.model.Entrega;
import com.maumas.maumaslog.maxuellogapi.domain.repository.EntregaRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId){

        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }

}
