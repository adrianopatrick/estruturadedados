package br.edu.fanor.estruturadedados.cap1;

/**
 * Classe que resolve o problema da torre de Hanoi
 * 
 * @author patrick.cunha
 * @since aula do dia 12/02/2016
 */
public class Hanoi {

	/**
	 * Metodo que resolve a torre de hanoi pra n discos.
	 * 
	 * @param n - numero de discos
	 * @param origem - primeira torre
	 * @param auxiliar - segunda torre
	 * @param destino - terceira torre
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
