package br.edu.udc.colecao;

public interface IteradorAbstrato<E> {
	public boolean proximo();
	public boolean anterior();
	public E dadoAtual();
}