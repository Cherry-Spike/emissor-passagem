package br.unip.team.emissopassagem.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public abstract class PanelBase {
	protected JPanel basePane;
	protected JPanel backPane;
	protected Color corDeFundo = new Color(36, 63, 111);
	
	public void setNewPane(JPanel contentPane, JPanel basePane) {
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 640, 480);
		basePane.add(contentPane);
		
	}
	
	public void setBasePane(JPanel basePane){
		this.basePane = basePane;
	}
	
	public void setBackPane(JPanel backPane) {
		this.backPane = backPane;
	}

	public abstract JPanel window();
}
