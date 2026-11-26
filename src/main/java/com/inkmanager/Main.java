package com.inkmanager;

import com.inkmanager.model.Cliente;
import com.inkmanager.repository.ClienteRepository;
import com.inkmanager.repository.ClienteRepositoryMemoria;

public class Main {
    public static void main(String[] args) {
        ClienteRepository repo = new ClienteRepositoryMemoria();

        repo.salvar(new Cliente("Maria Silva", "(41) 99999-0000"));
        repo.salvar(new Cliente("João Souza", "(41) 98888-1111"));

        System.out.println("Todos os clientes:");
        repo.listarTodos().forEach(System.out::println);

        System.out.println("\nBusca por telefone 41988881111:");
        repo.buscarPorTelefone("41988881111")
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Não encontrado"));

        System.out.println("\nBusca por telefone 41000000000:");
        repo.buscarPorTelefone("41000000000")
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Não encontrado"));
    }
}