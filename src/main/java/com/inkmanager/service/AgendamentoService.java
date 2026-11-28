package com.inkmanager.service;

import com.inkmanager.exception.RegraDeNegocioException;
import com.inkmanager.model.Agendamento;
import com.inkmanager.repository.AgendamentoRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class AgendamentoService {
    private final AgendamentoRepository repository;
    private final ClienteService clienteService;

    public AgendamentoService(AgendamentoRepository repository, ClienteService clienteService) {
        this.repository = repository;
        this.clienteService = clienteService;
    }

    public Agendamento agendar(UUID clienteId, LocalDateTime inicio, int duracaoMinutos, String descricao) {
        clienteService.buscarPorId(clienteId); // erro se o cliente não existir

        Agendamento novo = new Agendamento(clienteId, inicio, duracaoMinutos, descricao);

        if (novo.getInicio().isBefore(LocalDateTime.now())) {
            throw new RegraDeNegocioException("Não é possível agendar no passado.");
        }

        boolean conflito = repository.listarTodos().stream().anyMatch(novo::conflitaCom);
        if (conflito) {
            throw new RegraDeNegocioException("Já existe um agendamento neste horário.");
        }

        repository.salvar(novo);
        return novo;
    }

    public List<Agendamento> listar() {
        return repository.listarTodos();
    }
}