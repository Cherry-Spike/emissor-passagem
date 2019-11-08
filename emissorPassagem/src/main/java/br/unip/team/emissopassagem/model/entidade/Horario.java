package br.unip.team.emissopassagem.model.entidade;

public class Horario extends EntidadeBase {
	private String hora;

	public Horario(String hora, int id) {
		super(id);
		sethora(hora);
	}

	public String gethora() {
		return hora;
	}

	private void sethora(String hora) {
		this.hora = hora;
	}
}
