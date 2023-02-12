package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .orElseThrow();
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id)
        		.orElseThrow();        
        cliente.setNome(clienteDetails.getNome());
        cliente.setCpf(clienteDetails.getCpf());
        cliente.setTelefone(clienteDetails.getTelefone());
        cliente.setEndereco(clienteDetails.getEndereco());
        cliente.setEmail(clienteDetails.getEmail());
        cliente.setSenha(clienteDetails.getSenha());
        Cliente updatedCliente = clienteRepository.save(cliente);
        return updatedCliente;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id)
        		.orElseThrow();
        clienteRepository.delete(cliente);
    }
}