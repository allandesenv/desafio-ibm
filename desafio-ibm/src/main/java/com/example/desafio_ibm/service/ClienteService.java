package com.example.desafio_ibm.service;

import com.example.desafio_ibm.dto.ClienteDTO;
import com.example.desafio_ibm.dto.OperacaoDTO;
import com.example.desafio_ibm.model.Cliente;
import com.example.desafio_ibm.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<ClienteDTO> listarClientesDTO() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(cliente -> {
            ClienteDTO dto = new ClienteDTO();
            dto.setId(cliente.getId());
            dto.setNome(cliente.getNome());
            dto.setIdade(cliente.getIdade());
            dto.setEmail(cliente.getEmail());
            dto.setNumeroConta(cliente.getNumeroConta());
            dto.setSaldo(cliente.getSaldo());
            dto.setOperacoes(cliente.getOperacoes().stream().map(operacao -> {
                OperacaoDTO operacaoDTO = new OperacaoDTO();
                operacaoDTO.setId(operacao.getId());
                operacaoDTO.setValor(operacao.getValor());
                operacaoDTO.setTipo(operacao.getTipo());
                operacaoDTO.setDataHora(operacao.getDataHora());
                return operacaoDTO;
            }).collect(Collectors.toList()));
            return dto;
        }).collect(Collectors.toList());
    }

    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public double obterSaldo(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        return cliente.getSaldo();
    }
}
