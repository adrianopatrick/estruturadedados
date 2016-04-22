package br.edu.fanor.estruturadedados;

import org.junit.Assert;
import org.junit.Test;

import br.edu.fanor.estruturadedados.cap2.Aluno;
import br.edu.fanor.estruturadedados.cap2.Lista;
import br.edu.fanor.estruturadedados.cap2.ListaVetor;

public class TestListaSNRD {

	@Test
	public void testInserir() {
		Aluno a1 = new Aluno("N1", "Didi");
		Aluno a2 = new Aluno("N1", "Didi"); 
		
		Lista<Aluno> alunos = new ListaVetor<>();
		alunos.add(a1);
		alunos.add(0,a2);
		
		Assert.assertEquals(1, alunos.size());
		Assert.assertTrue(alunos.get(0).equals(a2));
	}

}
