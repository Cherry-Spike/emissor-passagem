package br.unip.team.emissopassagem.view.Telas;


import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.unip.team.emissopassagem.model.entidade.Estacao;
import br.unip.team.emissopassagem.model.persistencia.EstacaoDAO;

public abstract class Tela {

	protected JPanel basePane;
	protected JPanel backPane;
	protected Color corDeFundo = new Color(36, 63, 111);
	
	public Tela() {}
	
public void setNewPane(JPanel contentPane, JPanel basePane) {
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 640, 480);
		basePane.add(contentPane);
		
	}
	
	public JButton setButtonProx(JPanel contentPane) {
		
		JButton btnProx = new JButton("PROXIMO");
		btnProx.setBounds(375, 350, 200, 60);
		//btnProx.setEnabled(false);
		btnProx.setFont(new Font("Arial", Font.BOLD, 25));
		btnProx.setBackground(new Color(0, 153, 255));
		btnProx.setForeground(Color.white);
		btnProx.setOpaque(true);
		btnProx.setBorderPainted(false);
		btnProx.setFocusPainted(false);
		contentPane.add(btnProx);
		
		return btnProx;
			
	}
	
	public JButton setButtonCancel(JPanel contentPane) {
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(60, 350, 200, 60);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 25));
		btnCancelar.setBackground(new Color(85, 96, 125));
		btnCancelar.setForeground(Color.white);
		btnCancelar.setOpaque(true);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setFocusPainted(false);
		contentPane.add(btnCancelar);
		
		return btnCancelar;
		
	}
	
	public void setComboBoxEstacao(JPanel contentPane){
		
		JComboBox<Object> cbEstacao = new JComboBox<Object>();
		cbEstacao.setBounds(170, 150, 300, 60);
		cbEstacao.setBackground(new Color(196, 217, 237));
		cbEstacao.setForeground(new Color(0, 102, 153));
		cbEstacao.setFont(new Font(cbEstacao.getFont().getName(), cbEstacao.getFont().getStyle(), 18));
		cbEstacao.setFocusable(false);
		cbEstacao.setBorder(null);
		EstacaoDAO estacaoDAO = new EstacaoDAO();
		for(Estacao estacao: estacaoDAO.obterTodos()) {
			cbEstacao.addItem(estacao);
		}
		contentPane.add(cbEstacao);
		
	}
	
	public void setBasePane(JPanel basePane){
		this.basePane = basePane;
	};
	
	public void setBackPane(JPanel backPane) {
		this.backPane = backPane;
	}
	
	public abstract JPanel window();

}
