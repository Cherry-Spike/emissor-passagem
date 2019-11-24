package br.unip.team.emissorpassagem.model.servico;

import java.util.logging.Logger;

import br.unip.team.emissorpassagem.model.entidade.PassagemValueObject;
import br.unip.team.emissorpassagem.model.persistencia.PassagemDAO;

public class PassagemServico {
	private PassagemDAO passagemDAO;
	private static final Logger LOGGER = Logger.getLogger(PassagemServico.class.getName());
	
	public PassagemServico() {
		 passagemDAO = new PassagemDAO();
	}
	
	public int adicionar(int idItinerario) {
		long numeroSequecial = (long) (Math.random() * 999999999999l);
		return passagemDAO.adicionar(idItinerario, numeroSequecial);
	}
	public PassagemValueObject obterPorId(int id) {
		PassagemValueObject passagem = passagemDAO.obterPorId(id);
		if (passagem == null) {
			LOGGER.info("Passagem não encontrada");
			return null;
		}
		return passagem;
	}
}
