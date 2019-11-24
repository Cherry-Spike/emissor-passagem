package br.unip.team.emissopassagem.view.tela;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unip.team.emissopassagem.controller.PassagemController;
import br.unip.team.emissopassagem.model.entidade.PassagemValueObject;

public class TelaEmissao extends Tela<Object>  {
	private PassagemController passagemController = new PassagemController();
	private int idPassgem;
	private JTextField tfEmbarque, tfDesembarque, tfHorario, tfSerial;
	
	public TelaEmissao(JPanel basePane, JPanel backPane, int idPassagem) {
		this.idPassagem = idPassagem;
		setBasePane(basePane);
		setBackPane(backPane);
		setNewPane(window(), basePane);
	}

	public JPanel window() {

		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		
		PassagemValueObject passagem = passagemController.obterPassagemPorId(idPassgem);
		
		//Imagens
		
		ImageIcon imgLogo = new ImageIcon(getClass().getResource("..\\assets\\logo-sntf.jpg"));		
		JLabel logoSNTF = new JLabel(imgLogo);
		logoSNTF.setBounds(0, 30, 263, 180);
		contentPane.add(logoSNTF);
		
		ImageIcon qrc = new ImageIcon(getClass().getResource("..\\assets\\QRCode.jpg"));		
		JLabel qrCode = new JLabel(qrc);
		qrCode.setBounds(390, 280, 127, 128);
		contentPane.add(qrCode);
		
		//Dados do bilhete
		
		setLabel(contentPane, "Embarque", 310, 20, 150, 30, 15);
		tfEmbarque = setTextField(contentPane, 310, 50, 280, 35);		
		setLabel(contentPane, "Desembarque", 310, 100, 150, 30, 15);
		tfDesembarque = setTextField(contentPane, 310, 130, 280, 35);		
		setLabel(contentPane, "Horario", 310, 180, 150, 30, 15);
		tfHorario = setTextField(contentPane, 310, 210, 280, 35);		
		tfSerial = setTextField(contentPane, 410, 410, 100, 25);
		
		setPassagemTxt(tfEmbarque, tfDesembarque, tfHorario, tfSerial, passagem);
		tfSerial.setFont(new Font(tfSerial.getFont().getName(), tfSerial.getFont().getStyle(), 12));
		
		//Event Listener
		
		setButtonCancel(contentPane).addActionListener(e -> {
			contentPane.setVisible(false);
			backPane.setVisible(true);
		});

		return contentPane;
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
	
	public JTextField setTextField(JPanel contentPane, int x, int y, int l, int a) {

		JTextField txt = new JTextField(10);
		txt.setBounds(x, y, l, a);
		txt.getFont();
		txt.setFont(new Font(txt.getFont().getName(), Font.BOLD, 24));
		txt.setBorder(null);
		txt.setBackground(null);
		txt.setEditable(false);
		contentPane.add(txt);

		return txt;
	}
	
	public JLabel setLabel(JPanel contentPane, String str, int x, int y, int l, int a, int size) {

		JLabel lb = new JLabel(str);
		lb.setBounds(x, y, l, a);
		lb.getFont();
		lb.setFont(new Font("Arial", Font.PLAIN, size));
		contentPane.add(lb);

		return lb;
	}
	
	public void setPassagemTxt(JTextField embarque, JTextField desembarque, JTextField horario, JTextField serial, PassagemValueObject p) {
		embarque.setText(p.getEstacaoEmbarque());
		desembarque.setText(p.getEstacaoDesembarque());
		horario.setText(p.getHorarioEmbarque());
		serial.setText(String.valueOf(p.getNumero()));
	}

}
