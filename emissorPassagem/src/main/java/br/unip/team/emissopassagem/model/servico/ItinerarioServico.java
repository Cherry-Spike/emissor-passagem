package br.unip.team.emissopassagem.model.servico;

import java.util.logging.Logger;

import br.unip.team.emissopassagem.model.entidade.Estacao;
import br.unip.team.emissopassagem.model.entidade.EstacaoPosicao;
import br.unip.team.emissopassagem.model.entidade.Itinerario;
import br.unip.team.emissopassagem.model.persistencia.EstacaoDAO;
import br.unip.team.emissopassagem.model.persistencia.ItinerarioDAO;

public class ItinerarioServico {
	private ItinerarioDAO itinerarioDAO = new ItinerarioDAO();
	private EstacaoDAO estacaoDAO = new EstacaoDAO();
	private static final Logger LOGGER = Logger.getLogger(ItinerarioServico.class.getName());
	private static final double PRECO_PASSAGEM = 1.50;

	public int adicionar(Itinerario obj) {
		Estacao estacaoEmbarque = estacaoDAO.obterPorId(obj.getEstacaoEmbarque().getId());
		Estacao estacaoDesembarque = estacaoDAO.obterPorId(obj.getEstacaoDesembarque().getId());
		
		if (estacaoEmbarque == null || estacaoDesembarque == null) {
			LOGGER.info("Estação de embarque não encontrada.");
			return 0;
		}
		
		if (!validaRelacionamento(obj.getEstacaoEmbarque().getId(), obj.getEmbarqueHorario().getId())) {
			LOGGER.info("Não foi encontrado horario para a estcação informada.");
			return 0;
		}
		
		int posicaoEstacaoEmb = EstacaoPosicao.obterPosicaoEstacao(estacaoEmbarque.getNome());
		int posicaoEstacaoDesem = EstacaoPosicao.obterPosicaoEstacao(estacaoDesembarque.getNome());
		
		if (posicaoEstacaoDesem == -1 || posicaoEstacaoEmb == -1) {
			LOGGER.info("Posição da estação não encontrada.");
			return 0;
		}
		
		int totalEstacoesPercorridas = EstacaoPosicao.calcularTotalEstacaoPercorrida(posicaoEstacaoEmb, posicaoEstacaoDesem); 
		double preco = calculaPreco(totalEstacoesPercorridas, obj.getQtdPassagem());
		
		obj.setPreco(preco);
		
		return itinerarioDAO.adicionar(obj);
	}

	public double calculaPreco(int totalEstacoesPercorridas, int qtdPassagem) {
		return (totalEstacoesPercorridas * PRECO_PASSAGEM) * qtdPassagem;
	}

	public boolean validaRelacionamento(int idEstacao, int idHorario) {
		return itinerarioDAO.validaRelacionamento(idEstacao, idHorario);
	}

	public boolean alterarItinerario(Itinerario obj) {
		return itinerarioDAO.alterarItinerario(obj);
	}
	
	public int obterHorarioPorId(String string) {
		int horario = itinerarioDAO.obterIdHorario(string);
		if(horario <= 0) {
			LOGGER.info("Horario não encontrado");
			return 0;
		}
		return itinerarioDAO.obterIdHorario(string);
	}

	public Itinerario obterItinerarPorId(int idItinerario) {
		return itinerarioDAO.obterPorId(idItinerario);
	}
	
	
	
}
