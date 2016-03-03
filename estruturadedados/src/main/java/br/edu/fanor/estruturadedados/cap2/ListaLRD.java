package br.edu.fanor.estruturadedados.cap2;

/**
 * Algoritmo que implementa uma Lista Ligada ou Simplesmente Encadeada
 * Caracteristicas: - Rapida - Permite repetidos - Tamanho Dinâmico - Nao
 * Thread-Safe
 * 
 * 
 * @author adrianopatrick@gmail.com
 * @since 29 de fev de 2016
 */
public class ListaLRD<E> implements Lista<E> {

	private No primeiro;
	private No ultimo;
	private int tamanho;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.fanor.estruturadedados.cap2.Lista#add(java.lang.Object)
	 */
	@Override
	public void add(E e) {
		No novo = new No(e);
		if (this.tamanho == 0) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
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
		No novo = new No(e);
		if (index == 0) {
			novo.setProximo(this.primeiro);
			this.primeiro = novo;
			if (this.tamanho == 0) {
				this.ultimo = this.primeiro;
			}
		} else if (index == this.tamanho) {
			this.add(e);
		} else {
			No anterior = this.getNo(index - 1);
			novo.setProximo(anterior.getProximo());
			anterior.setProximo(novo);
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
		No atual = primeiro;
		for (int i = 0; i < index; i++) {
			atual = atual.getProximo();
		}
		return atual.getElemento();
	}
	
	private No getNo(int index) {
		validaIndice(index);
		No atual = primeiro;
		for (int i = 0; i < index; i++) {
			atual = atual.getProximo();
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
		No atual = primeiro;
		for (int i = 0; i < this.tamanho; i++) {
			if (atual.getElemento().equals(e)) {
				return true;
			}
			atual = atual.getProximo();
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
		No excluido = null;
		if (i == 0) {
			excluido = primeiro;
			this.primeiro = this.primeiro.getProximo();
			if (this.tamanho == 1) {
				this.ultimo = this.primeiro;
			}
		} else if (i == this.tamanho - 1) {
			excluido = this.ultimo;
			No anterior = this.getNo(i - 1);
			anterior.setProximo(null);
			this.ultimo = anterior;
		} else {
			No anterior = this.getNo(i - 1);
			excluido = anterior.getProximo();
			anterior.setProximo(excluido.getProximo());
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
		No atual = primeiro;
		No anterior = null;
		for (int i = 0; i < this.tamanho; i++) {
			if (atual.getElemento().equals(obj)) {
				if (anterior != null) {
					anterior.setProximo(atual.getProximo());
					if(anterior.getProximo() == null){
						this.ultimo = anterior;
					}
				} else {
					this.primeiro = this.primeiro.getProximo();
					if(this.primeiro == null){
						this.ultimo = null;
					}
				}
				this.tamanho--;
				return true;
			}
			anterior = atual;
			atual = atual.getProximo();
		}
		return false;
	}

	private void validaIndice(int i) {
		if (i < 0 && i >= this.tamanho) {
			throw new ArrayIndexOutOfBoundsException(
					"Índice: " + i + ", Tamanho:: " + this.tamanho);
		}
	}

}
