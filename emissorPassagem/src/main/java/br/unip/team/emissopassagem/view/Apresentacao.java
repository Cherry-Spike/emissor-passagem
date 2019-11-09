package br.unip.team.emissopassagem.view;

import java.util.List;

import br.unip.team.emissopassagem.model.entidade.Cidade;
import br.unip.team.emissopassagem.model.persistencia.CidadeDAO;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.unip.team.emissopassagem.view.Telas.TelaIniciar;

public class Apresentacao extends JFrame {
	
	private JPanel basePane;
	
	public Apresentacao() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		basePane = new JPanel();
		basePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		basePane.setLayout(null);
		setContentPane(basePane);
		setResizable(false);
		setTitle("Sistema Emissor de Passagens");
		new TelaIniciar(basePane);
	}

	public static void main(String[] args) throws ClassNotFoundException {
		//CidadeDAO dao= new CidadeDAO();
		//List<Cidade>testeCidade = dao.obterTodos();
		

		//new ConexaoDb();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao frame = new Apresentacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
}
