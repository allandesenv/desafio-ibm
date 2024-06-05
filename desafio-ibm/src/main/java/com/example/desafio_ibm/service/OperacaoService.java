package com.example.desafio_ibm.service;

import com.example.desafio_ibm.enums.TipoOperacao;
import com.example.desafio_ibm.model.Cliente;
import com.example.desafio_ibm.model.Operacao;
import com.example.desafio_ibm.repository.ClienteRepository;
import com.example.desafio_ibm.repository.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

        clienteRepository.save(cliente);
        return operacaoRepository.save(operacao);
    }
}
