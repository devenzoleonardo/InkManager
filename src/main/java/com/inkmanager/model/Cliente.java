package com.inkmanager.model;

import com.inkmanager.exception.RegraDeNegocioException;

import java.util.UUID;

public class Cliente {
    private final UUID id;
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone) {
        this.id = UUID.randomUUID();
        this.nome = validarNome(nome);
        this.telefone = validarTelefone(telefone);
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = validarNome(nome);
    }

    public void setTelefone(String telefone) {
        this.telefone = validarTelefone(telefone);
    }

    private static String validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new RegraDeNegocioException("Nome é obrigatório.");
        }
        return nome.trim();
    }

    private static String validarTelefone(String telefone) {
        String digitos = telefone == null ? "" : telefone.replaceAll("\\D", "");
        if (digitos.length() < 10 || digitos.length() > 11) {
            throw new RegraDeNegocioException("Telefone inválido. Use DDD + número.");
        }
        return digitos;
    }

    @Override
    public String toString() {
        return nome + " - " + telefone;
    }
}