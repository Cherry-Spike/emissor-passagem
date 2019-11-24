package br.unip.team.emissorpassagem.controller;

import br.unip.team.emissorpassagem.model.entidade.Itinerario;
import br.unip.team.emissorpassagem.model.servico.ItinerarioServico;

public class ItinerarioController {
	private ItinerarioServico servico;

	public ItinerarioController() {
		servico = new ItinerarioServico();
	}

	public int adicionarItinerario(Itinerario obj) {
		return servico.adicionar(obj);
	}

	public int obterIdHorario(String string) {
		return servico.obterHorarioPorId(string);
	}

	public Itinerario obterPorId(int id) {
		return servico.obterItinerarPorId(id);
	}
}
