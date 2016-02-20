package br.edu.fanor.estruturadedados.cap1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Código que realiza a busca binária Complexidade: O(lg n)
 * 
 * @since 05/02/2016
 * @author patrick.cunha
 */
public class BuscaBinaria {

	/**
	 * Método que realiza a busca binária, garantindo
	 * que o vetor de entrada esteja ordenado.
	 * 
	 * @param vetor de inteiros
	 * @param chave de busca
	 * @return índice onde a chave de busca foi encontrada
	 */
	public static Integer buscar(Object[] vetor, Object chave, boolean isOrdenado, Comparator<Object> comparator) {
		//se entrar no if, a complexidade será acrescida da complexidade
		//de ordenação o array.
		if(!isOrdenado){
			Arrays.sort(vetor, comparator);
		}
		return buscar(vetor, 0, vetor.length - 1, chave, comparator);
	}

	/**
	 * Método que realiza a busca binária recursiva
	 * Complexidade: O(lgn)
	 * 
	 * @param vetor de inteiros
	 * @param inicio da lista a ser considerado
	 * @param final da lista a ser considerado.
	 * @param chave de busca
	 * @param comparator base para busca
	 * @return indice onde a chave de busca foi encontrada.
	 * */
	private static Integer buscar(Object[] vetor, int inicio, int fim, Object chave, Comparator<Object> comparator) {
		if(fim < inicio){
			return null;
		} else {
			int media = (inicio + fim) / 2;
			if(vetor[media].equals(chave)){
				return media;
			} else if (comparator.compare(vetor[media],chave) > 0){
				return buscar(vetor, inicio, media - 1, chave, comparator);
			} else {
				return buscar(vetor, media + 1, fim, chave, comparator);
			}
		}
	}
	
}
