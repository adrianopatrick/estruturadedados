package br.edu.fanor.estruturadedados;

import java.time.Duration;
import java.time.Instant;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BuscaLinearTest {

	private static BuscaLinear buscador;
	private static int[] vetor;

	@BeforeClass
	public static void init() {
		buscador = new BuscaLinear();
		try {
			vetor = ArquivoUtils.retornaVetor("resources/large");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	@Test
	public void testBuscarMelhorCaso() {
		Instant agora = Instant.now();

		Integer indice = buscador.buscar(vetor, 489910);

		Instant fim = Instant.now();
		Duration duracao = Duration.between(agora, fim);
		System.out.println("[testBuscarMelhorCaso]" + duracao.toMillis() + " ms.");

		Assert.assertTrue(indice != null);
		Assert.assertEquals(0, indice.intValue());
	}

	@Test
	public void testBuscarCasoMedio() {
		Instant agora = Instant.now();

		Integer indice = buscador.buscar(vetor, 524610);

		Instant fim = Instant.now();
		Duration duracao = Duration.between(agora, fim);
		System.out.println("[testBuscarCasoMedio]" + duracao.toMillis() + " ms.");

		Assert.assertTrue(indice != null);
		Assert.assertEquals(555025, indice.intValue());
	}

	@Test
	public void testBuscarPiorCaso() {
		Instant agora = Instant.now();

		Integer indice = buscador.buscar(vetor, 5);

		Instant fim = Instant.now();
		Duration duracao = Duration.between(agora, fim);
		System.out.println("[testBuscarPiorCaso]" + duracao.toMillis() + " ms.");

		Assert.assertTrue(indice == null);
	}

}
