package model;

public class Emprestimo {
	
	private double capital;
	private double taxa;
	private int tempo; // anos 
	private boolean quitado;
	
	
	public Emprestimo(double capital, double taxa, int tempo) {
		this.capital = capital;
		this.taxa = taxa;
		this.tempo = tempo;
		this.quitado = false;
	}
	
	public double calcularJurosSimples() {
		return capital * taxa * tempo;
	}
	public double calcularMontateComposto() {
		return capital * Math.pow(1 + taxa, tempo);
	}
	public void Quitar() {
		this.quitado = true;
	}
	public boolean isQuitado() {
		return quitado;
	}
	
	
	@Override
	public String toString() {
		return String.format("R$%.2f a %.2f%% por %d anos - %s", capital, taxa * 100, tempo, quitado ? "QJITADO" : "PENDENTE");
	}
	
}
