package br.unip.team.emissopassagem.view.Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
	
	public JLabel setLabel(JPanel contentPane, String str, int x, int y, int l, int a, int size) {
		
		JLabel lb = new JLabel(str);
		lb.setBounds(x, y, l, a);
		lb.setForeground(Color.white);
		lb.setFont(new Font(lb.getFont().getName(), lb.getFont().getStyle(), size));
		contentPane.add(lb);
		
		return lb;
		
	}
	
	public JComboBox<Object> setComboBox(JPanel contentPane, int x, int y, int l, int a){
		
		JComboBox<Object> cb = new JComboBox<Object>();
		cb.setBounds(x, y, l, a);
		cb.setBackground(new Color(196, 217, 237));
		cb.setForeground(new Color(0, 102, 153));
		cb.setFont(new Font(cb.getFont().getName(), cb.getFont().getStyle(), 18));
		cb.setFocusable(false);
		cb.setBorder(null);
		/*EstacaoDAO estacaoDAO = new EstacaoDAO();
		for(Estacao estacao: estacaoDAO.obterTodos()) {
			cbEstacao.addItem(estacao);
		}*/
		contentPane.add(cb);
		
		return cb;
	}
	
	public JTextField setTextField(JPanel contentPane, int x, int y, int l, int a, int limit) {
		
		JTextField txt = new JTextField(10);
		txt.setBounds(x, y, l, a);
		txt.setBackground(new Color(196, 217, 237));
		txt.setForeground(new Color(0, 102, 153));
		txt.setFont(new Font(txt.getFont().getName(), txt.getFont().getStyle(), 25));
		txt.setBorder(null);
		
		txt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt.getText().length() >= limit) {
					e.consume();
				}
				
			}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			
		});;
		
		contentPane.add(txt);
		
		return txt;
	}
	
	/* Set & Get */
	
	public void setBasePane(JPanel basePane){
		this.basePane = basePane;
	}
	
	public void setBackPane(JPanel backPane) {
		this.backPane = backPane;
	}
	
	public abstract JPanel window();

}
