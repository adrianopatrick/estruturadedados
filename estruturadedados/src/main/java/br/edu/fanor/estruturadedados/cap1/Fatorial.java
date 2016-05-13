package br.edu.fanor.estruturadedados.cap1;

/**
 * Classe que realiza o calculo do fatorial de forma recursiva, 
 * baseado em: 
 * 0! = 1 por definição, 
 * n! = n * (n - 1)!
 * 
 * @author patrick.cunha
 * @since aula do dia 12/02/2016
 */
public class Fatorial {

	/**
	 *  método que realiza o cálculo do fatorial
	 *  @param n - valor a ser calculado
	 *  @return resultado do fatorial de n 
	 * */
	public static int fatorial(int n) {
		if (n == 0) { // caso base
			return 1;
		} else { // caso recursivo
			return n * fatorial(n - 1);
		}
	}

}
