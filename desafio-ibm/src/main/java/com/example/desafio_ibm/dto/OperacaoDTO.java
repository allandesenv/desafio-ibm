package com.example.desafio_ibm.dto;

import com.example.desafio_ibm.enums.TipoOperacao;

import java.time.LocalDateTime;

public class OperacaoDTO {
    private Long id;
    private double valor;
    private TipoOperacao tipo;
    private LocalDateTime dataHora;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoOperacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoOperacao tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}

