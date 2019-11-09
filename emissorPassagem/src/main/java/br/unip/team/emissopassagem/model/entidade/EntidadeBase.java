package br.unip.team.emissopassagem.model.entidade;

public abstract class EntidadeBase {
	private int id;

	protected EntidadeBase(int id) {
		setId(id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
