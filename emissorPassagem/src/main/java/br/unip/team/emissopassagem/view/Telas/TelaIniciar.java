package br.unip.team.emissopassagem.view.Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaIniciar extends Tela{
	
	public TelaIniciar(JPanel basePane) {
		setBasePane(basePane);
		setNewPane(window(), basePane);
	}
	
	public JPanel window() {
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(corDeFundo);
		
		JButton btnIniciar = new JButton("INICIAR");
		btnIniciar.setBounds(230, 335, 180, 60);
		btnIniciar.setFont(new Font("Arial", Font.BOLD, 25));
		btnIniciar.setBackground(new Color(0, 153, 255));
		btnIniciar.setForeground(Color.white);
		btnIniciar.setOpaque(true);
		btnIniciar.setBorderPainted(false);
		btnIniciar.setFocusPainted(false);
		contentPane.add(btnIniciar);
		
		setLabel(contentPane, "Bem Vindo", 165, 70, 350, 60, 60);
		setLabel(contentPane, "Precione o botão Iniciar para comprar sua passagem", 75, 165, 500, 30, 20);
		
		ImageIcon img = new ImageIcon(getClass().getResource("Img\\Train.png"));		
		JLabel imgTrem = new JLabel(img);
		imgTrem.setBounds(0, 0, 640, 280);
		contentPane.add(imgTrem);
		
		//Event Listener
		
		btnIniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				TelaEstacaoEb telaEstacoes = new TelaEstacaoEb(basePane, contentPane);
			}
		});
		
		return contentPane;
	}

}
