package br.edu.fanor.estruturadedados.cap2;

public interface Lista<E> {
	
	/**Metodo que adiciona um objeto ao final da lista
	 * @param e a ser adicionado
	 * */
	void add(E e);
	
	/**Metodo que adiciona um objeto numa posição especifica
	 * @param i indice do vetor onde o obj deve ser adicionado
	 * @param e a ser adicionado
	 * */
	void add(int i, E e);
	
	/**Metodo que retorna o número de elementos
	 * dentro da lista.
	 * @return qtda itens da lista
	 * */
	int size();
	
	/**Metodo que retorna o objeto da lista que
	 * está armazenado no índice i
	 * @param i índice do obj a ser retornado
	 * @return E armazenado no índice i
	 * */
	E get(int i);

}
