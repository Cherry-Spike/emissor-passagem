package br.unip.team.emissopassagem.view.Telas;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaIniciar {

	protected JPanel basePane;
	
	public TelaIniciar(JPanel basePane) {
		setBasePane(basePane);
		setNewPane(window(), basePane);
	}
	
	public JPanel window() {
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(36, 63, 111));
		
		JButton btnIniciar = new JButton("INICIAR");
		btnIniciar.setBounds(230, 300, 180, 60);
		btnIniciar.setFont(new Font("Arial", Font.BOLD, 25));
		btnIniciar.setBackground(new Color(0, 153, 255));
		btnIniciar.setForeground(Color.white);
		btnIniciar.setOpaque(true);
		btnIniciar.setBorderPainted(false);
		btnIniciar.setFocusPainted(false);
		contentPane.add(btnIniciar);
		
		ImageIcon img;
		img = new ImageIcon(getClass().getResource("Img\\Train.png"));		
		JLabel imgTrem = new JLabel(img);
		imgTrem.setBounds(15, 15, 600, 260);
		contentPane.add(imgTrem);
		
		return contentPane;
	}
	
	public void setNewPane(JPanel contentPane, JPanel basePane) {

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 640, 480);
		basePane.add(contentPane);

	}

	public void setBasePane(JPanel basePane) {
		this.basePane = basePane;
	};


}
