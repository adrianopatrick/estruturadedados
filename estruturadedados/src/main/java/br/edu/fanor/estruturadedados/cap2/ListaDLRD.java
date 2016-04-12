package br.edu.fanor.estruturadedados.cap2;

/**
 * Algoritmo que implementa Lista Duplamente Encadeada(Ligada)
 * Caracteristicas: - Permite repetidos - Tamanho Variável - Nao Thread-Safe
 * DLRD - Duplamente Ligada, com repetidos e tamanho dinâmico
 * 
 * @author patrick.cunha
 * @since 13/03/2016
 */
public class ListaDLRD<E> implements Lista<E>{

	private No<E> primeiro;
	private No<E> ultimo;
	private int tamanho;
	
	@Override
	public void add(E e) {
		No<E> novo = new No<>(e);
		this.ultimo.proximo = novo;
		novo.anterior = this.ultimo;
		this.ultimo = novo;
		if(size() == 0){
			this.primeiro = novo;
		}
		this.tamanho++;
	}

	@Override
	public void add(int i, E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private static class No<T>{
		private Object elemento;
		private No<T> anterior;
		private No<T> proximo;
		
		/**
		 * @param elemento
		 * */
		public No(Object elemento) {
			this.elemento = elemento;
		}
	}

}
