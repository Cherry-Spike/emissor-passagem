package br.unip.team.emissopassagem.model.entidade;

public class Horario extends EntidadeBase {
	private String hora;
	private int IdHora;

	public Horario(String hora) {
		sethora(hora);
	}

	public String gethora() {
		return hora;
	}

	private void sethora(String hora) {
		this.hora = hora;
	}
	
	@SuppressWarnings("unused")
	private void setIdHora(int id) {
		IdHora = id;
	}
	
	@SuppressWarnings("unused")
	private int getIdHora() {
		return IdHora;
	}
}
