package br.edu.fanor.estruturadedados;

/**
 * Classe que resolve o problema da torre de Hanoi
 * 
 * @author patrick.cunha
 * @since aula do dia 12/02/2016
 */
public class Hanoi {

	/**
	 * Método que resolve a torre de hanoi pra n discos.
	 * 
	 * @param numero de discos(n), apelido para as torres de origem, auxiliar e destino
	 * */
	public static void hanoi(int n, char origem, char auxiliar, char destino) {
		if (n == 1) {
			System.out.println("Mova disco 1 da torre " + origem + ", para " + destino);
		} else {
			hanoi(n - 1, origem, destino, auxiliar);
			System.out.println("Mova disco " + n + " da torre " + origem + ", para " + destino);
			hanoi(n - 1, auxiliar, origem, destino);
		}
	}
}
