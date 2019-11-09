package br.unip.team.emissopassagem.view.Telas;

import java.awt.Color;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import br.unip.team.emissopassagem.model.entidade.Cidade;
import br.unip.team.emissopassagem.model.persistencia.CidadeDAO;

public class TelaEstacoes extends Tela {

	public TelaEstacoes(JPanel basePane, JPanel backPane) {
		setBasePane(basePane);
		setNewPane(window(), basePane);
	}

	@Override
	public JPanel window() {
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(36, 63, 111));
		
		JComboBox<Object> cbCidade = new JComboBox<Object>();
		cbCidade.setBounds(200, 200, 100, 40);
		CidadeDAO dao = new CidadeDAO();
		List<Cidade> c = dao.obterTodos();
		cbCidade.addItem(c);
		contentPane.add(cbCidade);
		
		return contentPane;
		
	}

}
