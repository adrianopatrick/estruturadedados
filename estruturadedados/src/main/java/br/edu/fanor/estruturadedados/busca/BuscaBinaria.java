package br.edu.fanor.estruturadedados.busca;

import java.util.Arrays;

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
	public static Integer buscar(int[] vetor, int chave, boolean isOrdenado) {
		//se entrar no if, a complexidade será acrescida da complexidade
		//de ordenação o array.
		if(!isOrdenado){
			Arrays.sort(vetor);
		}
		return buscar(vetor, 0, vetor.length - 1, chave);
	}

	/**
	 * Método que realiza a busca binária recursiva
	 * Complexidade: O(lgn)
	 * 
	 * @param vetor de inteiros
	 * @param inicio da lista a ser considerado
	 * @param final da lista a ser considerado.
	 * @param chave de busca
	 * @return indice onde a chave de busca foi encontrada.
	 * */
	public static Integer buscar(int[] vetor, int inicio, int fim, int chave) {
		if(fim < inicio){
			return null;
		} else {
			int media = (inicio + fim) / 2;
			if(vetor[media] == chave){
				return media;
			} else if (vetor[media] > chave){
				return buscar(vetor, inicio, media - 1, chave);
			} else {
				return buscar(vetor, media + 1, fim, chave);
			}
		}
	}
}
