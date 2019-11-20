package br.unip.team.emissopassagem.model.servico;

import br.unip.team.emissopassagem.model.entidade.PassagemValueObject;
import br.unip.team.emissopassagem.model.persistencia.PassagemDAO;

public class PassagemServico {
	private PassagemDAO passagemDAO = new PassagemDAO();
	
	public int adicionar(int idItinerario) {
		long numeroSequecial = (long) (Math.random() * 999999999999l);
		return passagemDAO.adicionar(idItinerario, numeroSequecial);
	}
	public PassagemValueObject obterPorId(int id) {
		return passagemDAO.obterPorId(id);
	}
}
