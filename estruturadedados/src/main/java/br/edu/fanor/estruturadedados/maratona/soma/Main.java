package br.edu.fanor.estruturadedados.maratona.soma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Prolema da SOMA
 * 
 * SOMA - Soma - http://br.spoj.com/problems/SOMA/
 * 
 * Dada uma lista de N inteiros, encontre a soma de todos eles. 
 * 
 * Entrada
 * A entrada é composta de um único caso de teste. A primeira linha contém um
 * inteiro positivo N. As N linhas seguintes contêm cada uma um inteiro X,
 * representando os N números a serem somados. 
 * 
 * Saída
 * Seu programa deve produzir uma única linha na saída, contendo a soma de todos
 * os N inteiros. 
 * 
 * Restrições
 * 0 ≤ N ≤ 50 |X| ≤ 5000
 * 
 * Para testes execute: java Main < entrada.in no terminal
 * 
 * @author adrianopatrick@gmail.com
 * @since 17 de jun de 2016
 */
public class Main {

	private static BufferedReader br;

	public static void main(String[] args)
			throws NumberFormatException, IOException {
		// ler entrada de forma mais rapida do que com Scanner
		br = new BufferedReader(new InputStreamReader(System.in));

		int soma = 0;

		// ler primeira linha com quantidade linhas com sequencias de atividades
		int n = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine().trim());
			soma += x;
		}

		System.out.println(soma);
	}
}