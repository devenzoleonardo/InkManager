package com.inkmanager.repository;

import com.inkmanager.model.Agendamento;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AgendamentoRepository {
    void salvar(Agendamento agendamento);
    Optional<Agendamento> buscarPorId(UUID id);
    List<Agendamento> listarTodos();
    void remover(UUID id);
}