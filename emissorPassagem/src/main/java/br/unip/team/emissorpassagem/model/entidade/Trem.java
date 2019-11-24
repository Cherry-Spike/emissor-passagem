package br.unip.team.emissorpassagem.model.entidade;

public class Trem {
	private int totalAssento;
	private int assentoDisponivel;
	private int idEstacaoInicial;
	private int idEstacaoFinal;
	
	public int getTotalAssento() {
		return totalAssento;
	}
	public void setTotalAssento(int totalAssentos) {
		this.totalAssento = totalAssentos;
	}
	public int getAssentoDisponivel() {
		return assentoDisponivel;
	}
	public void setAssentoDisponivel(int assentoDisponivel) {
		this.assentoDisponivel = assentoDisponivel;
	}
	public int getIdEstacaoInicial() {
		return idEstacaoInicial;
	}
	public void setIdEstacaoInicial(int idEstacaoInicial) {
		this.idEstacaoInicial = idEstacaoInicial;
	}
	public int getIdEstacaoFinal() {
		return idEstacaoFinal;
	}
	public void setIdEstacaoFinal(int idEstacaoFinal) {
		this.idEstacaoFinal = idEstacaoFinal;
	}
}
