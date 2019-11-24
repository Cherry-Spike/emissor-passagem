package br.unip.team.emissorpassagem.view.tela;


import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.mindfusion.keyboard.KeyboardLayout;
import com.mindfusion.keyboard.KeyboardMode;
import com.mindfusion.keyboard.Theme;
import com.mindfusion.keyboard.VirtualKeyboard;

import br.unip.team.emissorpassagem.controller.LogController;
import br.unip.team.emissorpassagem.controller.PassagemController;
import br.unip.team.emissorpassagem.model.entidade.Cartao;

public class TelaPagamento extends Tela<Object> {
	JFrame kbFrame = new JFrame();
	private LogController logController = new LogController();
	private PassagemController passagemController = new PassagemController();
	private Cartao cartao = new Cartao();
	private JButton prox;
	private JTextField tfCartao, tfPin;
	private int idItinerario;
	private static final int CARTAO_LIMITE = 16;
	private static final int PIN_LIMITE = 3;
	private static final String TEMPLATE = "src\\main\\java\\br\\unip\\team\\emissorpassagem\\view\\assets\\NumPad(68551702).xml";

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
		
    	VirtualKeyboard vkb = new VirtualKeyboard();
    	vkb.setStandalone(true);
		vkb.setFocusable(false);
		vkb.setPreferredSize(new Dimension(240, 300));
		vkb.setTemplateLayout(KeyboardLayout.create(TEMPLATE));
		kbFrame.setBounds(450, 300, 240, 300);
		kbFrame.setResizable(false);
		vkb.setTheme(Theme.OfficeSilver);
		kbFrame.getContentPane().add(vkb);
		kbFrame.setVisible(false);

		prox = setButtonProx(contentPane);
		JButton cancel = setButtonCancel(contentPane);
		setLabel(contentPane, "Digite o numero do cartão:", 150, 40, 500, 30, 18);
		tfCartao = setTextField(contentPane, 150, 90, 300, 50, CARTAO_LIMITE);
		setLabel(contentPane, "Digite o PIN:", 150, 185, 500, 30, 18);
		tfPin = setTextField(contentPane, 150, 230, 100, 50, PIN_LIMITE);

		// Event Listeners

		prox.addActionListener(e -> {
			cartao.setNumero(tfCartao.getText());
			int pin = Integer.parseInt(tfPin.getText());
			cartao.setPin(pin);

			logController.adicionarLog(idItinerario, cartao);
			int idPassgem = passagemController.adicionarPassagem(idItinerario);
			contentPane.setVisible(false);
			kbFrame.setVisible(false);
			new TelaEmissao(basePane, backPane, idPassgem);
		});

		cancel.addActionListener(e -> {
			contentPane.setVisible(false);
			backPane.setVisible(true);
		});

		tfCartao.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				validaBtn();
			}
			
			public void keyPressed(KeyEvent e) {				
		        if (e.getKeyCode()==KeyEvent.VK_ENTER){
		        	kbFrame.setVisible(false);
		        }					
			}	
			
			public void keyReleased(KeyEvent e) {}

		});

		tfPin.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				validaBtn();
			}
			
			public void keyPressed(KeyEvent e) {				
		        if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE){
		        	kbFrame.setVisible(false);
		        }			        
			}
			
			public void keyReleased(KeyEvent e) {}

		});
		
//		tfCartao.addMouseListener(new MouseAdapter() {
//            @Override
//             public void mouseClicked(MouseEvent e) {
//            	vkb.setMode(KeyboardMode.Custom);
//            	kbFrame.setVisible(true);
//             }            
//        });
//		
//		tfPin.addMouseListener(new MouseAdapter() {
//            @Override
//             public void mouseClicked(MouseEvent e) {
//            	vkb.setMode(KeyboardMode.Custom);
//            	kbFrame.setVisible(true);
//             }            
//        });

		return contentPane;

	}

	public void validaBtn() {
		if (tfCartao.getText().length() >= CARTAO_LIMITE && tfPin.getText().length() >= PIN_LIMITE)
			prox.setEnabled(true);
		else
			prox.setEnabled(false);
	}
}
