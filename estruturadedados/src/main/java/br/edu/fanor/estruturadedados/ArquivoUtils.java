package br.edu.fanor.estruturadedados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

/**
 * Código que realiza a leitura do arquivo com os dados a serem processados
 * 
 * @since 05/02/2016
 * @author patrick.cunha
 * */
public class ArquivoUtils {

	public static int[] retornaVetor(String path) throws Exception {

		//as linhas do arquivo começam em 1, porém o vetor inicia em 0(zero)
		//por isso soma mais 1 a quantidade de linhas para o tamanho do vetor
		int[] vetor = new int[retornaQuantidadeDeLinhasDoArquivo(path) + 1];

		File file = new File(BuscaLinearTest.class.getResource(path).getFile());
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
			int indice = 0;

			String texto;
			while ((texto = br.readLine()) != null) {
				if (!texto.trim().isEmpty()) {
					vetor[indice++] = Integer.valueOf(texto.trim());
				}
			}
			return vetor;
		} catch (Exception e) {
			throw e;
		}
	}

	private static int retornaQuantidadeDeLinhasDoArquivo(String path) throws Exception {
		File file = new File(BuscaLinearTest.class.getResource(path).getFile());
		try (FileReader fr = new FileReader(file); LineNumberReader linhaLeitura = new LineNumberReader(fr);) {
			linhaLeitura.skip(file.length());
			int qtdLinhas = linhaLeitura.getLineNumber();

			return qtdLinhas;
		} catch (Exception e) {
			throw e;
		}
	}
}
