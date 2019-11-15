package br.unip.team.emissopassagem.view.tela;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.unip.team.emissopassagem.controller.EstacaoEmbarqueController;
import br.unip.team.emissopassagem.model.entidade.Estacao;
import br.unip.team.emissopassagem.view.MainFrame;

public class TelaEstacaoEb extends Tela<Estacao> {

	EstacaoEmbarqueController estacaoEbController = new EstacaoEmbarqueController(this);

	public TelaEstacaoEb(JPanel basePane, JPanel backPane) {
		setBasePane(basePane);
		setBackPane(backPane);
		setNewPane(window(), basePane);
	}

	@Override
	public JPanel window() {

		JPanel contentPane = new JPanel();
		contentPane.setBackground(corDeFundo);

		setLabel(contentPane, "Escolha a estação de embarque", 170, 100, 500, 30, 20);
		JComboBox<Estacao> cb = setComboBox(170, 150, 300, 60);
		setCbEstacao(cb);
		contentPane.add(cb);
		JButton prox = setButtonProx(contentPane);
		JButton cancel = setButtonCancel(contentPane);

		prox.addActionListener(e -> trocaFrame("TelaEstacaoDb", basePane, contentPane));

		cancel.addActionListener(e -> {
			contentPane.setVisible(false);
			backPane.setVisible(true);
		});

		cb.addActionListener(e -> {
			Estacao estacao = (Estacao) cb.getSelectedItem();
			if (cb.getSelectedItem() != null) {
				prox.setEnabled(true);
			}
		});

		return contentPane;

	}

	public void setCbEstacao(JComboBox<Estacao> cb) {
		for (Estacao estacao : estacaoEbController.obterTodasEstacoes()) {
			cb.addItem(estacao);
		}
	}
}
