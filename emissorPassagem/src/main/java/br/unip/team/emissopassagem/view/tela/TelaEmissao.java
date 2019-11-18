package br.unip.team.emissopassagem.view.tela;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.unip.team.emissopassagem.controller.PassagemController;
import br.unip.team.emissopassagem.model.entidade.Passagem;
import br.unip.team.emissopassagem.model.entidade.PassagemValueObject;
import br.unip.team.emissopassagem.view.PanelBase;

public class TelaEmissao extends PanelBase  {
	private PassagemController passagemController = new PassagemController();
	private int idPassgem;
	public TelaEmissao(JPanel basePane, JPanel backPane, int idPassgem) {
		this.idPassgem = idPassgem;
		setBasePane(basePane);
		setBackPane(backPane);
		setNewPane(window(), basePane);
	}

	public JPanel window() {
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(corDeFundo);
		PassagemValueObject passagem = passagemController.obterPassagemPorId(idPassgem);
		ImageIcon imgLogo = new ImageIcon(getClass().getResource("Img\\logo-sntf.jpg"));		
		JLabel logoSNTF = new JLabel(imgLogo);
		logoSNTF.setBounds(0, 80, 263, 180);
		contentPane.add(logoSNTF);
		
		//Event Listener
		
		setButtonCancel(contentPane).addActionListener(e -> {
				contentPane.setVisible(false);
				backPane.setVisible(true);
		});
		
		return contentPane;
		
	}
	
	public JButton setButtonCancel(JPanel contentPane) {

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(60, 360, 200, 50);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 23));
		btnCancelar.setBackground(new Color(85, 96, 125));
		btnCancelar.setForeground(Color.white);
		btnCancelar.setOpaque(true);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setFocusPainted(false);
		contentPane.add(btnCancelar);

		return btnCancelar;

	}

}
