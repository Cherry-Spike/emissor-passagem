package br.unip.team.emissopassagem.model.entidade;

public class Itinerario extends EntidadeBase{
	protected Itinerario(int id) {
		super(id);
	}
	private Cidade embarque;
	private Cidade desembarque;
	private Horario hrEmbarque;
	private Horario hrDesembarque;
	private int qtdPassagem;
	
	public Cidade getEmbarque() {
		return embarque;
	}
	public void setEmbarque(Cidade embarque) {
		this.embarque = embarque;
	}
	public Cidade getDesembarque() {
		return desembarque;
	}
	public void setDesembarque(Cidade desembarque) {
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
