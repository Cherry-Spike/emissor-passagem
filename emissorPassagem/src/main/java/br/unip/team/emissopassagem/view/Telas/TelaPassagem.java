package br.unip.team.emissopassagem.view.Telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class TelaPassagem extends Tela {

	public TelaPassagem(JPanel basePane, JPanel backPane) {
		setBasePane(basePane);
		setBackPane(backPane);
		setNewPane(window(), basePane);
	}

	@SuppressWarnings("unchecked")
	@Override
	public JPanel window() {
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(corDeFundo);
		
		setLabel(contentPane, "Escolha um Horário:", 220, 35, 500, 30, 20);		
		JComboBox<Object> cbHorario = setComboBox(contentPane, 220, 85, 200, 60);
		cbHorario.addItem("Teste");
		
		setLabel(contentPane, "Escolha a quantidade de passagens:", 155, 175, 500, 30, 20);		
		@SuppressWarnings("rawtypes")
		JComboBox cbQtd = setComboBox(contentPane, 270, 225, 100, 60);	
		cbQtd.addItem(1);
		cbQtd.addItem(2);
		cbQtd.addItem(3);
		cbQtd.addItem(4);
		cbQtd.addItem(5);
		
		JButton prox = setButtonProx(contentPane);
		JButton cancel = setButtonCancel(contentPane);
		
		//Event Listener
		
		prox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				new TelaPagamento(basePane, backPane);
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				backPane.setVisible(true);
			}
		});
		
		cbHorario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbHorario.getSelectedItem() != null && cbQtd.getSelectedItem() != null) {
					prox.setEnabled(true);
				}
			}
		});
		
		cbQtd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbQtd.getSelectedItem() != null && cbHorario.getSelectedItem() != null) {
					prox.setEnabled(true);
				}
			}
		});
		
		return contentPane;
		
	}

}
