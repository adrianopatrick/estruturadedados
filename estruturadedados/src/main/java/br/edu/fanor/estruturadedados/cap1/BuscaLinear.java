package br.edu.fanor.estruturadedados.cap1;

/**
 * Código que realiza a busca linear Complexidade: O(n)
 * 
 * @since 05/02/2016
 * @author patrick.cunha
 */
public class BuscaLinear {

	/**
	 * Método que realiza a busca linear
	 * 
	 * @param vetor de inteiros
	 * @param chave de busca
	 * @return índice onde a chave de busca foi encontrada
	 */
	public static Integer buscar(Object[] vetor, Object chave) {
		if (chave != null) {
			for (int i = 0; i < vetor.length; i++) {
				if (chave.equals(vetor[i])) {
					return i;
				}
			}
		}
		return null;
	}
}
