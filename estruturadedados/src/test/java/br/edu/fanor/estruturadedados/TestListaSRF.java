package br.edu.fanor.estruturadedados;

import org.junit.Assert;
import org.junit.Test;

import br.edu.fanor.estruturadedados.cap2.Aluno;
import br.edu.fanor.estruturadedados.cap2.Lista;
import br.edu.fanor.estruturadedados.cap2.ListaSimples;

public class TestListaSRF {

	@Test
	public void testInsercaoPorOrdem(){
		Aluno a1 = new Aluno("N1", "Marcus");
		Aluno a2 = new Aluno("N2", "Didi");
		
		Lista<Aluno> alunos = new ListaSimples<>();
		alunos.add(a1);
		alunos.add(a2);
		
		Assert.assertEquals(2, alunos.size());
	}
	
	@Test
	public void testInsercaoEmPosicao(){
		Aluno a1 = new Aluno("N1", "Marcus");
		Aluno a2 = new Aluno("N2", "Didi");
		
		Lista<Aluno> alunos = new ListaSimples<>();
		alunos.add(a1);
		alunos.add(0, a2);
		
		Assert.assertEquals(a2, alunos.get(0));
		Assert.assertEquals(a1, alunos.get(1));
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testInsercaoEmPosicaoInexistente(){
		new ListaSimples<>().add(100, new Aluno("x", "x"));
	}
	
	@Test(expected=StackOverflowError.class)
	public void testInsercaoEmPosicaoQuandoNaoExisteMaisEspaco(){
		Lista<Aluno> alunos = new ListaSimples<>();
		for (int i = 0; i < 100; i++) {
			alunos.add(new Aluno("x", "y"));
		}
		Aluno aluno = new Aluno("N1", "Leonardo");
		alunos.add(0, aluno);
	}
	
	@Test
	public void testSeListaVazia(){
		Assert.assertTrue(new ListaSimples<>().isEmpty());
	}
	
	@Test
	public void testContainsComValorNaLista(){
		Aluno a1 = new Aluno("N1", "Marcus");
		Aluno a2 = new Aluno("N2", "Didi");
		
		Lista<Aluno> alunos = new ListaSimples<>();
		alunos.add(a1);
		alunos.add(0, a2);
		
		Assert.assertTrue(alunos.contains(a1));
	}
	
	@Test
	public void testContainsComValorNaoPresente(){
		Aluno a1 = new Aluno("N1", "Marcus");
		Aluno a2 = new Aluno("N2", "Wagner");
		
		Lista<Aluno> alunos = new ListaSimples<>();
		alunos.add(a1);
		
		Assert.assertFalse(alunos.contains(a2));
	}
	
	@Test
	public void testRemocao(){
		Aluno a1 = new Aluno("N1", "Marcus");
		Aluno a2 = new Aluno("N2", "Didi");
		
		Lista<Aluno> alunos = new ListaSimples<>();
		alunos.add(a1);
		alunos.add(0, a2);
		
		alunos.remove(0);
		alunos.remove(a1);
		
		Assert.assertEquals(0, alunos.size());
	}
	
}
