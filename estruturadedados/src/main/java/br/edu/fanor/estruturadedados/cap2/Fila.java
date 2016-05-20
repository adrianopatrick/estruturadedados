package br.edu.fanor.estruturadedados.cap2;

/**
 * FIFO - First IN, First OUT
 * @author adrianopatrick@gmail.com
 * @since 12 de abr de 2016
 */
public class Fila<E> {
	
	private Lista<E> lista = new ListaDuplaLigada<>();

	/** Insere sempre no final */
	public void queue(E e){
		lista.add(e);
	}
	
	/** Remove sempre do início */
	public Object dequeue(){
		return lista.remove(0);
	}
	
	public int size(){
		return lista.size();
	}
	
	public Lista<E> getLista() {
		return lista;
	}
}
