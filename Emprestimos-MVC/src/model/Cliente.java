package model;

import java.util.List;
import java.util.ArrayList;

public class Cliente {

	private String nome;
	private String cpf;
	private List<Emprestimo> emprestimos;
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.emprestimos = new ArrayList<>();
		
	}
	public String getNome() {
		return nome;
	}
	public String getCPF() {
		return cpf;
	}
	public List<Emprestimo> getEmprestimos(){
		return emprestimos;
	}
	
	public void adicionarEmprestimo(Emprestimo e) {
		emprestimos.add(e);
	}
	
	@Override
	public String toString() {
		return nome +" CPF" + cpf + "Emprestimos" + emprestimos.size();
	}
}
