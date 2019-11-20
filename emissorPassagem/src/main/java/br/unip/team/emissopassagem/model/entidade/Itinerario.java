package br.unip.team.emissopassagem.model.entidade;

public class Itinerario extends EntidadeBase{
	private Estacao estacaoEmbarque;
	private Horario embarqueHorario;
	private Estacao estacaoDesembarque;
	private int qtdPassagem;
	private double preco;
	
	public Itinerario() {
		estacaoEmbarque = new Estacao();
		embarqueHorario = new Horario();
		estacaoDesembarque = new Estacao();
	}

	public Estacao getEstacaoEmbarque() {
		return estacaoEmbarque;
	}

	public void setEstacaoEmbarque(Estacao estacaoEmbarque) {
		this.estacaoEmbarque = estacaoEmbarque;
	}

	public Horario getEmbarqueHorario() {
		return embarqueHorario;
	}

	public void setEmbarqueHorario(Horario embarqueHorario) {
		this.embarqueHorario = embarqueHorario;
	}

	public Estacao getEstacaoDesembarque() {
		return estacaoDesembarque;
	}

	public void setEstacaoDesembarque(Estacao estacaoDesembarque) {
		this.estacaoDesembarque = estacaoDesembarque;
	}

	public int getQtdPassagem() {
		return qtdPassagem;
	}

	public void setQtdPassagem(int qtdPassagem) {
		this.qtdPassagem = qtdPassagem;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
