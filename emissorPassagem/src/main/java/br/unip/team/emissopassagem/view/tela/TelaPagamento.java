package br.unip.team.emissopassagem.view.tela;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import br.unip.team.emissopassagem.controller.LogController;
import br.unip.team.emissopassagem.model.entidade.Cartao;

public class TelaPagamento extends Tela<Object> {
	private LogController logController;
	private Cartao cartao;
	private JButton prox;
	private JTextField tfCartao, tfPin;
	private int idItinerario;
	private final int cartaoLimite = 16, pinLimite = 3;

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
		
		prox = setButtonProx(contentPane);
		JButton cancel = setButtonCancel(contentPane);
		setLabel(contentPane, "Digite o numero do cartão:", 150, 40, 500, 30, 18);
		tfCartao = setTextField(contentPane, 150, 90, 300, 50, cartaoLimite);
		setLabel(contentPane, "Digite o PIN:", 150, 185, 500, 30, 18);
		tfPin = setTextField(contentPane, 150, 230, 100, 50, pinLimite);
		
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
		
		tfCartao.addKeyListener(new KeyListener() {			
						
			public void keyTyped(KeyEvent e) {validaBtn();}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}

		});
		
		tfPin.addKeyListener(new KeyListener() {			
			
			public void keyTyped(KeyEvent e) {validaBtn();}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}

		});

		return contentPane;

	}
	
	public void validaBtn() {
		if(tfCartao.getText().length() >= cartaoLimite && tfPin.getText().length() >= pinLimite) {
			prox.setEnabled(true);
		}else {
			prox.setEnabled(false);
		}
	}

}
