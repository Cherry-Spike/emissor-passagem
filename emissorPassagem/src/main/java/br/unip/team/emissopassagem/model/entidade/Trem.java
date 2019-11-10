package br.unip.team.emissopassagem.model.entidade;

public class Trem {
	private int totalAssentos;
	private int assentoDisponivel;
	private Estacao pontoInicial;
	private Estacao pontoFinal;
	
	public int gettotalAssentos() {
		return totalAssentos;
	}
	public void settotalAssentos(int totalAssentos) {
		this.totalAssentos = totalAssentos;
	}
	public int getassentoDisponivel() {
		return assentoDisponivel;
	}
	public void setassentoDisponivel(int assentoDisponivel) {
		this.assentoDisponivel = assentoDisponivel;
	}
	public Estacao getPontoInicial() {
		return pontoInicial;
	}
	public void setPontoInicial(Estacao pontoInicial) {
		this.pontoInicial = pontoInicial;
	}
	public Estacao getPontoFinal() {
		return pontoFinal;
	}
	public void setPontoFinal(Estacao pontoFinal) {
		this.pontoFinal = pontoFinal;
	}
}
