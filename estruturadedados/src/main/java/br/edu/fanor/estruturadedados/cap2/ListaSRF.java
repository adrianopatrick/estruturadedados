package br.edu.fanor.estruturadedados.cap2;

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

	private void validaEspacoLivre() {
		if (index >= elementos.length) {
			throw new StackOverflowError("Sem espaço, lista totalmente preenchida.");
		}
	}

	private void validaIndice(int index) {
		if (index < 0 || index >= elementos.length) {
			throw new ArrayIndexOutOfBoundsException("Índice: " + index + ", Tamanho:: " + elementos.length);
		}
	}
	
}
