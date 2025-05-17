package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
	private List<Cliente> clientes = new ArrayList<>();
	
	
	public void adicionarCliente(String nome, String cpf) {
		clientes.add(new Cliente(nome, cpf));
	}
	
	public List<Cliente> ListarCliente(){
		return clientes;
	}
	
	public Cliente buscarPorCpf(String cpf) {
		for(Cliente c : clientes) {
			if (c.getCPF().equals(cpf)) {
				return c;
			}
		}
		return null;
	}
	public boolean removerClinte(String cpf) {
		Cliente c = buscarPorCpf(cpf);
		return clientes.remove(c);
	}
	
	public void adicionarEmprestimo(String cpf, double capital, double taxa, int tempo) {
		Cliente c = buscarPorCpf(cpf);
		if (c != null) {
			c.adicionarEmprestimo(new Emprestimo(capital, taxa, tempo));
		}
	}
	public void quitarEmprestimos(String cpf) {
		Cliente c = buscarPorCpf(cpf);
		if (c != null) {
			for(Emprestimo e : c.getEmprestimos()) {
				e.Quitar();
			}
		}
	}
}
