package br.edu.fanor.estruturadedados;

import java.time.Duration;
import java.time.Instant;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.fanor.estruturadedados.cap1.BuscaBinaria;
import br.edu.fanor.estruturadedados.utils.ArquivoUtils;

public class TestBuscaBinaria {

	private static Integer[] vetor;

	@BeforeClass
	public static void init() {
		try {
			vetor = ArquivoUtils.retornaVetor("resources/large-sorted");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void testBuscarMelhorCaso() {
		Instant agora = Instant.now();
		Integer indice = BuscaBinaria.buscar(vetor, 0, true, (i1, i2) -> ((Integer)i1).compareTo(((Integer)i2)));
		
		Instant fim = Instant.now();
		Duration duracao = Duration.between(agora, fim);
		System.out.println("[testBuscarMelhorCaso]" + duracao.toMillis() + " ms.");

		Assert.assertTrue(indice != null);
		Assert.assertEquals(2, indice.intValue());
	}

	@Test
	public void testBuscarCasoMedio() {
		Instant agora = Instant.now();

		Integer indice = BuscaBinaria.buscar(vetor, 555587, true, (i1, i2) -> ((Integer)i1).compareTo(((Integer)i2)));

		Instant fim = Instant.now();
		Duration duracao = Duration.between(agora, fim);
		System.out.println("[testBuscarCasoMedio]" + duracao.toMillis() + " ms.");

		Assert.assertTrue(indice != null);
		Assert.assertEquals(555027, indice.intValue());
	}

	@Test
	public void testBuscarPiorCaso() {
		Instant agora = Instant.now();

		Integer indice = BuscaBinaria.buscar(vetor, 5, true, (i1, i2) -> ((Integer)i1).compareTo(((Integer)i2)));

		Instant fim = Instant.now();
		Duration duracao = Duration.between(agora, fim);
		System.out.println("[testBuscarPiorCaso]" + duracao.toMillis() + " ms.");

		Assert.assertTrue(indice == null);
	}
}