package br.unip.team.emissopassagem.model.servico;

import br.unip.team.emissopassagem.model.entidade.Itinerario;
import br.unip.team.emissopassagem.model.persistencia.ItinerarioDAO;

public class ItinerarioServico {
	private ItinerarioDAO itinerarioDAO = new ItinerarioDAO();
	
	public int adicionar(Itinerario obj) {
		return itinerarioDAO.adicionar(obj);
	}
	
	public boolean validaRelacionamento(int idEstacao, int idHorario) {
		return itinerarioDAO.validaRelacionamento(idEstacao, idHorario);
	}
	
	public boolean alterarItinerario(Itinerario obj) {
		return itinerarioDAO.alterarItinerario(obj);
	}
}
