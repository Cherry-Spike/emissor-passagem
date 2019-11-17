package br.unip.team.emissopassagem.view.tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import br.unip.team.emissopassagem.view.MainFrame;
import br.unip.team.emissopassagem.view.PanelBase;

public abstract class Tela<E> extends PanelBase{

	public JButton setButtonProx(JPanel contentPane) {

		JButton btnProx = new JButton("PROXIMO");
		btnProx.setBounds(375, 360, 200, 50);
		btnProx.setEnabled(false);
		btnProx.setFont(new Font("Arial", Font.BOLD, 23));
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
		btnCancelar.setBounds(60, 360, 200, 50);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 23));
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

	public JComboBox<E> setComboBox(int x, int y, int l, int a) {

		JComboBox<E> cb = new JComboBox<>();
		cb.setBounds(x, y, l, a);
		cb.setBackground(new Color(196, 217, 237));
		cb.setForeground(new Color(0, 102, 153));
		cb.setFont(new Font(cb.getFont().getName(), cb.getFont().getStyle(), 18));
		cb.setFocusable(false);
		cb.setBorder(null);

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
				if (txt.getText().length() >= limit) {
					e.consume();
				}

				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}

			}

			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
			}

		});

		contentPane.add(txt);

		return txt;
	}
	
	public void trocaFrame(String nomeTela, JPanel basePane, JPanel backPane) {
		JFrame frameAnterior = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, basePane);
		frameAnterior.dispose();
		JFrame telaEstacaoEb = new MainFrame(nomeTela, basePane, backPane);
		backPane.setVisible(false);
		telaEstacaoEb.setVisible(true);
	}
}
