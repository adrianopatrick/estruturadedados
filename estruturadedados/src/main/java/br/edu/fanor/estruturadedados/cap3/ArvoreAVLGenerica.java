package br.edu.fanor.estruturadedados.cap3;

/**
 * @author adrianopatrick@gmail.com
 * @since 30 de mai de 2016
 */

import java.util.Comparator;

public class ArvoreAVLGenerica<T> {

	private No<T> raiz = null;

	private Comparator<Object> comparator;

	public ArvoreAVLGenerica(Comparator<Object> comparator) {
		this.comparator = comparator;
	}

	public void limpar() {
		raiz = null;
	}

	public boolean isEmpty() {
		return raiz == null;
	}

	public No<T> getRaiz() {
		return raiz;
	}

	private int getAltura(No<T> esquerdo) {
		return esquerdo == null ? -1 : esquerdo.altura;
	}

	private int max(int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}

	private int getFator(No<T> t) {
		return getAltura(t.esquerdo) - getAltura(t.direito);
	}

	public boolean inserir(Object x) {
		raiz = inserir(x, raiz);
		return true;
	}

	private No<T> inserir(Object x, No<T> t) {
		if (t == null)
			t = new No<T>(x, null, null);
		else if (comparator.compare(x, t.valor) > 0)
			t.esquerdo = inserir(x, t.esquerdo);
		else if (comparator.compare(x, t.valor) < 0)
			t.direito = inserir(x, t.direito);
		t = balancear(t);
		return t;
	}

	public No<T> balancear(No<T> t) {
		if (getFator(t) == 2) {
			if (getFator(t.esquerdo) > 0)
				t = rotacaoADireita(t);
			else
				t = duplaRotacaoADireita(t);
		} else if (getFator(t) == -2) {
			if (getFator(t.direito) < 0)
				t = rotacaoAEsquerda(t);
			else
				t = duplaRotacaoAEsquerda(t);
		}
		t.altura = max(getAltura(t.esquerdo), getAltura(t.direito)) + 1;
		return t;
	}

	private No<T> rotacaoADireita(No<T> k2) {
		No<T> k1 = k2.esquerdo;
		k2.esquerdo = k1.direito;
		k1.direito = k2;
		k2.altura = max(getAltura(k2.esquerdo), getAltura(k2.direito)) + 1;
		k1.altura = max(getAltura(k1.esquerdo), k2.altura) + 1;
		return k1;
	}

	private No<T> rotacaoAEsquerda(No<T> k1) {
		No<T> k2 = k1.direito;
		k1.direito = k2.esquerdo;
		k2.esquerdo = k1;
		k1.altura = max(getAltura(k1.esquerdo), getAltura(k1.direito)) + 1;
		k2.altura = max(getAltura(k2.direito), k1.altura) + 1;
		return k2;
	}

	private No<T> duplaRotacaoADireita(No<T> t) {
		t.esquerdo = rotacaoAEsquerda(t.esquerdo);
		return rotacaoADireita(t);
	}

	private No<T> duplaRotacaoAEsquerda(No<T> k1) {
		k1.direito = rotacaoADireita(k1.direito);
		return rotacaoAEsquerda(k1);
	}

	public No<T> buscarValor(Object chave) {
		return buscarValor(raiz, chave);
	}

	protected No<T> buscarValor(No<T> p, Object chave) {
		while (p != null) {
			if (chave.equals(p.valor))
				return p;
			else if (comparator.compare(chave, p.valor) < 0)
				p = p.esquerdo;
			else
				p = p.direito;
		}
		return null;
	}

	public void inOrdem() {
		inOrdem(raiz);
	}

	protected void inOrdem(No<T> p) {
		if (p != null) {
			inOrdem(p.esquerdo);
			System.out.print(p.valor + " - ");
			inOrdem(p.direito);
		}
	}

	public void preOrdem() {
		preOrdem(raiz);
	}

	protected void preOrdem(No<T> p) {
		if (p != null) {
			System.out.print(p.valor + " ");
			preOrdem(p.esquerdo);
			preOrdem(p.direito);
		}
	}

	public void posOrdem() {
		posOrdem(raiz);
	}

	protected void posOrdem(No<T> p) {
		if (p != null) {
			posOrdem(p.esquerdo);
			posOrdem(p.direito);
			System.out.print(p.valor + " ");
		}
	}

	protected No<T> buscaPai(Object chave) {
		No<T> p = raiz;
		No<T> prev = null;
		while (p != null && !(p.valor.equals(chave))) {
			prev = p;
			if (comparator.compare(p.valor, chave) > 0)
				p = p.direito;
			else
				p = p.esquerdo;
		}
		if (p != null && p.valor.equals(chave))
			return prev;
		return null;
	}

	public void imprimirArvore() {
		if (isEmpty()) {
			System.out.println("Árvore vazia!");
			return;
		}
		String separator = String.valueOf("  |__");
		System.out.println(this.raiz.valor + "(" + raiz.altura + ")");
		imprimirSubArvore(raiz.esquerdo, separator);
		imprimirSubArvore(raiz.direito, separator);
	}

	private void imprimirSubArvore(No<T> node, String separator) {
		if (node != null) {
			No<T> father = this.buscaPai(node.valor);

			if (node.equals(father.esquerdo) == true) {
				System.out.println(separator + node.valor + "(" + node.altura + ")" + " (ESQ)");
			} else {
				System.out.println(separator + node.valor + "(" + node.altura + ")" + " (DIR)");
			}
			imprimirSubArvore(node.esquerdo, "     " + separator);
			imprimirSubArvore(node.direito, "     " + separator);
		}
	}

	private static class No<T> {

		protected int altura;
		protected Object valor;
		protected No<T> esquerdo, direito;

		public No(Object valor, No<T> lt, No<T> rt) {
			this.valor = valor;
			esquerdo = lt;
			direito = rt;
			altura = 0;
		}
	}

	public static void main(String args[]) {
		ArvoreAVLGenerica<Integer> t = new ArvoreAVLGenerica<>((o1, o2) -> ((Integer) o1).compareTo((Integer) o2));
		t.inserir(1);
		t.inserir(2);
		t.inserir(3);
		t.inserir(4);
		t.inserir(5);
		t.inserir(6);
		t.inserir(7);
		t.inserir(8);
		t.inserir(9);
		t.imprimirArvore();
	}
}
