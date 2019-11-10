package br.unip.team.emissopassagem.view.Telas;


import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.unip.team.emissopassagem.model.entidade.Cidade;
import br.unip.team.emissopassagem.model.persistencia.CidadeDAO;

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
	
	public void setComboBoxCidade(JPanel contentPane){
		
		JComboBox<Object> cbCidade = new JComboBox<Object>();
		cbCidade.setBounds(170, 150, 300, 60);
		cbCidade.setBackground(new Color(196, 217, 237));
		cbCidade.setForeground(new Color(0, 102, 153));
		cbCidade.setFont(new Font(cbCidade.getFont().getName(), cbCidade.getFont().getStyle(), 18));
		cbCidade.setFocusable(false);
		cbCidade.setBorder(null);
		//CidadeDAO dao = new CidadeDAO();
		//for(Cidade c: dao.obterTodos()) {
		//	cbCidade.addItem(c);
		//}
		contentPane.add(cbCidade);
		
	}
	
	public void setBasePane(JPanel basePane){
		this.basePane = basePane;
	};
	
	public void setBackPane(JPanel backPane) {
		this.backPane = backPane;
	}
	
	public abstract JPanel window();

}
