package br.unip.team.emissopassagem.view.Telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaEmissao extends Tela {

	public TelaEmissao(JPanel basePane, JPanel backPane) {
		setBasePane(basePane);
		setBackPane(backPane);
		setNewPane(window(), basePane);
	}

	@Override
	public JPanel window() {
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(corDeFundo);
		
		ImageIcon imgLogo = new ImageIcon(getClass().getResource("Img\\logo-sntf.jpg"));		
		JLabel logoSNTF = new JLabel(imgLogo);
		logoSNTF.setBounds(0, 80, 263, 180);
		contentPane.add(logoSNTF);
		
		//Event Listener
		
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
