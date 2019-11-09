package br.unip.team.emissopassagem.model.interfaces;

import java.util.List;

public interface BaseDAO<E> {
	public E obterPorId(int id);
	public List<E> obterTodos();
	public boolean adicionar(E obj);
	public Object alterar(E obj);
	public boolean remover(int id);
}
