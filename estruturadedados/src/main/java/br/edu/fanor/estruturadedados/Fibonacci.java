package br.edu.fanor.estruturadedados;

/**
 * Classe que realiza o calculo do n-ésimo termo da série de fibonacci, 
 * baseado em: 
 * (n == 0 ou n == 1) ? n : fib(n-2) + fib(n-1) 
 * 
 * @author patrick.cunha
 * @since aula do dia 12/02/2016
 */
public class Fibonacci {
	
	/**
	 * método que realiza o cálculo do n-ésimo termo de fibonacci
	 * @param n - índice do n-ésimo termo da série
	 * @return valor do n-ésimo termo 
	 * */
	public static int fibonacci(int n){
		if(n == 0 || n == 1){ //caso base
			return n;
		} else { //caso recursivo
			return fibonacci(n - 2) + fibonacci(n - 1);
		}
	}

}
