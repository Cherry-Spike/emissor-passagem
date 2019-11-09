package br.unip.team.emissopassagem.view;

import java.util.List;

import br.unip.team.emissopassagem.model.entidade.Cidade;
import br.unip.team.emissopassagem.model.persistencia.CidadeDAO;

public class Apresentacao {

	public static void main(String[] args) throws ClassNotFoundException {
		CidadeDAO dao= new CidadeDAO();
		List<Cidade>testeCidade = dao.obterTodos();
		
	}

}
