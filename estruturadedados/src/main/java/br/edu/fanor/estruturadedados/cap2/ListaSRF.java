package br.edu.fanor.estruturadedados.cap2;

import br.edu.fanor.estruturadedados.cap1.BuscaLinear;

/**
 * Algoritmo que implementa uma Lista simples Caracteristicas: - Rapida -
 * Permite repetidos - Tamanho Fixo - Nao Thread-Safe
 * 
 * @author patrick.cunha
 * @since 19/02/2016
 */
public class ListaSRF<E> implements Lista<E> {

	private Object[] elementos = new Object[100];
	private int index = 0;

	@Override
	public void add(E e) {
		validaEspacoLivre();
		elementos[index++] = e;
	}

	@Override
	public void add(int i, E e) {
		validaIndice(i);
		validaEspacoLivre();
		if (elementos[i] != null) {
			for (int j = index; j > i; j--) {
				elementos[j] = elementos[j - 1];
			}
		}
		elementos[i] = e;
		index++;

	}

	@SuppressWarnings("unchecked")
	public E remove(int i) {
		validaIndice(i);
		E antigoElemento = (E) elementos[i];
		for (int j = i; j < index; j++) {
			elementos[i] = elementos[i + 1];
		}
		
		return antigoElemento;
	}

	@Override
	public int size() {
		return index;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E get(int i) {
		validaIndice(i);
		return (E) elementos[i];
	}

	@Override
	public boolean isEmpty() {
		return index == 0;
	}

	@Override
	public boolean contains(E e) {
		return BuscaLinear.buscar(elementos, e) != null;
	}

	@SuppressWarnings("unchecked")
	public E remove(int i) {
		validaIndice(i);
		
		E elementoRemovido = (E) elementos[i];
		for (int j = i; j < size() - 1; j++) {
			elementos[j] = elementos[j + 1];
		}
		elementos[--index] = null;
		
		return elementoRemovido;
	}
	
	@Override
	public boolean remove(E e){
		Integer i = BuscaLinear.buscar(elementos, e);
		if(i != null){
			remove(i);
			return true;
		} else {
			return false;
		}
	}

	private void validaEspacoLivre() {
		if (index >= elementos.length) {
			throw new StackOverflowError(
					"Sem espaço, lista totalmente preenchida.");
		}
	}

	private void validaIndice(int index) {
		if (index < 0 || index >= elementos.length) {
			throw new ArrayIndexOutOfBoundsException(
					"Índice: " + index + ", Tamanho:: " + elementos.length);
		}
	}

}
