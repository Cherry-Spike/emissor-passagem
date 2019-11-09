package br.unip.team.emissopassagem.view.Telas;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public abstract class Tela {

	protected JPanel basePane;
	protected JPanel backPane;
	
	public Tela() {}
	
public void setNewPane(JPanel contentPane, JPanel basePane) {
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 640, 480);
		basePane.add(contentPane);
		
	}

	public void setBasePane(JPanel basePane){
		this.basePane = basePane;
	};
	
	public void setBackPane(JPanel backPane) {
		this.backPane = backPane;
	}
	
	public abstract JPanel window();

}
