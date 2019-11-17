package br.unip.team.emissopassagem.view.tela;

import java.sql.Time;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import br.unip.team.emissopassagem.controller.EstacaoController;
import br.unip.team.emissopassagem.controller.ItinerarioController;
import br.unip.team.emissopassagem.model.entidade.Estacao;
import br.unip.team.emissopassagem.model.entidade.Horario;
import br.unip.team.emissopassagem.model.entidade.Itinerario;

public class TelaPassagem extends Tela<String> {
	EstacaoController estacaoController = new EstacaoController();
	ItinerarioController itinerarioController = new ItinerarioController();
	private JComboBox<String> cbHorario;
	private JComboBox<String> cbQtd;
	private Estacao estacaoEmbarque;
	private Estacao estacaoDesembarque;
	private Itinerario itinerario;

	public TelaPassagem(JPanel basePane, JPanel backPane, Estacao EstacaoEmbarque, Estacao inputEstacaoDesembarque) {
		estacaoDesembarque = inputEstacaoDesembarque;
		estacaoEmbarque = EstacaoEmbarque;
		setBasePane(basePane);
		setBackPane(backPane);
		setNewPane(window(), basePane);
	}

	@Override
	public JPanel window() {

		JPanel contentPane = new JPanel();
		contentPane.setBackground(corDeFundo);

		setLabel(contentPane, "Escolha um Horário:", 220, 35, 500, 30, 20);
		cbHorario = setComboBox(220, 85, 200, 60);
		setCbHorario(cbHorario);
		contentPane.add(cbHorario);

		setLabel(contentPane, "Escolha a quantidade de passagens:", 155, 175, 500, 30, 20);
		cbQtd = setComboBox(270, 225, 100, 60);
		contentPane.add(cbQtd);
		cbQtd.addItem("1");
		cbQtd.addItem("2");
		cbQtd.addItem("3");
		cbQtd.addItem("4");
		cbQtd.addItem("5");

		JButton prox = setButtonProx(contentPane);
		JButton cancel = setButtonCancel(contentPane);

		prox.addActionListener(e -> {
			setItinerario();
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

	public void setCbHorario(JComboBox<String> cb) {
		List<Horario> horarios = estacaoController.obterEstacaoHorarios(estacaoEmbarque.getId(), estacaoDesembarque.getId());
		for (Horario horario : horarios) {
				cb.addItem(horario.gethora());			
		}
	}
	
	public void setItinerario() {
		
		itinerario.setIdEstacaoEmbarque(estacaoEmbarque.getId());
		itinerario.setIdEstacaoDesembarque(estacaoDesembarque.getId());
		itinerario.setIdEmbarqueHorario((int) cbHorario.getSelectedItem());
		itinerario.setQtdPassagem((int) cbQtd.getSelectedItem());		
		itinerarioController.adicionarItinerario(itinerario);
		
	}
	
}
