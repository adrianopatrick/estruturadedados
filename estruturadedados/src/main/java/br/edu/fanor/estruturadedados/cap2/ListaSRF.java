package br.edu.fanor.estruturadedados.cap2;

/**
 * Algoritmo que implementa uma Lista simples
 * Características:
 * 	- Rápida
 * 	- Permite repetidos
 * 	- Tamanho Fixo
 *  - Não é Thread-Safe
 * 
 * @author patrick.cunha
 * @since 19/02/2016
 * */
public class ListaSRF implements Lista {

	private Object[] objetos = new Object[100];
	private int index = 0;
	
	@Override
	public void add(Object obj) {
		objetos[index] = obj;
		index++;
	}

	@Override
	public void add(int i, Object obj) {
		if(i < objetos.length){
			if(existeExpacoLivre()){
				if(objetos[i] != null){
					for (int j = index; j > i; j--) {
						objetos[j] = objetos[j - 1];
					}
				}
				objetos[i] = obj; 
			} else {
				throw new StackOverflowError("Sem espaço, lista totalmente preenchida.");
			}
		} else {
			throw new ArrayIndexOutOfBoundsException("índice maior que o tamanho da lista.");
		}
	}

	@Override
	public int size() {
		return index;
	}

	@Override
	public Object get(int i) {
		if(i < objetos.length){
			return objetos[i];
		} else {
			throw new ArrayIndexOutOfBoundsException("índice maior que o tamanho da lista.");
		}
		
	}
	
	private boolean existeExpacoLivre(){
		return (index == objetos.length) ? false : true;
	}
	
}
