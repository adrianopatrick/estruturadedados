package br.edu.fanor.estruturadedados.cap2;

/**
 * LIFO - Last IN, First OUT
 * @author adrianopatrick@gmail.com
 * @since 12 de abr de 2016
 */
public class Pilha<E> {
	private Lista<E> lista = new ListaDuplaLigada<>();

	/** Insere sempre no final */
	public void push(E e) {
		lista.add(e);
	}

	/** Remove sempre do final*/
	public Object pop() {
		return lista.remove(lista.size() - 1);
	}
}
