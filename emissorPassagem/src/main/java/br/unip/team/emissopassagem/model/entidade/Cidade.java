package br.unip.team.emissopassagem.model.entidade;

import java.util.List;

public class Cidade extends EntidadeBase {
	private String nome;
	private List<Horario> horarios = null;

	public Cidade(String nome) {
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(Horario horario) {
		this.horarios.add(horario);
	}
}
