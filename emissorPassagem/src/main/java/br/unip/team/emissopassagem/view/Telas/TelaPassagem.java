package br.unip.team.emissopassagem.view.Telas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		setComboBox(contentPane, 220, 85, 200, 60);
		setLabel(contentPane, "Escolha a quantidade de passagens:", 155, 175, 500, 30, 20);
		
		@SuppressWarnings("rawtypes")
		JComboBox cb = setComboBox(contentPane, 270, 225, 100, 60);	
		cb.addItem(1);
		cb.addItem(2);
		cb.addItem(3);
		cb.addItem(4);
		cb.addItem(5);
		
		//Event Listener
		
		setButtonProx(contentPane).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				TelaPagamento telaPagamento = new TelaPagamento(basePane, backPane);
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
