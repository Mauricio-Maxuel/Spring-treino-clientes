package com.maumas.maumaslog.maxuellogapi.api.model.input;

import javax.validation.constraints.NotNull;

public class DestinatarioInput {

    @NotNull
    private String nome;

    @NotNull
    private String logradouro;

    @NotNull
    private String numero;

    @NotNull
    private String complemento;

    @NotNull
    private String bairro;

}
