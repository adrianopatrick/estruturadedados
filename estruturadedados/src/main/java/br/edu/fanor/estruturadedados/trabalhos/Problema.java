package br.edu.fanor.estruturadedados.trabalhos;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que possuirá a lista de tarefas de entrada, retiradas do arquivo de entrada
 * e a lista de tarefas para saída, para serem salvos no arquivo.
 * 
 * @author adrianopatrick@gmail.com
 * @since 12 de abr de 2016
 */
public class Problema {
	
	private  List<Tarefa> tarefasEntrada = new ArrayList<>();
	private  List<Tarefa> tarefasSaida = new ArrayList<>();
	
	public  List<Tarefa> getTarefasEntrada() {
		return tarefasEntrada;
	}
	public  void setTarefasEntrada(List<Tarefa> tarefasEntrada) {
		this.tarefasEntrada = tarefasEntrada;
	}
	public  List<Tarefa> getTarefasSaida() {
		return tarefasSaida;
	}
	public  void setTarefasSaida(List<Tarefa> tarefasSaida) {
		this.tarefasSaida = tarefasSaida;
	}
}
