package com.inkmanager;
import com.inkmanager.exception.RegraDeNegocioException;
import com.inkmanager.repository.ClienteRepositoryMemoria;
import com.inkmanager.service.ClienteService;

public class Main {
    public static void main(String[] args) {
        ClienteService service = new ClienteService(new ClienteRepositoryMemoria());

        service.cadastrar("Maria", "(41) 99999-1111");

        try {
            service.cadastrar("João", "41999991111"); // mesmo telefone, formato diferente
        } catch (RegraDeNegocioException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        service.listar().forEach(System.out::println);
    }
}