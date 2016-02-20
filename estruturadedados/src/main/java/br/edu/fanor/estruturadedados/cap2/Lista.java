package br.edu.fanor.estruturadedados.cap2;

public interface Lista {
	
	/**Método que adiciona um objeto ao final da lista
	 * @param obj a ser adicionado
	 * @return void
	 * */
	void add(Object obj);
	
	/**Método que adiciona um objeto numa posição específica
	 * @param i indice do vetor onde o obj deve ser adicionado
	 * @param obj a ser adicionado
	 * @return void
	 * */
	void add(int i, Object obj);
	
	/**Método que retorna o número de elementos
	 * dentro da lista.
	 * @return qtda itens da lista
	 * */
	int size();
	
	/**Método que retorna o objeto da lista que
	 * está armazenado no índice i
	 * @param i índice do obj a ser retornado
	 * @return obj armazenado no índice i
	 * */
	Object get(int i);

}
