package br.unip.team.emissorpassagem.view;

import java.awt.EventQueue;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 7662232455345233978L;
	private static final Logger LOGGER = Logger.getLogger(MainFrame.class.getName());

	private JPanel basePane;

	public MainFrame(String nomeClasse) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 640, 480);
		basePane = new JPanel();
		basePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		basePane.setLayout(null);
		setContentPane(basePane);
		setResizable(false);
		setTitle("Sistema Emissor de Passagens");
		Class<?> c;
		Constructor<?> cons = null;
		try {
			c = Class.forName("br.unip.team.emissopassagem.view.tela." + nomeClasse);
			cons = c.getConstructor(JPanel.class);
			cons.newInstance(basePane);
		} catch (ClassNotFoundException e) {
			LOGGER.info("Erro ao instaciar Frame");
		} catch (NoSuchMethodException | SecurityException e) {
			LOGGER.info("Erro no construtor do Frame");
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			LOGGER.info("Exceção no construtor do Frame");
		}
	}

	public MainFrame(String nomeClasse, JPanel basePane, JPanel backPane) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 640, 480);
		setContentPane(basePane);
		setResizable(false);
		setTitle("Sistema Emissor de Passagens");
		Class<?> c;
		Constructor<?> cons = null;
		try {
			c = Class.forName("br.unip.team.emissopassagem.view.tela." + nomeClasse);
			cons = c.getConstructor(JPanel.class, JPanel.class);
			cons.newInstance(basePane, backPane);
		} catch (ClassNotFoundException e) {
			LOGGER.info("Erro ao instaciar Frame");
		} catch (NoSuchMethodException | SecurityException e) {
			LOGGER.info("Erro no construtor do Frame");
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			LOGGER.info("Exceção no construtor do Frame");
		}
	}
	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			try {
				MainFrame frame = new MainFrame(Arrays.toString(args));
				frame.setVisible(true);
			} catch (Exception e) {
				LOGGER.info(e.getMessage());
			}
		});
	}
}
