package br.unip.team.emissopassagem.model.entidade;

public class Itinerario extends EntidadeBase{
	private int idEstacaoEmbarque;
	private int idEmbarqueHorario;
	private int idEstacaoDesembarque;
	private int qtdPassagem;
	private double preco;
	
	public int getIdEstacaoEmbarque() {
		return idEstacaoEmbarque;
	}
	public void setIdEstacaoEmbarque(int idEstacaoEmbarque) {
		this.idEstacaoEmbarque = idEstacaoEmbarque;
	}
	public int getIdEmbarqueHorario() {
		return idEmbarqueHorario;
	}
	public void setEmbarqueHorario(int idEmbarqueHorario) {
		this.idEmbarqueHorario = idEmbarqueHorario;
	}
	public int getIdEstacaoDesembarque() {
		return idEstacaoDesembarque;
	}
	public void setIdEstacaoDesembarque(int idEstacaoDesembarque) {
		this.idEstacaoDesembarque = idEstacaoDesembarque;
	}
	public int getQtdPassagem() {
		return qtdPassagem;
	}
	public void setQtdPassagem(int qtdPassagem) {
		this.qtdPassagem = qtdPassagem;
	}
	public void setPrecoPassagem(double preco) {
		this.preco = preco;
	}

	public double getPrecoPassagem() {
		return preco;
	}
}
