package br.unip.team.emissorpassagem.model.entidade;

public class PassagemValueObject {
	private long numero;
	private String estacaoEmbarque;
	private String estacaoDesembarque;
	private String horarioEmbarque;
	
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public String getEstacaoEmbarque() {
		return estacaoEmbarque;
	}
	public void setEstacaoEmbarque(String estacaoEmbarque) {
		this.estacaoEmbarque = estacaoEmbarque;
	}
	public String getEstacaoDesembarque() {
		return estacaoDesembarque;
	}
	public void setEstacaoDesembarque(String estacaoDesembarque) {
		this.estacaoDesembarque = estacaoDesembarque;
	}
	public String getHorarioEmbarque() {
		return horarioEmbarque;
	}
	public void setHorarioEmbarque(String horarioEmbarque) {
		this.horarioEmbarque = horarioEmbarque;
	}
}
