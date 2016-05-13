package br.edu.fanor.estruturadedados.cap3;

/**
 * @author adrianopatrick@gmail.com
 * @since 13 de mai de 2016
 */
public class ArvoreAVL {

	private No raiz = null;

	public ArvoreAVL() {
		raiz = null;
	}

	public void limpar() {
		raiz = null;
	}

	public boolean isEmpty() {
		return raiz == null;
	}

	public No getRaiz() {
		return raiz;
	}

	private static int getAltura(No t) {
		return t == null ? -1 : t.altura;
	}

	private static int max(int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}

	private int getFator(No t) {
		return getAltura(t.esquerdo) - getAltura(t.direito);
	}

	public boolean inserir(int x) {
		raiz = inserir(x, raiz);
		return true;
	}

	private No inserir(int x, No t) {
		if (t == null)
			t = new No(x, null, null);
		else if (x < t.valor)
			t.esquerdo = inserir(x, t.esquerdo);
		else if (x > t.valor)
			t.direito = inserir(x, t.direito);
		t = balancear(t);
		return t;
	}

	public No balancear(No t) {
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

	private static No rotacaoADireita(No k2) {
		No k1 = k2.esquerdo;
		k2.esquerdo = k1.direito;
		k1.direito = k2;
		k2.altura = max(getAltura(k2.esquerdo), getAltura(k2.direito)) + 1;
		k1.altura = max(getAltura(k1.esquerdo), k2.altura) + 1;
		return k1;
	}

	private static No rotacaoAEsquerda(No k1) {
		No k2 = k1.direito;
		k1.direito = k2.esquerdo;
		k2.esquerdo = k1;
		k1.altura = max(getAltura(k1.esquerdo), getAltura(k1.direito)) + 1;
		k2.altura = max(getAltura(k2.direito), k1.altura) + 1;
		return k2;
	}

	private static No duplaRotacaoADireita(No k3) {
		k3.esquerdo = rotacaoAEsquerda(k3.esquerdo);
		return rotacaoADireita(k3);
	}

	private static No duplaRotacaoAEsquerda(No k1) {
		k1.direito = rotacaoADireita(k1.direito);
		return rotacaoAEsquerda(k1);
	}

	public No buscarValor(int chave) {
		return buscarValor(raiz, chave);
	}

	protected No buscarValor(No p, int chave) {
		while (p != null) {
			if (chave == p.valor)
				return p;
			else if (chave < p.valor)
				p = p.esquerdo;
			else
				p = p.direito;
		}
		return null;
	}

	public void inOrdem() {
		inOrdem(raiz);
	}

	protected void inOrdem(No p) {
		if (p != null) {
			inOrdem(p.esquerdo);
			System.out.print(p.valor + " - ");
			inOrdem(p.direito);
		}
	}

	public void preOrdem() {
		preOrdem(raiz);
	}

	protected void preOrdem(No p) {
		if (p != null) {
			System.out.print(p.valor + " ");
			preOrdem(p.esquerdo);
			preOrdem(p.direito);
		}
	}

	public void posOrdem() {
		posOrdem(raiz);
	}

	protected void posOrdem(No p) {
		if (p != null) {
			posOrdem(p.esquerdo);
			posOrdem(p.direito);
			System.out.print(p.valor + " ");
		}
	}

	protected No buscaPai(int chave) {
		No p = raiz;
		No prev = null;
		while (p != null && !(p.valor == chave)) {
			prev = p;
			if (p.valor < chave)
				p = p.direito;
			else
				p = p.esquerdo;
		}
		if (p != null && p.valor == chave)
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

	private void imprimirSubArvore(No node, String separator) {
		if (node != null) {
			No father = this.buscaPai(node.valor);
			if (node.equals(father.esquerdo) == true) {
				System.out.println(separator + node.valor + "(" + node.altura
						+ ")" + " (ESQ)");
			} else {
				System.out.println(separator + node.valor + "(" + node.altura
						+ ")" + " (DIR)");
			}
			imprimirSubArvore(node.esquerdo, "     " + separator);
			imprimirSubArvore(node.direito, "     " + separator);
		}
	}

	private static class No {

		protected int altura;
		protected int valor;
		protected No esquerdo, direito;

		public No(int valor, No lt, No rt) {
			this.valor = valor;
			esquerdo = lt;
			direito = rt;
			altura = 0;
		}
	}

	public static void main(String args[]) {
		ArvoreAVL t = new ArvoreAVL();
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
