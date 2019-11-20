package br.unip.team.emissopassagem.model.entidade;

public class Passagem extends EntidadeBase{
	private Itinerario itinerario;
	private long numero;
	
	public Itinerario getItinerario() {
		return itinerario;
	}
	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
}
