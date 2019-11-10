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

import br.unip.team.emissopassagem.model.entidade.Cidade;
import br.unip.team.emissopassagem.model.persistencia.CidadeDAO;

public class TelaEstacaoDb extends Tela {

	public TelaEstacaoDb(JPanel basePane, JPanel backPane) {
		setBasePane(basePane);
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
		
		JComboBox<Object> cbCidade = new JComboBox<Object>();
		cbCidade.setBounds(170, 150, 300, 60);
		cbCidade.setBackground(new Color(196, 217, 237));
		cbCidade.setForeground(new Color(0, 102, 153));
		cbCidade.setFont(new Font(cbCidade.getFont().getName(), cbCidade.getFont().getStyle(), 18));
		cbCidade.setFocusable(false);
		cbCidade.setBorder(null);
		CidadeDAO dao = new CidadeDAO();
		for(Cidade c: dao.obterTodos()) {
			cbCidade.addItem(c);
		}
		contentPane.add(cbCidade);
		
		JButton btnProx = new JButton("PROXIMO");
		btnProx.setBounds(230, 335, 180, 60);
		btnProx.setEnabled(false);
		btnProx.setFont(new Font("Arial", Font.BOLD, 25));
		btnProx.setBackground(new Color(0, 153, 255));
		btnProx.setForeground(Color.white);
		btnProx.setOpaque(true);
		btnProx.setBorderPainted(false);
		btnProx.setFocusPainted(false);
		contentPane.add(btnProx);
		
		//Event Listener
		
		btnProx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		
		return contentPane;
		
	}

}
