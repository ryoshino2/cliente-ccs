package br.com.ryoshino.service;

import br.com.ryoshino.entity.Cliente;
import br.com.ryoshino.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
@EnableScheduling
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    //288 clientes por dia
    private final long GERAR_CLIENTES = (5000 * 60);

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public void salvarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Scheduled(fixedDelay = GERAR_CLIENTES)
    public void gerarCliente() {
        Random gerador = new Random();

            Cliente cliente = new Cliente();
            cliente.setDataAtualizacao(LocalDate.now());
            cliente.setCpf(gerador.nextInt(10000) + 1);
            cliente.setEmail("a@.com" + gerador.nextInt(100));
            cliente.setEndereco("endereco: " + gerador.nextInt(100));
            cliente.setNome("nome: " + gerador.nextInt(100));
            cliente.setTelefone(gerador.nextInt(10000) + 1);
            salvarCliente(cliente);
    }
}
