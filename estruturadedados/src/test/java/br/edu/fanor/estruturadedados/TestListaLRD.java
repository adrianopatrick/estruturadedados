package br.edu.fanor.estruturadedados;

import org.junit.Assert;
import org.junit.Test;

import br.edu.fanor.estruturadedados.cap2.Aluno;
import br.edu.fanor.estruturadedados.cap2.Lista;
import br.edu.fanor.estruturadedados.cap2.ListaLigada;

public class TestListaLRD {

	@Test
	public void testInsercaoPorOrdem(){
		Aluno a1 = new Aluno("N1", "Marcus");
		Aluno a2 = new Aluno("N2", "Didi");
		
		Lista<Aluno> alunos = new ListaLigada<>();
		alunos.add(a1);
		alunos.add(a2);
		
		Assert.assertEquals(2, alunos.size());
	}
	
	@Test
	public void testInsercaoEmPosicao(){
		Aluno a1 = new Aluno("N1", "Marcus");
		Aluno a2 = new Aluno("N2", "Didi");
		
		Lista<Aluno> alunos = new ListaLigada<>();
		alunos.add(a1);
		alunos.add(0, a2);
		
		Assert.assertEquals(a2, alunos.get(0));
		Assert.assertEquals(a1, alunos.get(1));
	}
	
	@Test
	public void testSeListaVazia(){
		Assert.assertTrue(new ListaLigada<>().isEmpty());
	}
	
	@Test
	public void testContainsComValorNaLista(){
		Aluno a1 = new Aluno("N1", "Marcus");
		Aluno a2 = new Aluno("N2", "Didi");
		
		Lista<Aluno> alunos = new ListaLigada<>();
		alunos.add(a1);
		alunos.add(0, a2);
		
		Assert.assertTrue(alunos.contains(a1));
	}
	
	@Test
	public void testContainsComValorNaoPresente(){
		Aluno a1 = new Aluno("N1", "Marcus");
		Aluno a2 = new Aluno("N2", "Wagner");
		
		Lista<Aluno> alunos = new ListaLigada<>();
		alunos.add(a1);
		
		Assert.assertFalse(alunos.contains(a2));
	}
	
	@Test
	public void testRemocao(){
		Aluno a1 = new Aluno("N1", "Marcus");
		Aluno a2 = new Aluno("N2", "Didi");
		
		Lista<Aluno> alunos = new ListaLigada<>();
		alunos.add(a1);
		alunos.add(0, a2);
		
		alunos.remove(0);
		alunos.remove(a1);
		
		Assert.assertEquals(0, alunos.size());
	}
	
}
