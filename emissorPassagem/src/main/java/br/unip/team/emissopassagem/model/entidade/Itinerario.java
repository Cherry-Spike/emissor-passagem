package br.unip.team.emissopassagem.model.entidade;

public class Itinerario extends EntidadeBase{
	private int idEstacaoEmbarque;
	private int idEmbarqueHorario;
	private int idEstacaoDesembarque;
	private int idDesembarqueHorario;
	private int qtdPassagem;
	
	public int getIdEstacaoEmbarque() {
		return idEstacaoEmbarque;
	}
	public void setIdEstacaoEmbarque(int idEstacaoEmbarque) {
		this.idEstacaoEmbarque = idEstacaoEmbarque;
	}
	public int getIdEmbarqueHorario() {
		return idEmbarqueHorario;
	}
	public void setIdEmbarqueHorario(int idEmbarqueHorario) {
		this.idEmbarqueHorario = idEmbarqueHorario;
	}
	public int getIdEstacaoDesembarque() {
		return idEstacaoDesembarque;
	}
	public void setIdEstacaoDesembarque(int idEstacaoDesembarque) {
		this.idEstacaoDesembarque = idEstacaoDesembarque;
	}
	public int getIdDesembarqueHorario() {
		return idDesembarqueHorario;
	}
	public void setIdDesembarqueHorario(int idDesembarqueHorario) {
		this.idDesembarqueHorario = idDesembarqueHorario;
	}
	public int getQtdPassagem() {
		return qtdPassagem;
	}
	public void setQtdPassagem(int qtdPassagem) {
		this.qtdPassagem = qtdPassagem;
	}

}
