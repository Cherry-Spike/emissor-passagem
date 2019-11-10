package br.unip.team.emissopassagem.view.Telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.unip.team.emissopassagem.model.entidade.Estacao;
import br.unip.team.emissopassagem.model.persistencia.EstacaoDAO;

public class TelaPassagem extends Tela {

	public TelaPassagem(JPanel basePane, JPanel backPane) {
		setBasePane(basePane);
		setBackPane(backPane);
		setNewPane(window(), basePane);
	}

	@Override
	public JPanel window() {
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(corDeFundo);
		
		JLabel lbDesc = new JLabel("Escolha a estação de destino");
		lbDesc.setBounds(180,100, 500, 30);
		lbDesc.setForeground(Color.white);
		lbDesc.setFont(new Font(lbDesc.getFont().getName(), lbDesc.getFont().getStyle(), 20));
		contentPane.add(lbDesc);
		
<<<<<<< HEAD
		setComboBoxCidade(contentPane);		
=======
		JComboBox<Object> cbEstacao = new JComboBox<Object>();
		cbEstacao.setBounds(170, 150, 300, 60);
		cbEstacao.setBackground(new Color(196, 217, 237));
		cbEstacao.setForeground(new Color(0, 102, 153));
		cbEstacao.setFont(new Font(cbEstacao.getFont().getName(), cbEstacao.getFont().getStyle(), 18));
		cbEstacao.setFocusable(false);
		cbEstacao.setBorder(null);
		//EstacaoDAO dao = new EstacaoDAO();
		//for(Estacao c: dao.obterTodos()) {
		//	cbEstacao.addItem(c);
		//}
		contentPane.add(cbEstacao);
		
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
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(60, 350, 200, 60);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 25));
		btnCancelar.setBackground(new Color(85, 96, 125));
		btnCancelar.setForeground(Color.white);
		btnCancelar.setOpaque(true);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setFocusPainted(false);
		contentPane.add(btnCancelar);
>>>>>>> refs/remotes/origin/master
		
		//Event Listener
		
		setButtonProx(contentPane).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		setButtonCancel(contentPane).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				backPane.show();
			}
		});
		
		return contentPane;
		
	}

}
