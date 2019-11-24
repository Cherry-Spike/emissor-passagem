package br.unip.team.emissorpassagem.model.entidade;

public class Cartao extends EntidadeBase{
	private String numero;
	private int pin;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}		

}
