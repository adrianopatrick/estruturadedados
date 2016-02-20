package br.edu.fanor.estruturadedados;

import org.junit.Assert;
import org.junit.Test;

import br.edu.fanor.estruturadedados.cap1.Fatorial;

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
