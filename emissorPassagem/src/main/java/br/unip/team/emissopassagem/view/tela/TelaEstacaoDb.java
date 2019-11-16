package br.unip.team.emissopassagem.view.tela;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import br.unip.team.emissopassagem.controller.EstacaoDesembarqueController;
import br.unip.team.emissopassagem.model.entidade.Estacao;

public class TelaEstacaoDb extends Tela<Estacao> {
	EstacaoDesembarqueController estacaoDbController = new EstacaoDesembarqueController(this);
	private int idEstacaoEmbarque;
	private Estacao estacaoSelecionada;
	
	public TelaEstacaoDb(JPanel basePane, JPanel backPane, int inputIdEstacaoEmbarque) {
		setBasePane(basePane);
		setBackPane(backPane);
		setNewPane(window(), basePane);
		idEstacaoEmbarque = inputIdEstacaoEmbarque;
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
			new TelaPassagem(basePane, backPane, idEstacaoEmbarque, estacaoSelecionada.getId());
		});

		cancel.addActionListener(e -> {
			contentPane.setVisible(false);
			backPane.setVisible(true);
		}
		);

		cb.addActionListener(e -> {
			estacaoSelecionada = (Estacao) cb.getSelectedItem();
			if (estacaoSelecionada != null) {
				prox.setEnabled(true);
			}
		});

		return contentPane;

	}

	public void setCbEstacao(JComboBox<Estacao> cb) {
		Estacao estacaoEmbarque = estacaoDbController.obterEstacaoEmbarquePorId(idEstacaoEmbarque);
		for (Estacao estacao : estacaoDbController.obterTodasEstacoes()) {
			if(estacaoEmbarque.getNome() == estacao.getNome())
				continue;
			cb.addItem(estacao);
		}
	}

}
