package br.unip.team.emissopassagem.model.servico;

import br.unip.team.emissopassagem.model.entidade.Trem;
import br.unip.team.emissopassagem.model.persistencia.TremDAO;

public class TremServico {
	private TremDAO tremDAO = new TremDAO();

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
