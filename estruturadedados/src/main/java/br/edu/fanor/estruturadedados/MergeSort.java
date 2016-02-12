package br.edu.fanor.estruturadedados;

public class MergeSort {

	public static int[] mergeSort(int[] vetor, int p, int r) {

		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(vetor, p, q);
			mergeSort(vetor, q + 1, r);
			return merge(vetor, p, q, r);
		}
		return null;
	}

	private static int[] merge(int[] vetor, int p, int q, int r) {
		
		int n1 = q - p + 1;
		int n2 = r - q;
		
		int[] left = new int[n1 + 1];
		int[] right = new int[n2 + 1];
		
		for (int i = 0; i < left.length - 1; i++) {
			left[i] = vetor[p + i];
		}
		for (int i = 0; i < right.length - 1; i++) {
			right[i] = vetor[q + i + 1];
		}
		
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		
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
