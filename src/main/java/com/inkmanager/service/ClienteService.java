package com.inkmanager.service;

import com.inkmanager.exception.RegraDeNegocioException;
import com.inkmanager.model.Cliente;
import com.inkmanager.repository.ClienteRepository;
import java.util.List;
import java.util.UUID;

public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrar(String nome, String telefone) {
        Cliente cliente = new Cliente(nome, telefone); // valida e limpa o telefone

        if (repository.buscarPorTelefone(cliente.getTelefone()).isPresent()) {
            throw new RegraDeNegocioException("Já existe um cliente com este telefone.");
        }

        repository.salvar(cliente);
        return cliente;
    }

    public Cliente buscarPorId(UUID id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RegraDeNegocioException("Cliente não encontrado."));
    }

    public List<Cliente> listar() {
        return repository.listarTodos();
    }

    public void remover(UUID id) {
        buscarPorId(id); // lança erro se não existir
        repository.remover(id);
    }
}
