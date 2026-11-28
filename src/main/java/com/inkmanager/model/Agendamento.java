package com.inkmanager.model;

import com.inkmanager.exception.RegraDeNegocioException;
import java.time.LocalDateTime;
import java.util.UUID;

public class Agendamento {
    private final UUID id;
    private final UUID clienteId;
    private final LocalDateTime inicio;
    private final int duracaoMinutos;
    private final String descricao;

    public Agendamento(UUID clienteId, LocalDateTime inicio, int duracaoMinutos, String descricao) {
        if (clienteId == null) {
            throw new RegraDeNegocioException("Cliente é obrigatório.");
        }
        if (inicio == null) {
            throw new RegraDeNegocioException("Data e hora são obrigatórias.");
        }
        if (duracaoMinutos <= 0) {
            throw new RegraDeNegocioException("A duração deve ser maior que zero.");
        }
        this.id = UUID.randomUUID();
        this.clienteId = clienteId;
        this.inicio = inicio;
        this.duracaoMinutos = duracaoMinutos;
        this.descricao = descricao == null ? "" : descricao.trim();
    }

    public UUID getId() { return id; }
    public UUID getClienteId() { return clienteId; }
    public LocalDateTime getInicio() { return inicio; }
    public int getDuracaoMinutos() { return duracaoMinutos; }
    public String getDescricao() { return descricao; }

    public LocalDateTime getFim() {
        return inicio.plusMinutes(duracaoMinutos);
    }

    public boolean conflitaCom(Agendamento outro) {
        return inicio.isBefore(outro.getFim()) && outro.getInicio().isBefore(getFim());
    }

    @Override
    public String toString() {
        return inicio + " (" + duracaoMinutos + " min) - " + descricao;
    }
}