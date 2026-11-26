package com.inkmanager.repository;

import com.inkmanager.model.Cliente;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ClienteRepositoryMemoria implements ClienteRepository {
    private final Map<UUID, Cliente> clientes = new LinkedHashMap<>();

    @Override
    public void salvar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    @Override
    public Optional<Cliente> buscarPorId(UUID id) {
        return Optional.ofNullable(clientes.get(id));
    }

    @Override
    public Optional<Cliente> buscarPorTelefone(String telefone) {
        return clientes.values().stream()
                .filter(c -> c.getTelefone().equals(telefone))
                .findFirst();
    }

    @Override
    public List<Cliente> listarTodos() {
        return List.copyOf(clientes.values());
    }

    @Override
    public void remover(UUID id) {
        clientes.remove(id);
    }
}