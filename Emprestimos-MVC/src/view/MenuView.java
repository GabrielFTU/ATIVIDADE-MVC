package view;

import model.*;
import controller.ClienteController;

import java.util.Scanner;

public class MenuView {
	private ClienteController controller = new ClienteController();
	private Scanner sc = new Scanner(System.in);
	
	
	public void exibirMenu() {
		int opcao;
		do {
			System.out.println("\n--- SISTEMA DE EMPRÉSTIMOS ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Remover Cliente");
            System.out.println("4. Novo Empréstimo");
            System.out.println("5. Calcular Juros / Montante");
            System.out.println("6. Quitar Empréstimos");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt(); sc.nextLine();

            switch (opcao) {
            case 1 -> adicionarCliente();
            case 2 -> listarClientes();
            case 3 -> removerCliente();
            case 4 -> novoEmprestimo();
            case 5 -> calcularJuros();
            case 6 -> quitar();
        }
    } while (opcao != 0);
}

	private void adicionarCliente() {
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
	    controller.adicionarCliente(nome, cpf);
	    System.out.println("Cliente adicionado!");
	}
	
	private void listarClientes() {
	    for (Cliente c : controller.ListarCliente()) {
	        System.out.println(c);
	        for (Emprestimo e : c.getEmprestimos()) {
	            System.out.println("  > " + e);
	        }
	    }
	}
	
	private void removerCliente() {
	    System.out.print("CPF do cliente: ");
	    String cpf = sc.nextLine();
	    if (controller.removerClinte(cpf)) {
	        System.out.println("Cliente removido.");
	    } else {
	        System.out.println("Cliente não encontrado.");
	    }
	}
	
	private void novoEmprestimo() {
	    System.out.print("CPF: ");
	    String cpf = sc.nextLine();
	    System.out.print("Capital R$: ");
	    double capital = sc.nextDouble();
	    System.out.print("Taxa %: ");
	    double taxa = sc.nextDouble();
	    System.out.print("Tempo (anos): ");
	    int tempo = sc.nextInt(); sc.nextLine();
	
	    controller.adicionarEmprestimo(cpf, capital, taxa, tempo);
	    System.out.println("Empréstimo registrado.");
	}
	
	private void calcularJuros() {
	    System.out.print("CPF: ");
	    String cpf = sc.nextLine();
	    Cliente cliente = controller.buscarPorCpf(cpf);
	    if (cliente != null) {
	        for (Emprestimo e : cliente.getEmprestimos()) {
	            double juros = e.calcularJurosSimples();
	            double montante = e.calcularMontateComposto();
	            System.out.println(e);
	            System.out.printf("  Juros Simples: R$%.2f\n", juros);
	            System.out.printf("  Montante Composto: R$%.2f\n", montante);
	        }
	    } else {
	        System.out.println("Cliente não encontrado.");
	    }
	}
	
	private void quitar() {
	    System.out.print("CPF: ");
	    String cpf = sc.nextLine();
	    controller.quitarEmprestimos(cpf);
	    System.out.println("Empréstimos quitados.");
	}
}