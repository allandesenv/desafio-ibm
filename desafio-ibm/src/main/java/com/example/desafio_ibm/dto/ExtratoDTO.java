package com.example.desafio_ibm.dto;

import com.example.desafio_ibm.model.Operacao;
import java.util.List;

public class ExtratoDTO {
    private List<Operacao> operacoes;
    private double saldoTotal;

    public ExtratoDTO(List<Operacao> operacoes, double saldoTotal) {
        this.operacoes = operacoes;
        this.saldoTotal = saldoTotal;
    }

    // Getters e Setters
    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<Operacao> operacoes) {
        this.operacoes = operacoes;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }
}
