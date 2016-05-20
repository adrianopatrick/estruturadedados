package br.edu.fanor.estruturadedados.trabalhos;
/** Trabalho da disciplina de Estrutura de Dados - Fanor - 2016.1
 * 	Professor: 
 *		- Adriano Patrick do Nascimento Cunha - acunha2@fanor.edu.br
 *	Equipe:
 *		- nome - email
 *		- nome - email
 *	Problema:
 * 		QUESTÃO ÚNICA: 
 *			Implementar um algoritmo de utilizando uma estrutura de dados do tipo FILA para solucionar o problema
 *			da ordenação topológica. A Ordenação topológica é um grafo acíclico orientado, onde cada vértice 
 *			esteja ordenado pela dependência existente entre os vértices. (https://www.youtube.com/watch?v=URdtNUdxU3o)
 *			Conceitos:
 *			- Uma permutação dos vértices de um digrafo é uma sequência em que cada vértice aparece uma só vez
 *			- Uma ordenação topológica é uma permutação dos vértices v1, ..., vn,
 *				de um digrafo acíclico, de forma que para qualquer aresta (vi ; vj ), i < j .
 *				- qualquer caminho entre vi e vj não passa por vk se k < i ou k > j . 
 *			- Digrafos com ciclos não admitem ordenação topológica.
 *		ENTRADA: 
 *			O arquivo de entrada contém várias instâncias do problema. Cada linha inicia com o número de tarefas, 
 *			seguido da lista de dependências entre estas tarefas, as dependências são representas como vértices do
 *			tipo: (a, b), onde "a" representa a tarefa a qual "b" depende, ou seja, para que "b" seja executado é 
 *			necessário que "a" tenha terminado. Não será inserido digrafo cíclico.
 *		SAIDA: 
 *			A saída consiste de tantas linhas quantas instâncias do problema houver. Em cada linha, devem ser
 *		impressos a lista de tarefas ordenadas topologicamente, ou seja, com base na dependência das tarefas.
 *		EXEMPLO:
 *			Entrada:
 *				1 
 *				4 (2,1) (2,3)
 *				5 (2,1) (2,3) (3,1) (1,5)
 *			Saída:
 *				1
 *				4, 2, 1, 3
 *				4, 2, 3, 1, 5
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

import br.edu.fanor.estruturadedados.cap2.Fila;
import br.edu.fanor.estruturadedados.cap2.ListaDuplaLigada;

/**
 * @author patrick.cunha
 * @since 30/03/2016 - Ordenação Topológica
 */
public class OrdenacaoTopologica {

	private static final String DELIMITADORES = "\\(|\\)";
	private static List<Problema> problemas = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// recebe o arquivo via argumentos ou ler o arquivo padrão da sua pasta
		InputStream input = args.length > 0 ? new FileInputStream(args[0])
				: OrdenacaoTopologica.class.getResourceAsStream("entrada.in");
		processa(new java.io.InputStreamReader(input));
		System.exit(0);
	}

	/**
	 * Método principal
	 */
	private static void processa(Reader readerInput) {
		entrada(readerInput);
		ordena();
		saida();
	}

	/**
	 * Processa a entrada
	 */
	private static void entrada(Reader readerInput) {
		try (BufferedReader br = new BufferedReader(readerInput)) {
			Stream<String> linhas = br.lines();
			linhas.forEach((linha) -> {
				List<Tarefa> tarefas = criaTarefas(new StringTokenizer(
						linha.replaceAll(" ", ""), DELIMITADORES));
				Problema problema = new Problema();
				problema.getTarefasEntrada().addAll(tarefas);
				problemas.add(problema);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<Tarefa> criaTarefas(StringTokenizer token) {

		List<Tarefa> tarefas = new ArrayList<>();
		List<String> dependencias = new ArrayList<>();

		int qtdaTarefas = Integer.parseInt(token.nextToken());
		int qtdaTokens = token.countTokens();

		for (int i = 0; i < qtdaTokens; i++) {
			dependencias.add(token.nextToken());
		}

		for (int i = 0; i < qtdaTarefas; i++) {
			Tarefa tarefa = new Tarefa();
			tarefa.setIdTarefa(i + 1);
			tarefas.add(tarefa);
		}

		for (Tarefa tarefa : tarefas) {
			tarefa.setQtdaDependencias(retornaQuantidadeDeDependencias(
					dependencias, tarefa.getIdTarefa()));
			tarefa.setListaDependencias(retornaListaDeDependencias(dependencias,
					tarefa.getIdTarefa(), tarefas));
		}

		return tarefas;
	}

	private static int retornaQuantidadeDeDependencias(
			List<String> dependencias, Integer idTarefa) {

		return new Long(dependencias.stream()
				.filter(dependencia -> idTarefa
						.equals(Integer.parseInt(dependencia.split(",")[1])))
				.count()).intValue();
	}

	private static ListaDuplaLigada<Tarefa> retornaListaDeDependencias(
			List<String> dependentes, Integer idTarefa, List<Tarefa> tarefas) {

		ListaDuplaLigada<Tarefa> listaDeDependentes = new ListaDuplaLigada<>();

		dependentes.stream()
				.filter(dependente -> idTarefa
						.equals(Integer.parseInt(dependente.split(",")[0])))
				.forEach(dependente -> {
					listaDeDependentes.add(tarefas.stream()
							.filter(tarefa -> tarefa.getIdTarefa()
									.equals(Integer.parseInt(
											dependente.split(",")[1])))
							.findFirst().get());
				});

		return listaDeDependentes;
	}

	/**
	 * Método que realiza a ordenação topológica.
	 */
	private static void ordena() {

		for (Problema problema : problemas) {
			Fila<Tarefa> fila = new Fila<>();
			List<Tarefa> saida = new ArrayList<>();
			problema.getTarefasEntrada().stream()
					.filter(tarefa -> tarefa.getQtdaDependencias().equals(0))
					.forEach(tarefa -> fila.queue(tarefa));

			while (fila.size() > 0) {

				Tarefa tarefa = (Tarefa) fila.getLista().get(0);

				if (tarefa.getListaDependencias() != null) {
					for (int i = 0; i < tarefa.getListaDependencias()
							.size(); i++) {
						Tarefa tarefaDep = (Tarefa) tarefa
								.getListaDependencias().get(i);
						tarefaDep.setQtdaDependencias(
								tarefaDep.getQtdaDependencias() - 1);
						if (tarefaDep.getQtdaDependencias().equals(0)) {
							fila.queue(tarefaDep);
						}
					}
				}
				saida.add(tarefa);
				fila.dequeue();
			}
			problema.setTarefasSaida(saida);
		}

	}

	/**
	 * Processa a saída
	 */
	private static void saida() {
		try (PrintWriter arquivo = new PrintWriter(
				new FileWriter("saida.out", true))) {
			problemas.forEach(problema -> {
				problema.getTarefasSaida().forEach(tarefa -> {
					arquivo.append((tarefa.getIdTarefa()) + ", ");
					System.out.print(tarefa.getIdTarefa() + " ");
				});
				arquivo.printf("\r\n");
				System.out.println();
			});
		} catch (IOException e) {
			System.out.println("deu erro");
		}
	}
}