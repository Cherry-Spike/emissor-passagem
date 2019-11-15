package br.unip.team.emissopassagem.view.tela;

import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import br.unip.team.emissopassagem.model.entidade.Horario;

public class TelaPassagem extends Tela<String> {

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
		JComboBox<String> cbHorario = setComboBox(220, 85, 200, 60);
		cbHorario.addItem("08:00");
		contentPane.add(cbHorario);

		setLabel(contentPane, "Escolha a quantidade de passagens:", 155, 175, 500, 30, 20);
		@SuppressWarnings("rawtypes")
		JComboBox cbQtd = setComboBox(270, 225, 100, 60);
		contentPane.add(cbQtd);
		cbQtd.addItem(1);
		cbQtd.addItem(2);
		cbQtd.addItem(3);
		cbQtd.addItem(4);
		cbQtd.addItem(5);

		JButton prox = setButtonProx(contentPane);
		JButton cancel = setButtonCancel(contentPane);

		// Event Listener

		prox.addActionListener(e -> {
			contentPane.setVisible(false);
			new TelaPagamento(basePane, backPane);
		});

		cancel.addActionListener(e -> {
			contentPane.setVisible(false);
			backPane.setVisible(true);
		});

		cbHorario.addActionListener(e -> {
			if (cbHorario.getSelectedItem() != null && cbQtd.getSelectedItem() != null) {
				prox.setEnabled(true);
			}
		});

		cbQtd.addActionListener(e -> {
			if (cbQtd.getSelectedItem() != null && cbHorario.getSelectedItem() != null) {
				prox.setEnabled(true);
			}
		});

		return contentPane;

	}

}
