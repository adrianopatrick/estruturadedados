package br.edu.fanor.estruturadedados;

import org.junit.Assert;
import org.junit.Test;

import br.edu.fanor.estruturadedados.cap1.Fibonacci;

public class TestFibonacci {

	@Test
	public void testTermoZeroFibonacci(){
		int valorTermo = Fibonacci.fibonacci(0);
		Assert.assertEquals(0, valorTermo);
	}
	
	@Test
	public void testTermoUmFibonacci(){
		int valorTermo = Fibonacci.fibonacci(1);
		Assert.assertEquals(1, valorTermo);
	}
	
	@Test
	public void testTermoDoisFibonacci(){
		int valorTermo = Fibonacci.fibonacci(1);
		Assert.assertEquals(1, valorTermo);
	}
	
	@Test
	public void testTermoNFibonacci(){
		int valorTermo = Fibonacci.fibonacci(7);
		Assert.assertEquals(13, valorTermo);
	}
}
