package br.unip.team.emissopassagem.model.entidade;

import java.util.logging.Logger;

public enum EstacaoPosicao {
	PRIMEIRA("Philadelphia"), SEGUNDA("Pennsauken"), TERCEIRA("Lindenwold"), QUARTA("Atco"), QUINTA("Egg Harbor City"),
	SEXTA("Atlantic City");
	private static final Logger LOGGER = Logger.getLogger(EstacaoPosicao.class.getName());
	private String nome;

	EstacaoPosicao(String nome) {
		setNome(nome);
	}

	public static int obterPosicaoEstacao(String nome) {
		for (EstacaoPosicao estacaoPos : EstacaoPosicao.values()) {
			if (estacaoPos.getNome().equals(nome))
				return estacaoPos.ordinal();
		}
		LOGGER.info("Posição da estação não encontrada.");
		return -1;
	}
	
	public static int calcularSentido(int posicaoEstacaoEmb, int posicaoEstacaoDesem) {
		if (posicaoEstacaoEmb - posicaoEstacaoDesem < 0) {
			return 2;
		}
		return 1;
	}

	public static int calcularTotalEstacaoPercorrida(int posicaoEstacaoEmb, int posicaoEstacaoDesem) {
		return posicaoEstacaoEmb - posicaoEstacaoDesem;
	}

	public String getNome() {
		return nome;
	}

	void setNome(String nome) {
		this.nome = nome;
	}
}
