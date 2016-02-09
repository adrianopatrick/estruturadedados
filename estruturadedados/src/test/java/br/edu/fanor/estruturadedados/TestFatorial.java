package br.edu.fanor.estruturadedados;

import org.junit.Assert;
import org.junit.Test;

public class TestFatorial {

	@Test
	public void testFatorialZero(){
		int resultado = Fatorial.fatorial(0);
		Assert.assertEquals(1, resultado);
	}
	
	@Test
	public void testFatorialDiferenteDeZero(){
		int resultado = Fatorial.fatorial(4);
		Assert.assertEquals(24, resultado);
	}
}
