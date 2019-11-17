package br.unip.team.emissopassagem.model.entidade;

public class Passagem extends EntidadeBase{
	private int idItinerario;
	private long numero;
	
	public int getIdItinerario() {
		return idItinerario;
	}
	public void setIdItinerario(int idItinerario) {
		this.idItinerario = idItinerario;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
}
