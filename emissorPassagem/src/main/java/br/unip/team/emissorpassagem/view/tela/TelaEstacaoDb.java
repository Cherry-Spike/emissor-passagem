package br.unip.team.emissorpassagem.view.tela;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import br.unip.team.emissorpassagem.controller.EstacaoController;
import br.unip.team.emissorpassagem.model.entidade.Estacao;

public class TelaEstacaoDb extends Tela<Estacao> {
	EstacaoController estacaoController = new EstacaoController();
	private Estacao estacaoEmbarque;
	private Estacao estacaoSelecionada;
	
	public TelaEstacaoDb(JPanel basePane, JPanel backPane, Estacao inputEstacaoEmbarque) {
		estacaoEmbarque = inputEstacaoEmbarque;
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
		
		prox.addActionListener(e -> {
			contentPane.setVisible(false);
			new TelaPassagem(basePane, backPane, estacaoEmbarque, estacaoSelecionada);
		});

		cancel.addActionListener(e -> {
			contentPane.setVisible(false);
			backPane.setVisible(true);
		});

		cb.addActionListener(e -> {
			estacaoSelecionada = (Estacao) cb.getSelectedItem();
			if (estacaoSelecionada != null) {
				prox.setEnabled(true);
			}
		});

		return contentPane;

	}

	public void setCbEstacao(JComboBox<Estacao> cb) {
		for (Estacao estacao : estacaoController.obterTodasEstacoes()) {
			if(estacaoEmbarque.getId() != estacao.getId())
				cb.addItem(estacao);			
		}
	}
}
