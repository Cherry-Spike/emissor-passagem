package br.unip.team.emissopassagem.controller;

import br.unip.team.emissopassagem.model.entidade.Passagem;
import br.unip.team.emissopassagem.model.servico.PassagemServico;

public class PassagemController {
	PassagemServico servico = new PassagemServico();
	public int adicionarPassagem(int idItinerario) {
		return servico.adicionar(idItinerario);
	}
	public Passagem obterPassagemPorId(int idPassgem) {
		return servico.obterPorId(idPassgem);
	}

}
