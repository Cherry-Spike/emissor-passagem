package br.unip.team.emissopassagem.model.entidade;

public class Horario extends EntidadeBase {
	private String hora;

	public Horario() {

	}

	public Horario(String hora) {
		sethora(hora);
	}

	public String gethora() {
		return hora;
	}

	private void sethora(String hora) {
		this.hora = hora;
	}
}
