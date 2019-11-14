package br.unip.team.emissopassagem.model.servico;

import java.util.List;

import br.unip.team.emissopassagem.model.entidade.Estacao;
import br.unip.team.emissopassagem.model.persistencia.EstacaoDAO;

public class EstacaoServico {
	private final EstacaoDAO estacaoDAO = new EstacaoDAO();
	
	public List<Estacao> obterTodas() {
		return estacaoDAO.obterTodas();
	}
	
	public Estacao obterEstacaoHorarios(int id) {
		return estacaoDAO.obterEstacaoHorarios(id);
	}
	
	public Estacao obterPorId(int id) {
		return estacaoDAO.obterPorId(id);
	}
}
