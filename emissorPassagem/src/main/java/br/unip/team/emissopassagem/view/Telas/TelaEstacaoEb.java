package br.unip.team.emissopassagem.view.Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaEstacaoEb extends Tela {

	public TelaEstacaoEb(JPanel basePane, JPanel backPane) {
		setBasePane(basePane);
		setBackPane(backPane);
		setNewPane(window(), basePane);
	}

	@Override
	public JPanel window() {
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(corDeFundo);
		
		setLabel(contentPane, "Escolha a estação de embarque", 170, 100, 500, 30, 20);		
		setComboBox(contentPane, 170, 150, 300, 60);		
		
		//Event Listener
		
		setButtonProx(contentPane).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				TelaEstacaoDb telaEstacoes = new TelaEstacaoDb(basePane, backPane);
			}
		});
		
		setButtonCancel(contentPane).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				backPane.show();
			}
		});
		
		return contentPane;
		
	}

}
