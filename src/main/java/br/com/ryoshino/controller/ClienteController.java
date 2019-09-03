package br.com.ryoshino.controller;

import br.com.ryoshino.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ryoshino.service.ClienteService;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/gerarCliente")
    public void gerarCliente(){
        clienteService.gerarCliente();
    }

    @GetMapping("/listarClientes")
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("/enviarParaOKafka")
    public void enviarParaOKafka(){
        clienteService.enviarParaOKafka();
    }
}
