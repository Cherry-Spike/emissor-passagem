package br.unip.team.emissopassagem.view.Telas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
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
		JTextField txt = setTextField(contentPane, 150, 90, 300, 50, 15);		
		setLabel(contentPane, "Digite o PIN:", 150, 185, 500, 30, 18);		
		JTextField txt2 = setTextField(contentPane, 150, 230, 100, 50, 3);
		JButton prox = setButtonProx(contentPane);
		JButton cancel = setButtonCancel(contentPane);
		
		//Event Listener
		
		prox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				TelaEmissao telaEmissao = new TelaEmissao(basePane, backPane);
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				backPane.show();
			}
		});
		
		return contentPane;
		
	}

}
