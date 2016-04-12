package br.edu.fanor.estruturadedados.trabalhos;

import br.edu.fanor.estruturadedados.cap2.ListaDuplaLigada;

/**
 * @author adrianopatrick@gmail.com
 * @since 30 de mar de 2016
 */
public class Tarefa {
	
	/***/
	private Integer tarefa;
	private Integer qtdaDependencias;
	private ListaDuplaLigada<Integer> listaDependencias;
	
	public Integer getTarefa() {
		return tarefa;
	}
	public void setTarefa(Integer tarefa) {
		this.tarefa = tarefa;
	}
	public Integer getQtdaDependencias() {
		return qtdaDependencias;
	}
	public void setQtdaDependencias(Integer qtdaDependencias) {
		this.qtdaDependencias = qtdaDependencias;
	}
	public ListaDuplaLigada<Integer> getListaDependencias() {
		return listaDependencias;
	}
	public void setListaDependencias(ListaDuplaLigada<Integer> listaDependencias) {
		this.listaDependencias = listaDependencias;
	}
	
}

