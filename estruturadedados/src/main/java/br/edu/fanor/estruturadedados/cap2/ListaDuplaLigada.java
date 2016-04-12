package br.edu.fanor.estruturadedados.cap2;

/**
 * @author adrianopatrick@gmail.com
 * @since 30 de mar de 2016
 */
public class ListaDuplaLigada<E> implements Lista<E>{

	private No<E> primeiro;
	private No<E> ultimo;
	private int tamanho;
	
	/* (non-Javadoc)
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

	/* (non-Javadoc)
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#add(int, java.lang.Object)
	 */
	@Override
	public void add(int i, E e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#get(int)
	 */
	@Override
	public Object get(int i) {
//		validaIndice(i);
		No<E> atual = primeiro;
//		for (int i = 0; i < i; i++) {
//			atual = atual.proximo;
//		}
		return atual.elemento;
	}

	private No<E> getNo(int index) {
//		validaIndice(index);
		No<E> atual = primeiro;
		for (int i = 0; i < index; i++) {
			atual = atual.proximo;
		}
		return atual;
	}


	/* (non-Javadoc)
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#remove(int)
	 */
	@Override
	public Object remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object obj) {
		// TODO Auto-generated method stub
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
