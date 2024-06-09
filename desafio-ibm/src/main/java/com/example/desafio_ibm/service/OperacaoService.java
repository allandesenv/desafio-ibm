package com.example.desafio_ibm.service;

import com.example.desafio_ibm.dto.ExtratoDTO;
import com.example.desafio_ibm.enums.TipoOperacao;
import com.example.desafio_ibm.model.Cliente;
import com.example.desafio_ibm.model.Operacao;
import com.example.desafio_ibm.repository.ClienteRepository;
import com.example.desafio_ibm.repository.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OperacaoService {

    @Autowired
    private OperacaoRepository operacaoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Operacao criarOperacao(Long clienteId, double valor, TipoOperacao tipo) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        Operacao operacao = new Operacao();
        operacao.setCliente(cliente);
        operacao.setValor(valor);
        operacao.setTipo(tipo);
        operacao.setDataHora(LocalDateTime.now());

        if (tipo == TipoOperacao.DEBITO) {
            if (cliente.getSaldo() < valor) {
                throw new IllegalArgumentException("Saldo insuficiente");
            }
            cliente.setSaldo(cliente.getSaldo() - valor);
        } else if (tipo == TipoOperacao.CREDITO) {
            cliente.setSaldo(cliente.getSaldo() + valor);
        }

        //Remover
        //cliente.getOperacoes().add(operacao); // Adiciona a operação na lista de operações do cliente

        clienteRepository.save(cliente);
        return operacaoRepository.save(operacao);
    }

    public ExtratoDTO obterExtrato(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        List<Operacao> operacoes = cliente.getOperacoes();
        double saldoTotal = cliente.getSaldo();

        return new ExtratoDTO(operacoes, saldoTotal);
    }
}
