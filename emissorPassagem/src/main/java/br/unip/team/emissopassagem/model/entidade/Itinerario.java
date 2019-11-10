package br.unip.team.emissopassagem.model.entidade;

public class Itinerario extends EntidadeBase{
	private Estacao embarque;
	private Estacao desembarque;
	private Horario hrEmbarque;
	private Horario hrDesembarque;
	private int qtdPassagem;
	
	public Estacao getEmbarque() {
		return embarque;
	}
	public void setEmbarque(Estacao embarque) {
		this.embarque = embarque;
	}
	public Estacao getDesembarque() {
		return desembarque;
	}
	public void setDesembarque(Estacao desembarque) {
		this.desembarque = desembarque;
	}
	public Horario getHrEmbarque() {
		return hrEmbarque;
	}
	public void setHrEmbarque(Horario hrEmbarque) {
		this.hrEmbarque = hrEmbarque;
	}
	public Horario getHrDesembarque() {
		return hrDesembarque;
	}
	public void setHrDesembarque(Horario hrDesembarque) {
		this.hrDesembarque = hrDesembarque;
	}
	public int getQtdPassagem() {
		return qtdPassagem;
	}
	public void setQtdPassagem(int qtdPassagem) {
		this.qtdPassagem = qtdPassagem;
	}
}
