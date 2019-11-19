package br.edu.udc.fila;

import java.util.Iterator;

import br.edu.udc.colecao.IteradorAbstrato;

public class Fila<E> implements Iterable<E> {
	
	/* Classe privativa NoLista */

	private class NoLista {
		NoLista proximo;
		NoLista anterior;
		E obj;

		/* Construtores */

		NoLista(){
			this.proximo = null;
			this.anterior = null;
			this.obj = null;
		}

		NoLista(E obj){
			this.proximo = null;
			this.anterior = null;
			this.obj = obj;
		}

		@SuppressWarnings("unused")
		NoLista(NoLista proximo, NoLista anterior, E obj){
			this.proximo = proximo;
			this.anterior = anterior;
			this.obj = obj;
		}
	}

	/* Classe privativa Iterador */

	private class Iterador implements IteradorAbstrato<E> {
		private NoLista noAtual;

		Iterador(NoLista no) {
			noAtual = no;
		}

		@Override
		public boolean proximo() {
			if(noAtual == null)
				return false;

			noAtual = noAtual.proximo;
			return true;
		}

		@Override
		public boolean anterior() {
			if(noAtual == null)
				return false;

			noAtual = noAtual.anterior;
			return true;
		}

		@Override
		public E dadoAtual() {
			if(noAtual == null)
				return null;
			return noAtual.obj;
		}

	}

	/* Classe privativa derivada do Collection */

	private class IteradorJava implements Iterator<E> {
		private NoLista noAtual;
		private NoLista noAnterior;

		IteradorJava(NoLista no) {
			noAtual = no;
			noAnterior = new NoLista();
			noAnterior.proximo = no;
		}

		@Override
		public boolean hasNext(){
			if(noAtual.proximo == null)
				return false;

			return true;
		}

		@Override
		public E next(){
			if(noAtual.proximo == null){
				if (noAnterior.proximo == null)
					return null;

				else 
					noAtual = noAnterior.proximo;
			}

			else {
				noAnterior = noAtual;
				noAtual = noAtual.proximo;
			}
			
			return noAtual.obj;
		}

		@Override
		public void remove(){
			if (noAtual != null){
				noAnterior.proximo = noAtual.proximo;

				noAtual.proximo.anterior = noAtual.anterior;
				noAtual.anterior.proximo = noAtual.proximo;

				noAtual = null;
			}
		}

	}

	/* Objetos */

	NoLista inicio;
	NoLista fim;

	int tamanho;

	/* Construtores */

	public Fila() {
		inicio = null;
		fim = null;

		tamanho = 0;
	}

	/* Getters e Setters */

	public int getTamanho() { return tamanho; }

	/* Métodos */

	public boolean isVazia() { 
		/* Verificação de existência de nós na lista */
		if (tamanho == 0) return true;
		else return false;
	}

	public IteradorAbstrato<E> getIteradorInicio() {
		Iterador it = new Iterador(inicio);
		return it;
	}
	
	public IteradorAbstrato<E> getIteradorFim() {
		return new Iterador(fim);
	}

	public Iterator<E> iterator(){
		return new IteradorJava(inicio);
	}

	public boolean inserir(E obj) {

		NoLista n = new NoLista(obj);
		
		/* Primeira inserção */
		if (tamanho == 0) { 

			inicio = n;
			fim = n;

			tamanho++;
			return true;
		}

		/* Inserção no fim da fila */
		else { 

			n.anterior = fim;
			fim.proximo = n;
			fim = n;

			tamanho++;
			return true;
		}

	}

	public E remover() {

		/* Remoção em lista vazia */
		if (tamanho == 0)
			return null;

		/* Busca pela posição do objeto específico */
		else { 
			NoLista it = inicio;
			
			inicio = inicio.proximo;
			inicio.anterior = null;
					
			return it.obj;
		}

	}
}
