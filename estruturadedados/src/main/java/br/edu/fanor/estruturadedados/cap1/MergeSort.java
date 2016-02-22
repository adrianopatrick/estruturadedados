package br.edu.fanor.estruturadedados.cap1;

/**
 * Algoritmo de Ordenação por Intercalação O(nlgn)
 * realiza a ordenação de forma não local,
 * pois precisa de vetores auxiliares para a tarefa
 * Cap. 07 - Estrutura de Dados e seus algoritmos
 * 
 * @author patrick.cunha
 * */
public class MergeSort {

	public static int[] mergeSort(int[] vetor, int p, int r) {

		//caso recursivo
		if (p < r) {
			//calcula o pivo
			int q = (p + r) / 2;
			
			//sai dividindo o vetor inicial
			//primeiro pela esquerda, depois pela direita
			mergeSort(vetor, p, q);
			mergeSort(vetor, q + 1, r);
			//realiza o merge
			return merge(vetor, p, q, r);
		} else { //caso base
			return null;
		}
	}

	private static int[] merge(int[] vetor, int p, int q, int r) {
		//define o tamanho dos subvetores
		int n1 = q - p + 1;
		int n2 = r - q;
		//cria os vetores auxiliares,
		//adicionando o espaço do max_int
		int[] left = new int[n1 + 1];
		int[] right = new int[n2 + 1];
		//preenche os vetores
		for (int i = 0; i < left.length - 1; i++) {
			left[i] = vetor[p + i];
		}
		for (int i = 0; i < right.length - 1; i++) {
			right[i] = vetor[q + i + 1];
		}
		//adiciona o max_int
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;

		//realiza o merge propriamente dito
		int i = 0, j = 0;
		for (int k = p; k <= r; k++) {
			if(left[i] <= right[j]){
				vetor[k] = left[i];
				i++;
			} else {
				vetor[k] = right[j];
				j++;
			}
		}
		
		return vetor;
	}
}
