package br.unip.team.emissorpassagem.model.servico;

import br.unip.team.emissorpassagem.model.entidade.Trem;
import br.unip.team.emissorpassagem.model.persistencia.TremDAO;

public class TremServico {
	private TremDAO tremDAO;
	public TremServico() {
		tremDAO = new TremDAO();
	}

	public boolean reservarAssento(int id) {
		return tremDAO.reservarAssento(id);
	}

	public Trem obterPorIdCidadeInicial(int id) {
		return tremDAO.obterPorIdCidadeInicial(id);
	}

	public boolean haAssentoDisponivel(int idEstacaoinicial) {
		Trem trem = tremDAO.obterPorIdCidadeInicial(idEstacaoinicial);
		return trem.getAssentoDisponivel() < 1;
	}
}
