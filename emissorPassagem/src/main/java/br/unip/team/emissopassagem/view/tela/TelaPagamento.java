package br.unip.team.emissopassagem.view.tela;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import br.unip.team.emissopassagem.controller.LogController;
import br.unip.team.emissopassagem.controller.PassagemController;
import br.unip.team.emissopassagem.model.entidade.Cartao;
import br.unip.team.emissopassagem.model.entidade.VirtualKeyboard;

public class TelaPagamento extends Tela<Object> {
	private LogController logController = new LogController();
	private PassagemController passagemController = new PassagemController();
	private Cartao cartao = new Cartao();
	private JButton prox;
	private JTextField tfCartao, tfPin;
	private int idItinerario;
	private static final int CARTAO_LIMITE = 16;
	private static final int PIN_LIMITE = 3;

	public TelaPagamento(JPanel basePane, JPanel backPane, int idItinerario) {
		this.idItinerario = idItinerario;
		setBasePane(basePane);
		setBackPane(backPane);
		setNewPane(window(), basePane);
	}

	@Override
	public JPanel window() {

		JPanel contentPane = new JPanel();
		contentPane.setBackground(corDeFundo);

		prox = setButtonProx(contentPane);
		JButton cancel = setButtonCancel(contentPane);
		setLabel(contentPane, "Digite o numero do cartão:", 150, 40, 500, 30, 18);
		tfCartao = setTextField(contentPane, 150, 90, 300, 50, CARTAO_LIMITE);
		setLabel(contentPane, "Digite o PIN:", 150, 185, 500, 30, 18);
		tfPin = setTextField(contentPane, 150, 230, 100, 50, PIN_LIMITE);

		// Event Listener

		prox.addActionListener(e -> {
			cartao.setNumero(tfCartao.getText());
			int pin = Integer.parseInt(tfPin.getText());
			cartao.setPin(pin);

			logController.adicionarLog(idItinerario, cartao);
			int idPassgem = passagemController.adicionarPassagem(idItinerario);
			contentPane.setVisible(false);
			new TelaEmissao(basePane, backPane, idPassgem);
		});

		cancel.addActionListener(e -> {
			contentPane.setVisible(false);
			backPane.setVisible(true);
		});
		
		//Arrumar Key Board
		/*tfCartao.addMouseListener(new MouseAdapter() {		
			public void mouseClicked(MouseEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getRootPane(contentPane).getParent();
				VirtualKeyboard vk = new VirtualKeyboard();
				vk.show(frame, contentPane);
			}
		});*/

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
		if (tfCartao.getText().length() >= CARTAO_LIMITE && tfPin.getText().length() >= PIN_LIMITE)
			prox.setEnabled(true);
		else
			prox.setEnabled(false);
	}
}
