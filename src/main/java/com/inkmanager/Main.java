package com.inkmanager;
import com.inkmanager.exception.RegraDeNegocioException;
import com.inkmanager.model.Cliente;
import com.inkmanager.repository.AgendamentoRepositoryMemoria;
import com.inkmanager.repository.ClienteRepositoryMemoria;
import com.inkmanager.service.AgendamentoService;
import com.inkmanager.service.ClienteService;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ClienteService clientes = new ClienteService(new ClienteRepositoryMemoria());
        AgendamentoService agenda = new AgendamentoService(new AgendamentoRepositoryMemoria(), clientes);

        Cliente maria = clientes.cadastrar("Maria", "(41) 99999-1111");

        LocalDateTime amanha14h = LocalDateTime.now().plusDays(1)
                .withHour(14).withMinute(0).withSecond(0).withNano(0);

        agenda.agendar(maria.getId(), amanha14h, 60, "Tatuagem no braço");

        try {
            agenda.agendar(maria.getId(), amanha14h.plusMinutes(30), 60, "Conflita");
        } catch (RegraDeNegocioException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        agenda.agendar(maria.getId(), amanha14h.plusMinutes(60), 60, "Logo depois");

        agenda.listar().forEach(System.out::println);
    }
}