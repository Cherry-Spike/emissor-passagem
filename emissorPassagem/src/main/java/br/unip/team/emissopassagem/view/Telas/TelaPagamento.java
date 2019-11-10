package br.unip.team.emissopassagem.view.Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaPagamento extends Tela {

	public TelaPagamento(JPanel basePane, JPanel backPane) {
		setBasePane(basePane);
		setBackPane(backPane);
		setNewPane(window(), basePane);
	}

	@Override
	public JPanel window() {
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(corDeFundo);
		
		setLabel(contentPane, "Digite o numero do cartão:", 150, 40, 500, 30, 18);		
		setTextField(contentPane, 150, 90, 300, 50, 15);		
		setLabel(contentPane, "Digite o PIN:", 150, 185, 500, 30, 18);		
		setTextField(contentPane, 150, 230, 100, 50, 3);		
		
		//Event Listener
		
		setButtonProx(contentPane).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				
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
