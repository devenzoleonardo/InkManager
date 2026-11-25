import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== InkManager ===");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Telefone: ");
                String telefone = sc.nextLine();
                clientes.add(new Cliente(nome, telefone));
                System.out.println("Cliente cadastrado!");
            } else if (opcao == 2) {
                if (clientes.isEmpty()) {
                    System.out.println("Nenhum cliente cadastrado.");
                } else {
                    for (Cliente c : clientes) {
                        System.out.println(c);
                    }
                }
            }
        } while (opcao != 0);

        System.out.println("Até mais!");
    }
}