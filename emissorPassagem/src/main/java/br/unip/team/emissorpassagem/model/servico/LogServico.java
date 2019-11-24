package br.unip.team.emissorpassagem.model.servico;

import java.util.logging.Logger;

import br.unip.team.emissorpassagem.model.entidade.Cartao;
import br.unip.team.emissorpassagem.model.entidade.Itinerario;
import br.unip.team.emissorpassagem.model.persistencia.LogDAO;

public class LogServico {
	ItinerarioServico servicoItinerario = new ItinerarioServico();
	LogDAO logDAO;
	private static final Logger LOGGER = Logger.getLogger(LogServico.class.getName());
	
	public LogServico() {
		logDAO = new LogDAO();
	}

	public boolean adicionarLog(int idItinerario, Cartao cartao) {
		Itinerario itinerario = servicoItinerario.obterItinerarPorId(idItinerario);
		if (itinerario == null) {
			LOGGER.info("Nenhum itinerario encontrado");
			return false;
		}
		return logDAO.adicionar(itinerario, cartao);
	}

}
