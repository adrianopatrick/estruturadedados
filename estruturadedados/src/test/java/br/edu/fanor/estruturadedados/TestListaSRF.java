package br.edu.fanor.estruturadedados;

import org.junit.Assert;
import org.junit.Test;

import br.edu.fanor.estruturadedados.cap2.Aluno;
import br.edu.fanor.estruturadedados.cap2.Lista;
import br.edu.fanor.estruturadedados.cap2.ListaSRF;

public class TestListaSRF {

	@Test
	public void testInsercaoPorOrdem(){
		Aluno a1 = new Aluno("N1", "Marcus");
		Aluno a2 = new Aluno("N2", "Didi");
		
		Lista alunos = new ListaSRF();
		alunos.add(a1);
		alunos.add(a2);
		
		Assert.assertEquals(2, alunos.size());
	}
	
	@Test
	public void testInsercaoEmPosicao(){
		Aluno a1 = new Aluno("N1", "Marcus");
		Aluno a2 = new Aluno("N2", "Didi");
		
		Lista alunos = new ListaSRF();
		alunos.add(a1);
		alunos.add(0, a2);
		
		Assert.assertEquals(a2, alunos.get(0));
		Assert.assertEquals(a1, alunos.get(1));
	}
}
