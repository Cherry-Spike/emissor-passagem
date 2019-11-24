package br.unip.team.emissorpassagem.model.entidade;

import java.util.ArrayList;
import java.util.List;

public class Estacao extends EntidadeBase {
	private String nome;
	private List<Horario> horarios = new ArrayList<>();

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
	
	@Override
	public String toString() {
		return getNome();
	}
	
}
