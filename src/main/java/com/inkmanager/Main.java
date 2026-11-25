package com.inkmanager;

import com.inkmanager.exception.RegraDeNegocioException;
import com.inkmanager.model.Cliente;

public class Main {
    public static void main(String[] args) {
        try {
            Cliente c = new Cliente("Maria Silva", "(41) 99999-0000");
            System.out.println(c);

            new Cliente("", "123");
        } catch (RegraDeNegocioException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}