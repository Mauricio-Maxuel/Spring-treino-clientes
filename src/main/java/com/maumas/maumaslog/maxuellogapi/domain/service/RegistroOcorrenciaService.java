package com.maumas.maumaslog.maxuellogapi.domain.service;

import com.maumas.maumaslog.maxuellogapi.domain.model.Entrega;
import com.maumas.maumaslog.maxuellogapi.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaid, String descricao){
        Entrega entrega = buscaEntregaService.buscar(entregaid);

        return entrega.adicionarOcorrencia(descricao);
    }

}
