package br.edu.fanor.estruturadedados.cap2;

/**
 * @author adrianopatrick@gmail.com
 * @since 29 de fev de 2016
 */
public class No {

	private Object elemento;
	private No proximo;
	
	/**
	 * @param elemento
	 * @param proximo
	 */
	public No(Object elemento) {
		this.elemento = elemento;
	}

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	
}
