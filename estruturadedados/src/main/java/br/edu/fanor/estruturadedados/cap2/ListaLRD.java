
package br.edu.fanor.estruturadedados.cap2;

/**
 * Algoritmo que implementa uma Lista Ligada ou Simplesmente Encadeada
 * Caracteristicas: - Rapida - Permite repetidos - Tamanho Dinâmico - Nao
 * Thread-Safe
 * LRD - Ligada com repetição e dinâmica.
 * 
 * @author adrianopatrick@gmail.com
 * @since 29 de fev de 2016
 */
public class ListaLRD<E> implements Lista<E> {

	private No<E> primeiro;
	private No<E> ultimo;
	private int tamanho;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#add(java.lang.Object)
	 */
	@Override
	public void add(E e) {
		No<E> novo = new No<>(e);
		if (this.tamanho == 0) {
			primeiro = novo;
		} else {
			ultimo.proximo = novo;
		}
		ultimo = novo;
		tamanho++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, E e) {
		validaIndice(index);
		No<E> novo = new No<>(e);
		if (index == 0) {
			novo.proximo = this.primeiro;
			this.primeiro = novo;
			if (this.tamanho == 0) {
				this.ultimo = this.primeiro;
			}
		} else if (index == this.tamanho) {
			this.add(e);
		} else {
			No<E> anterior = this.getNo(index - 1);
			novo.proximo = anterior.proximo;
			anterior.proximo = novo;
		}
		this.tamanho++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#size()
	 */
	@Override
	public int size() {
		return this.tamanho;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#get(int)
	 */
	@Override
	public Object get(int index) {
		validaIndice(index);
		No<E> atual = primeiro;
		for (int i = 0; i < index; i++) {
			atual = atual.proximo;
		}
		return atual.elemento;
	}

	private No<E> getNo(int index) {
		validaIndice(index);
		No<E> atual = primeiro;
		for (int i = 0; i < index; i++) {
			atual = atual.proximo;
		}
		return atual;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.tamanho == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(E e) {
		No<E> atual = primeiro;
		for (int i = 0; i < this.tamanho; i++) {
			if (atual.elemento.equals(e)) {
				return true;
			}
			atual = atual.proximo;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#remove(int)
	 */
	@Override
	public Object remove(int i) {
		validaIndice(i);
		No<E> excluido = null;
		if (i == 0) {
			excluido = primeiro;
			this.primeiro = this.primeiro.proximo;
			if (this.tamanho == 1) {
				this.ultimo = this.primeiro;
			}
		} else if (i == this.tamanho - 1) {
			excluido = this.ultimo;
			No<E> anterior = this.getNo(i - 1);
			anterior.proximo = null;
			this.ultimo = anterior;
		} else {
			No<E> anterior = this.getNo(i - 1);
			excluido = anterior.proximo;
			anterior.proximo = excluido.proximo;
		}
		this.tamanho--;
		return excluido;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object obj) {
		No<E> atual = primeiro;
		No<E> anterior = null;
		for (int i = 0; i < this.tamanho; i++) {
			if (atual.elemento.equals(obj)) {
				if (anterior != null) {
					anterior.proximo = atual.proximo;
					if (anterior.proximo == null) {
						this.ultimo = anterior;
					}
				} else {
					this.primeiro = this.primeiro.proximo;
					if (this.primeiro == null) {
						this.ultimo = null;
					}
				}
				this.tamanho--;
				return true;
			}
			anterior = atual;
			atual = atual.proximo;
		}
		return false;
	}

	private void validaIndice(int i) {
		if (i < 0 && i >= this.tamanho) {
			throw new ArrayIndexOutOfBoundsException(
					"Índice: " + i + ", Tamanho:: " + this.tamanho);
		}
	}

	private static class No<T> {

		private Object elemento;
		private No<T> proximo;

		/**
		 * @param elemento
		 */
		public No(Object elemento) {
			this.elemento = elemento;
		}
	}

}
