package br.unip.team.emissopassagem.model.entidade;

import java.util.ArrayList;
import java.util.List;

public class Cidade extends EntidadeBase {
	private String nome;
	private List<Horario> horarios = new ArrayList<>();

	public Cidade(String nome, int id) {
		super(id);
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

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
}
