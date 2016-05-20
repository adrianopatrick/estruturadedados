package br.edu.fanor.estruturadedados.cap2;

/**
 * Algoritmo que implementa Lista Duplamente Encadeada(Ligada) Caracteristicas:
 * - Permite repetidos - Tamanho Variável - Nao Thread-Safe DLRD - Duplamente
 * Ligada, com repetidos e tamanho dinâmico
 * 
 * @author adrianopatrick@gmail.com
 * @since 30 de mar de 2016
 */
public class ListaDuplaLigada<E> implements Lista<E> {

	private No<E> primeiro;
	private No<E> ultimo;
	private int tamanho;

	public void addAll(ListaDuplaLigada<E> lista) {
		for (int i = 0; i < lista.size(); i++) {
			this.add(lista.getNo(i));
		}
	}

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
			novo.anterior = ultimo;
		}
		ultimo = novo;
		tamanho++;
	}
	
	public void add(No<E> novo) {
		if (this.tamanho == 0) {
			primeiro = novo;
		} else {
			ultimo.proximo = novo;
			novo.anterior = ultimo;
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
			this.primeiro.anterior = novo;
			this.primeiro = novo;
			if (this.tamanho == 0) {
				this.ultimo = this.primeiro;
			}
		} else if (index == this.size()) {
			this.add(e);
		} else {
			No<E> noAnterior = this.getNo(index - 1);
			novo.proximo = noAnterior.proximo;
			novo.anterior = noAnterior;
			noAnterior.proximo = novo;
		}
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

	private void validaIndice(int i) {
		if (i < 0 && i >= this.tamanho) {
			throw new ArrayIndexOutOfBoundsException(
					"Índice: " + i + ", Tamanho:: " + this.tamanho);
		}
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
		return this.size() == 0;
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
			this.ultimo.anterior.proximo = null;
			this.ultimo = this.ultimo.anterior;
		} else {
			excluido = this.getNo(i);
			excluido.anterior.proximo = excluido.proximo;
			excluido.proximo.anterior = excluido.anterior;
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
		for (int i = 0; i < this.tamanho; i++) {
			if (atual.elemento.equals(obj)) {
				if (atual.anterior != null) {
					atual.anterior.proximo = atual.proximo;
					atual.proximo.anterior = atual.anterior;
					if (atual.anterior.proximo == null) {
						this.ultimo = atual.anterior;
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
			atual = atual.proximo;
		}
		return false;
	}

	private static class No<T> {

		private No<T> anterior;
		private Object elemento;
		private No<T> proximo;

		/**
		 * @param elemento
		 * @param proximo
		 */
		public No(Object elemento) {
			this.elemento = elemento;
		}
	}

}
