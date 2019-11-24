package br.unip.team.emissopassagem.model.servico;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import br.unip.team.emissopassagem.model.entidade.Estacao;
import br.unip.team.emissopassagem.model.entidade.EstacaoPosicao;
import br.unip.team.emissopassagem.model.entidade.Horario;
import br.unip.team.emissopassagem.model.persistencia.EstacaoDAO;

public class EstacaoServico {
	private EstacaoDAO estacaoDAO;
	private static final Logger LOGGER = Logger.getLogger(EstacaoServico.class.getName());
	
	public EstacaoServico() {
		estacaoDAO = new EstacaoDAO();
	}
	public List<Estacao> obterTodas() {
		return estacaoDAO.obterTodas();
	}
	
	public List<Horario> obterEstacaoHorarios(int idEstacaoEmbarque, int idEstacaoDesembarque) {
		Estacao estacaoEmbarque = obterPorId(idEstacaoEmbarque);
		Estacao estacaoDesembarque = obterPorId(idEstacaoDesembarque);

		if(estacaoEmbarque == null || estacaoDesembarque == null) {
			LOGGER.info("Estação não encontrada");
			return Collections.emptyList();
		}
		int embPos = EstacaoPosicao.obterPosicaoEstacao(estacaoEmbarque.getNome());
		int desemPos = EstacaoPosicao.obterPosicaoEstacao(estacaoDesembarque.getNome());
		
		int sentido = EstacaoPosicao.calcularSentido(embPos, desemPos);
		List<Horario> horarios = estacaoDAO.obterEstacaoHorarios(estacaoEmbarque.getId(), sentido);
		
		if(horarios == null) {
			LOGGER.info("Nenhum horario encontrado");
			return Collections.emptyList();
		}
		
		return horarios;
	}
	
	public Estacao obterPorId(int id) {
		Estacao estacao = estacaoDAO.obterPorId(id);
		if(estacao == null) {
			LOGGER.info("Estação não encontrada");
			return null;
		}
		return estacao;
	}
}
