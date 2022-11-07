package com.maumas.maumaslog.maxuellogapi.api.controller;

import com.maumas.maumaslog.maxuellogapi.api.assembler.OcorrenciaAssembler;
import com.maumas.maumaslog.maxuellogapi.api.model.OcorrenciaModel;
import com.maumas.maumaslog.maxuellogapi.api.model.input.OcorrenciaInput;
import com.maumas.maumaslog.maxuellogapi.domain.model.Entrega;
import com.maumas.maumaslog.maxuellogapi.domain.model.Ocorrencia;
import com.maumas.maumaslog.maxuellogapi.domain.service.BuscaEntregaService;
import com.maumas.maumaslog.maxuellogapi.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entrgaId}/ocorrencias")
public class OcorrenciaController {

    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaAssembler ocorrenciaAssembler;

    private BuscaEntregaService buscaEntregaService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
      Ocorrencia ocorrenciaregistrada = registroOcorrenciaService
                .registrar(entregaId, ocorrenciaInput.getDescricao());

      return ocorrenciaAssembler.toModel(ocorrenciaregistrada);
    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaAssembler.toColleciotionModel(entrega.getOcorrencias()) ;
    }

}
