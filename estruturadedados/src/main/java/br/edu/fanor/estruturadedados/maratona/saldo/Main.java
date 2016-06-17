package br.edu.fanor.estruturadedados.maratona.saldo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SALDO - Saldo de gols - http://br.spoj.com/problems/SALDO/
 * 
 * Hipólito é um torcedor fanático. Coleciona flâmulas, bandeiras, recortes de
 * jornal, figurinhas de jogadores, camisetas e tudo o mais que se refira a seu
 * time preferido. Quando ganhou um computador de presente em uma festa,
 * resolveu montar um banco de dados com os resultados de todos os jogos de seu
 * time ocorridos desde a sua fundação, em 1911. Depois de inseridos os dados,
 * Hipólito começou a ficar curioso sobre estatísticas de desempenho do time.
 * Por exemplo, ele deseja saber qual foi o período em que o seu time acumulou o
 * maior saldo de gols. Como Hipólito tem o computador há muito pouco tempo, não
 * sabe programar muito bem, e precisa de sua ajuda.
 * 
 * TAREFA 
 * É dada uma lista, numerada seqüencialmente a partir de 1, com os
 * resultados de todos os jogos do time (primeira partida: 3 x 0, segunda
 * partida: 1 x 2, terceira partida: 0 x 5 ...). Sua tarefa é escrever um
 * programa que determine em qual período o time conseguiu acumular o maior
 * saldo de gols. Um período é definido pelos números de seqüência de duas
 * partidas, A e B, onde A ≤ B. O saldo de gols acumulado entre A e B é dado
 * pela soma dos gols marcados pelo time em todas as partidas realizadas entre A
 * e B (incluindo as mesmas) menos a soma dos gols marcados pelos times
 * adversários no período. Se houver mais de um período com o mesmo saldo de
 * gols, escolha o maior período (ou seja, o período em que B - A é maior). Se
 * ainda assim houver mais de uma solução possível, escolha qualquer uma delas
 * como resposta.
 * 
 * ENTRADA 
 * Seu programa deve ler vários conjuntos de teste. A primeira linha de
 * um conjunto de teste contém um inteiro não negativo, N, que indica o número
 * de partidas realizadas pelo time (o valor N = 0 indica o final da entrada).
 * Seguem-se N linhas, cada uma contendo um par de números inteiros não
 * negativos X e Y que representam o resultado da partida: X são os gols a favor
 * e Y os gols contra o time de Hipólito. As partidas são numeradas
 * sequencialmente a partir de 1, na ordem em que aparecem na entrada.
 * 
 * SAÍDA 
 * Para cada conjunto de teste da entrada seu programa deve produzir três
 * linhas na saída. A primeira linha deve conter um identificador do conjunto de
 * teste, no formato “Teste n”, onde n é numerado a partir de 1. A segunda linha
 * deve conter um par de inteiros I e J que indicam respectivamente a primeira e
 * última partidas do melhor período, conforme determinado pelo seu programa,
 * exceto quando o saldo de gols do melhor período for menor ou igual a zero;
 * neste caso a segunda linha deve conter a expressão “nenhum”. A terceira linha
 * deve ser deixada em branco. A grafia mostrada no Exemplo de Saída, abaixo,
 * deve ser seguida rigorosamente. Problema SALDO
 * 
 * 
 * @author adrianopatrick@gmail.com
 * @since 17 de jun de 2016
 */
public class Main {

	public static void main(String[] args)
			throws NumberFormatException, IOException {

		// partidas
		int n;

		// ler entrada
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		int contador = 0;
		while ((n = Integer.parseInt(br.readLine().trim())) != 0) {
			contador++;

			int[] saldos = entrada(br, new int[n]);
			processa(contador, saldos);
		}

		System.exit(0);
	}

	/**
	 * @param br
	 * @param saldos
	 * @return array de inteiros
	 * @throws IOException
	 */
	private static int[] entrada(BufferedReader br, int[] saldos)
			throws IOException {
		// variaveis de placar
		int x, y, i;
		for (i = 0; i < saldos.length; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			x = Integer.parseInt(tokens.nextToken());
			y = Integer.parseInt(tokens.nextToken());
			saldos[i] = x - y;
		}
		return saldos;
	}

	/**
	 * Este método resolve o problema proposto, utilizando uma técnica de
	 * programação dinâmica, chamada de Algorítmo de Kadane, que
	 * tradicionalmente resolve qualquer problema da classe de problemas de
	 * sublista de soma máxima(Maximum Subarray Problem) com complexidade O(n).
	 *
	 * @param contador
	 * @param saldos
	 */
	private static void processa(int contador, int[] saldos) {
		int i;
		int maxAtual = 0;
		int maxTotal = 0;
		int xTemp = 0;
		int inicio = 0, fim = 0;
		for (i = 0; i < saldos.length; i++) {
			maxAtual += saldos[i];
			if (maxAtual < 0) {
				maxAtual = 0;
				xTemp = i + 1;
			}
			if (maxAtual > maxTotal
					|| (maxAtual == maxTotal && fim - inicio < i - xTemp)) {
				maxTotal = maxAtual;
				inicio = xTemp + 1;
				fim = i + 1;
			}
		}

		if (maxTotal > 0) {
			System.out.println(
					"Teste " + contador + "\n" + inicio + " " + fim + "\n");
		} else {
			System.out.println("Teste " + contador + "\n" + "nenhum" + "\n");
		}
	}
}