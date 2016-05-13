package br.edu.fanor.estruturadedados;

import org.junit.Test;

import br.edu.fanor.estruturadedados.cap3.ArvoreBinaria;

/**
 * @author adrianopatrick@gmail.com
 * @since 6 de mai de 2016
 */
public class TestArvoreBinaria {

	@Test
	public void testAltura() {
		ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>(
				(i1, i2) -> ((Integer) i1).compareTo((Integer) i2));
		
		arvore.inserir(10);
		arvore.inserir(8);
		arvore.inserir(30);
		arvore.inserir(6);
		arvore.inserir(50);

		System.out.println(arvore.getAltura());
	}

}
