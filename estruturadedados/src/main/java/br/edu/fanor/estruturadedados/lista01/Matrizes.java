package br.edu.fanor.estruturadedados.lista01;

/**
 * Classe que apresenta a solução para os exercícios 01, 02 e 03 da lista 01 da
 * disciplina de estrutura de dados
 * 
 * @author adrianopatrick@gmail.com
 * @since 15 de mar de 2016
 */
public class Matrizes {

	/**
	 * Lista 01 - Questão 01 - Soma de Matrizes
	 * 
	 * Matemática: Dada duas matrizes, A e B, as duas de ordem m x n. Então, A +
	 * B = C, com C de ordem m x n ↔ a11 + b11 = c11.
	 * 
	 * Complexidade: O(n^2)
	 * 
	 * @throws Exception
	 */
	public void somaMatrizes(int[][] a, int[][] b) throws Exception {
		if (validaSomaMatrizes(a, b)) {
			int[][] c = new int[a.length][a[0].length];
			for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[0].length; j++) {
					c[i][j] = a[i][j] + b[i][j];
				}
			}
		} else {
			throw new Exception(
					"Não possível a soma de duas matrizes de ordem diferentes.");
		}
	}

	/**
	 * Lista 01 - Questão 02 - Produto de Matrizes
	 * 
	 * Matemática: o número de colunas da 1ª matriz deve ser igual ao número de
	 * linhas da 2ª matriz.
	 * 
	 * Complexidade: O(n^3)
	 * 
	 * @throws Exception
	 */
	public void produtoMatrizes(int[][] a, int[][] b) throws Exception {
		if (validaProdutoMatrizes(a, b)) {
			int[][] c = new int[a.length][b[0].length];
			for (int i = 0; i < c.length; i++) {
				for (int j = 0; j < c[0].length; j++) {
					c[i][j] = 0;
					for (int k = 0; k < c.length; k++) {
						c[i][j] = c[i][j] + a[i][k] + b[k][j];
					}
				}
			}
		} else {
			throw new Exception(
					"Não possível o produto de duas matrizes de ordem diferentes.");
		}
	}

	/**
	 * Valida se soma é possível: o número de colunas da 1ª matriz deve ser
	 * igual ao número de linhas da 2ª matriz.
	 */
	private boolean validaProdutoMatrizes(int[][] a, int[][] b) {
		if (validaColunas(a) && validaColunas(b)) {
			if (a[0].length == b.length) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Valida se soma é possível: Dada duas matrizes, A e B, as duas de ordem m
	 * x n. Então, A + B = C, com C de ordem m x n ↔ a11 + b11 = c11.
	 */
	private boolean validaSomaMatrizes(int[][] a, int[][] b) {
		if (validaColunas(a) && validaColunas(b)) {
			if (a.length == b.length && a[0].length == b[0].length) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Valida se todas as colunas possuem o mesmo tamanho
	 * 
	 * @param matriz
	 *            x
	 */
	private boolean validaColunas(int[][] x) {
		for (int i = 0; i < x.length - 1; i++) {
			if (x[i].length != x[i + 1].length) {
				return false;
			}
		}
		return true;
	}

}
