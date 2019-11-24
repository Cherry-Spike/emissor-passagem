package br.unip.team.emissopassagem.controller;

import br.unip.team.emissopassagem.model.entidade.PassagemValueObject;
import br.unip.team.emissopassagem.model.servico.PassagemServico;

public class PassagemController {
	private PassagemServico servico;
	
	public PassagemController() {
		servico = new PassagemServico();		
	}
	public int adicionarPassagem(int idItinerario) {
		return servico.adicionar(idItinerario);
	}
	public PassagemValueObject obterPassagemPorId(int idPassgem) {
		return servico.obterPorId(idPassgem);
	}

}
