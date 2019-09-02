package br.com.ryoshino.service;

import br.com.ryoshino.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ryoshino.repository.ClienteRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public void salvarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void gerarCliente() {
        Random gerador = new Random();
        for (int i = 1; i == 1000; i++){
            Cliente cliente = new Cliente();
            cliente.setDataAtualizacao(LocalDate.now());
            cliente.setCpf(gerador.nextInt());
            cliente.setEmail("");
            cliente.setEndereco("");
            cliente.setNome("");
            cliente.setTelefone(gerador.nextInt());
            salvarCliente(cliente);
        }
    }
}
