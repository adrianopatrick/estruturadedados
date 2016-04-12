package br.edu.fanor.estruturadedados.trabalhos;

import br.edu.fanor.estruturadedados.cap2.ListaDuplaLigada;

/**
 * @author adrianopatrick@gmail.com
 * @since 30 de mar de 2016
 */
public class Tarefa {
	
	/***/
	private Integer idTarefa;
	private Integer qtdaDependencias;
	private ListaDuplaLigada<Tarefa> listaDependencias;
	
	public Integer getIdTarefa() {
		return idTarefa;
	}
	public void setIdTarefa(Integer idTarefa) {
		this.idTarefa = idTarefa;
	}
	public Integer getQtdaDependencias() {
		return qtdaDependencias;
	}
	public void setQtdaDependencias(Integer qtdaDependencias) {
		this.qtdaDependencias = qtdaDependencias;
	}
	public ListaDuplaLigada<Tarefa> getListaDependencias() {
		return listaDependencias;
	}
	public void setListaDependencias(ListaDuplaLigada<Tarefa> listaDependencias) {
		this.listaDependencias = listaDependencias;
	}
	
}

