package com.example.desafio_ibm.dto;

import java.util.List;

public class ClienteDTO {
    private Long id;
    private String nome;
    private int idade;
    private String email;
    private String numeroConta;
    private double saldo;
    private List<OperacaoDTO> operacoes;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<OperacaoDTO> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<OperacaoDTO> operacoes) {
        this.operacoes = operacoes;
    }
}
