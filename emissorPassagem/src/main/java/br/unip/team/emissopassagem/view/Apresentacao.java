package br.unip.team.emissopassagem.view;

import java.awt.EventQueue;
import java.util.logging.Logger;

public class Apresentacao {
	private static final Logger LOGGER = Logger.getLogger(Apresentacao.class.getName());

	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			try {
				MainFrame frame = new MainFrame("TelaIniciar");
				frame.setVisible(true);
			} catch (Exception e) {
				LOGGER.info("Erro ao iniciar apresentação");
			}
		});
	}

}
