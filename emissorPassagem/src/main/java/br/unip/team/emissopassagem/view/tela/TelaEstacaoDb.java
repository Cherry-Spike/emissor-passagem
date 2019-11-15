package br.unip.team.emissopassagem.view.tela;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import br.unip.team.emissopassagem.controller.EstacaoDesembarqueController;
import br.unip.team.emissopassagem.controller.EstacaoEmbarqueController;
import br.unip.team.emissopassagem.model.entidade.Estacao;
import br.unip.team.emissopassagem.model.servico.EstacaoServico;

public class TelaEstacaoDb extends Tela<Estacao> {

	EstacaoDesembarqueController estacaoDbController = new EstacaoDesembarqueController(this);
	public TelaEstacaoDb(JPanel basePane, JPanel backPane) {
		setBasePane(basePane);
		setBackPane(backPane);
		setNewPane(window(), basePane);
	}

	@Override
	public JPanel window() {

		JPanel contentPane = new JPanel();
		contentPane.setBackground(corDeFundo);

		setLabel(contentPane, "Escolha a estação de destino", 180, 100, 500, 30, 20);
		JComboBox<Estacao> cb = setComboBox(170, 150, 300, 60);
		setCbEstacao(cb);
		contentPane.add(cb);
		JButton prox = setButtonProx(contentPane);
		JButton cancel = setButtonCancel(contentPane);
		
		prox.addActionListener(e -> trocaFrame("TelaPassagem", basePane, contentPane));

		//cancel.addActionListener(e -> trocaFrame("TelaEstacaoEb", contentPane, basePane));

		cb.addActionListener(e -> {
			if (cb.getSelectedItem() != null) {
				prox.setEnabled(true);
			}
		});

		return contentPane;

	}

	public void setCbEstacao(JComboBox<Estacao> cb) {
		for (Estacao estacao : estacaoDbController.obterTodasEstacoes()) {
			
			cb.addItem(estacao);
		}
	}

}
