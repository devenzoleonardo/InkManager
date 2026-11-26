package com.inkmanager.repository;

import com.inkmanager.model.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {
    void salvar(Cliente cliente);

    Optional<Cliente> buscarPorId(UUID id);

    Optional<Cliente> buscarPorTelefone(String telefone);

    List<Cliente> listarTodos();

    void remover(UUID id);
}
