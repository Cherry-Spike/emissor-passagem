package br.unip.team.emissopassagem.model.entidade;

public class Trem {
	private int qtdlugar;
	private int lugaresDisponiveis;
	private Cidade pontoInicial;
	private Cidade pontoFinal;
	
	public int getQtdlugar() {
		return qtdlugar;
	}
	public void setQtdlugar(int qtdlugar) {
		this.qtdlugar = qtdlugar;
	}
	public int getLugaresDisponiveis() {
		return lugaresDisponiveis;
	}
	public void setLugaresDisponiveis(int lugaresDisponiveis) {
		this.lugaresDisponiveis = lugaresDisponiveis;
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
