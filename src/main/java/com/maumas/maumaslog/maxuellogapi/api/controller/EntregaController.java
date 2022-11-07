package com.maumas.maumaslog.maxuellogapi.api.controller;

import com.maumas.maumaslog.maxuellogapi.api.assembler.EntregaAssembler;
import com.maumas.maumaslog.maxuellogapi.api.model.DestinatarioModel;
import com.maumas.maumaslog.maxuellogapi.api.model.EntregaModel;
import com.maumas.maumaslog.maxuellogapi.api.model.input.EntregaInput;
import com.maumas.maumaslog.maxuellogapi.domain.model.Entrega;
import com.maumas.maumaslog.maxuellogapi.domain.repository.EntregaRepository;
import com.maumas.maumaslog.maxuellogapi.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaRepository entregaRepository;
    private ModelMapper modelMapper;
    private EntregaAssembler entregaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput) {

        Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);

        return entregaAssembler.toModel(entregaSolicitada);
    }

    @GetMapping
    public List<EntregaModel> listar() {
        return entregaAssembler.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {

        return entregaRepository.findById(entregaId)
                    .map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
                    .orElse(ResponseEntity.notFound().build());

//                    EntregaModel entregaModel = new EntregaModel();
//                    entregaModel.setId(entrega.getId());
//                    entregaModel.setNomeCliente(entrega.getCliente().getNome());
//                    entregaModel.setDestinatario(new DestinatarioModel());
//                    entregaModel.getDestinatario().setNome(entrega.getDestinatario().getNome());
//                    entregaModel.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
//                    entregaModel.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
//                    entregaModel.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
//                    entregaModel.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
//                    entregaModel.setTaxa(entrega.getTaxa());
//                    entregaModel.setStatus(entrega.getStatus());
//                    entregaModel.setDataPedido(entrega.getDataPedido());
//                    entregaModel.setDataFinalizado(entrega.getDataFinalizacao());


                }
    }
