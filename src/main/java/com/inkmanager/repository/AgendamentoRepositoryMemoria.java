package com.inkmanager.repository;

import com.inkmanager.model.Agendamento;
import java.util.*;

public class AgendamentoRepositoryMemoria implements AgendamentoRepository {
    private final Map<UUID, Agendamento> agendamentos = new LinkedHashMap<>();

    @Override
    public void salvar(Agendamento agendamento) { agendamentos.put(agendamento.getId(), agendamento); }

    @Override
    public Optional<Agendamento> buscarPorId(UUID id) { return Optional.ofNullable(agendamentos.get(id)); }

    @Override
    public List<Agendamento> listarTodos() { return List.copyOf(agendamentos.values()); }

    @Override
    public void remover(UUID id) { agendamentos.remove(id); }
}