package com.example.desafio_ibm.controller;

import com.example.desafio_ibm.dto.ExtratoDTO;
import com.example.desafio_ibm.enums.TipoOperacao;
import com.example.desafio_ibm.model.Operacao;
import com.example.desafio_ibm.service.OperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operacoes")
public class OperacaoController {

    @Autowired
    private OperacaoService operacaoService;

    @PostMapping("/debito")
    public Operacao criarDebito(@RequestParam Long clienteId, @RequestParam double valor) {
        return operacaoService.criarOperacao(clienteId, valor, TipoOperacao.DEBITO);
    }

    @PostMapping("/credito")
    public Operacao criarCredito(@RequestParam Long clienteId, @RequestParam double valor) {
        return operacaoService.criarOperacao(clienteId, valor, TipoOperacao.CREDITO);
    }

    @GetMapping("/{clienteId}/extrato")
    public ExtratoDTO obterExtrato(@PathVariable Long clienteId) {
        return operacaoService.obterExtrato(clienteId);
    }
}