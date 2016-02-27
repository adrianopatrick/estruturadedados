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
	
	/**Metodo que retorna true caso a lista esteja vazia
	 * e false caso tenha pelo menos 1 elemento.
	 * @return <tt>true</tt> para lista vazia
	 * */
	boolean isEmpty();
	
	/**Metodo que retorna <tt>true</tt> caso a lista contenha 
	 * um elemento específico.
	 * @param e, o elemento a ser buscado.
	 * @return se encontrou o elemento
	 * */
	boolean contains(E e);
	
	/**Metodo que remove um elemento do array
	 * de uma posição especificada(i)
	 * @param i indice do elemento a ser removido
	 * @return E elemento removido da lista
	 * @throws ArrayIndexOutOfBoundsException {@inheritDoc}}
	 * */
	E remove(int i);
	
	/**Metodo que remove um elemento do array
	 * @param e elemento a ser removido
	 * @return <tt>true</tt> se o elemento foi encontrado na lista
	 * */
	boolean remove(E e);

}
