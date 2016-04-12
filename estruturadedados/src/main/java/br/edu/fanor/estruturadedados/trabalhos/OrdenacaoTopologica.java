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

import java.io.*;
import java.util.*;

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
		processa(args[0]);
		System.exit(0);
	}

	/**
	 * Método principal
	 */
	private static void processa(String file) {
		entrada(file);
		ordena();
		saida();
	}

	/**
	 * Processa a entrada
	 */
	private static void entrada(String file) {

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				List<Tarefa> tarefas = criaTarefas(new StringTokenizer(
						linha.replaceAll(" ", ""), DELIMITADORES));
				Problema problema = new Problema();
				problema.getTarefasEntrada().addAll(tarefas);
				problemas.add(problema);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	private static List<Tarefa> criaTarefas(StringTokenizer token) {

		List<Tarefa> tarefas = new ArrayList<>();
		int qtdaTarefas = Integer.parseInt(token.nextToken());
		String[] dependencias = new String[token.countTokens()];
		for (int i = 0; i < dependencias.length; i++) {
			dependencias[i] = token.nextToken();
		}

		for (int i = 0; i < qtdaTarefas; i++) {
			Tarefa tarefa = new Tarefa();
			tarefa.setIdTarefa(i + 1);
			tarefa.setQtdaDependencias(retornaQuantidadeDeDependencias(
					dependencias, tarefa.getIdTarefa()));
			tarefa.setListaDependencias(retornaListaDeDependencias(dependencias,
					tarefa.getIdTarefa()));
			tarefas.add(tarefa);
		}

		return tarefas;
	}

	// TODO implementarar
	private static int retornaQuantidadeDeDependencias(String[] dependencias,
			Integer idTarefa) {
		return 0;
	}

	// TODO implementarar
	private static ListaDuplaLigada<Tarefa> retornaListaDeDependencias(
			String[] dependencias, Integer idTarefa) {
		return null;
	}

	/**
	 * Método que realiza a ordenação topológica.
	 */// TODO implementarar
	private static void ordena() {

		Fila<Tarefa> fila = new Fila<>();
	}

	/**
	 * Processa a saída
	 */
	private static void saida() {

		try (PrintWriter arquivo = new PrintWriter(
				new FileWriter("saida.out", true))) {
			for (Problema problema : problemas) {
				for (Tarefa tarefa : problema.getTarefasSaida()) {
					arquivo.append((tarefa.getIdTarefa()) + ", ");
				}
				arquivo.printf("\r\n");
				System.out.println();
			}
		} catch (IOException e) {
			System.out.println("deu erro");
			e.printStackTrace();
		}

	}

}
