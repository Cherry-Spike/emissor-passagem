package br.unip.team.emissopassagem.view.tela;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.unip.team.emissopassagem.controller.LogController;
import br.unip.team.emissopassagem.model.entidade.Cartao;

public class TelaPagamento extends Tela<Object> {
	private LogController logController;
	private int idItinerario;
	private Cartao cartao;

	public TelaPagamento(JPanel basePane, JPanel backPane, int idItinerario) {
		setBasePane(basePane);
		setBackPane(backPane);
		setNewPane(window(), basePane);
		this.idItinerario = idItinerario;
	}

	@Override
	public JPanel window() {

		JPanel contentPane = new JPanel();
		contentPane.setBackground(corDeFundo);

		setLabel(contentPane, "Digite o numero do cartão:", 150, 40, 500, 30, 18);
		setTextField(contentPane, 150, 90, 300, 50, 15);
		setLabel(contentPane, "Digite o PIN:", 150, 185, 500, 30, 18);
		setTextField(contentPane, 150, 230, 100, 50, 3);
		JButton prox = setButtonProx(contentPane);
		JButton cancel = setButtonCancel(contentPane);

		// Event Listener

		prox.addActionListener(e -> {
			logController.adicionarLog(idItinerario, cartao);
			contentPane.setVisible(false);
			new TelaEmissao(basePane, backPane);
		});

		cancel.addActionListener(e -> {
			contentPane.setVisible(false);
			backPane.setVisible(true);
		});

		return contentPane;

	}

}
