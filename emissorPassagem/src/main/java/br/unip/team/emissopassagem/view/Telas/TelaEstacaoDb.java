package br.unip.team.emissopassagem.view.Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.unip.team.emissopassagem.model.entidade.Estacao;
import br.unip.team.emissopassagem.model.persistencia.EstacaoDAO;

public class TelaEstacaoDb extends Tela {

	public TelaEstacaoDb(JPanel basePane, JPanel backPane) {
		setBasePane(basePane);
		setBackPane(backPane);
		setNewPane(window(), basePane);
	}

	@Override
	public JPanel window() {
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(corDeFundo);
		
		JLabel lbDesc = new JLabel("Escolha a estação de destino");
		lbDesc.setBounds(180,100, 500, 30);
		lbDesc.setForeground(Color.white);
		lbDesc.setFont(new Font(lbDesc.getFont().getName(), lbDesc.getFont().getStyle(), 20));
		contentPane.add(lbDesc);
		
		setComboBoxEstacao(contentPane);		
		
		//Event Listener
		
		setButtonProx(contentPane).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
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
