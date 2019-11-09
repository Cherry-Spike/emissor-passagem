package br.unip.team.emissopassagem.model.entidade;

public class Trem {
	private int totalAssentos;
	private int assentoDisponivel;
	private Cidade pontoInicial;
	private Cidade pontoFinal;
	
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
	public Cidade getPontoInicial() {
		return pontoInicial;
	}
	public void setPontoInicial(Cidade pontoInicial) {
		this.pontoInicial = pontoInicial;
	}
	public Cidade getPontoFinal() {
		return pontoFinal;
	}
	public void setPontoFinal(Cidade pontoFinal) {
		this.pontoFinal = pontoFinal;
	}
}
