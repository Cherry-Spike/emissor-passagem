package br.unip.team.emissopassagem.view.Telas;

import java.awt.Color;

import javax.swing.JPanel;

public class TelaEstacoes extends Tela {

	public TelaEstacoes(JPanel basePane, JPanel backPane) {
		setBasePane(basePane);
		setNewPane(window(), basePane);
	}

	@Override
	public JPanel window() {
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(36, 63, 111));
		
		
		
		return contentPane;
		
	}

}
