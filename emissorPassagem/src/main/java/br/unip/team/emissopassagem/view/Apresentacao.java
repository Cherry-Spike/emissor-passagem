package br.unip.team.emissopassagem.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.unip.team.emissopassagem.model.persistencia.ConexaoDb;

public class Apresentacao extends JFrame {
	
	private JPanel basePane;
	
	public Apresentacao() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		basePane = new JPanel();
		basePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		basePane.setLayout(null);
		setContentPane(basePane);
		setResizable(false);
		setTitle("Ordenador de Coordenadas");
		
	}

	public static void main(String[] args) throws ClassNotFoundException {
		new ConexaoDb();
			
	}
		
}
