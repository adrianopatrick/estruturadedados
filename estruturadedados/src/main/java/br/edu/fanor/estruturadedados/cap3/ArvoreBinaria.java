package br.edu.fanor.estruturadedados.cap3;

import java.util.Comparator;

/**
 * @author adrianopatrick@gmail.com
 * @since 6 de mai de 2016
 */
public class ArvoreBinaria<T> {

	private Comparator<Object> comparator;

	public ArvoreBinaria(Comparator<Object> comparator) {
		this.comparator = comparator;
	}

	private No<T> raiz;

	public boolean isEmpty() {
		return (this.raiz == null) ? true : false;
	}

	public int getAltura() {
		return this.getAltura(this.raiz);
	}

	public int getAltura(No<T> no) {
		if (no == null) { // caso base
			return 0;
		} else { // caso recursivo
			int alturaEsquerda = this.getAltura(no.noEsquerdo);
			int alturaDireito = this.getAltura(no.noDireito);
			if (alturaEsquerda > alturaDireito) {
				return alturaEsquerda + 1;
			} else {
				return alturaDireito + 1;
			}
		}
	}

	public void inserir(Object valor) {
		this.inserir(raiz, valor);
	}

	private void inserir(No<T> no, Object valor) {
		if (raiz == null) {
			this.raiz = new No<>(valor);
		} else {
			if (comparator.compare(valor, no.valor) > 0) {
				if (no.noEsquerdo != null) {
					this.inserir(no.noEsquerdo, valor);
				} else {
					no.noEsquerdo = new No<>(valor);
				}
			} else if (comparator.compare(valor, no.valor) < 0) {
				if (no.noDireito != null) {
					this.inserir(no.noDireito, valor);
				} else {
					no.noDireito = new No<>(valor);
				}
			}
		}
	}

	public No<T> remover(int valor) throws Exception {
		return remover(this.raiz, valor);
	}

	private No<T> remover(No<T> no, int valor) throws Exception {
		if (this.raiz == null) {
			throw new Exception("Árvore vazia");
		} else {
			if (comparator.compare(valor, no.valor) > 0) {
				no.noEsquerdo = remover(no.noEsquerdo, valor);
			} else if (comparator.compare(valor, no.valor) < 0) {
				no.noDireito = remover(no.noDireito, valor);
			} else if (no.noEsquerdo != null && no.noDireito != null) {
				System.out.println("  Removeu No " + no.valor);
				no.valor = encontraMinimo(no.noDireito).valor;
				no.noDireito = removeMinimo(no.noDireito);
			} else {
				System.out.println("  Removeu No " + no.valor);
				no = (no.noEsquerdo != null) ? no.noEsquerdo : no.noDireito;
			}
			return no;
		}
	}

	private No<T> removeMinimo(No<T> no) {
		if (no == null) {
			System.out.println("  ERRO ");
		} else if (no.noEsquerdo != null) {
			no.noEsquerdo = removeMinimo(no.noEsquerdo);
			return no;
		} else {
			return no.noDireito;
		}
		return null;
	}

	private No<T> encontraMinimo(No<T> no) {
		if (no != null) {
			while (no.noEsquerdo != null) {
				no = no.noEsquerdo;
			}
		}
		return no;
	}

	protected No<T> buscaPai(Object el) {
		No<T> p = raiz;
		No<T> prev = null;
		while (p != null && !(comparator.compare(p.valor, el) == 0)) { 
			prev = p;
			if (comparator.compare(p.valor, el) > 0)
				p = p.noDireito;
			else
				p = p.noEsquerdo;
		}
		if (p != null && (comparator.compare(p.valor, el) == 0))
			return prev;
		return null;
	}

	public void imprimirArvore() {
		if (isEmpty()) {
			System.out.println("Árvore vazia!");
			return;
		}
		String separator = String.valueOf("  |__");
		System.out.println(this.raiz.valor + "(" + this.getAltura(raiz) + ")");
		imprimirSubArvore(raiz.noEsquerdo, separator);
		imprimirSubArvore(raiz.noDireito, separator);
	}

	private void imprimirSubArvore(No<T> no, String separator) {
		if (no != null) {
			No<T> pai = this.buscaPai(no.valor);
			if (no.equals(pai.noEsquerdo) == true) {
				System.out.println(separator + no.valor + "("
						+ this.getAltura(no) + ")" + " (ESQ)");
			} else {
				System.out.println(separator + no.valor + "("
						+ this.getAltura(no) + ")" + " (DIR)");
			}
			imprimirSubArvore(no.noEsquerdo, "     " + separator);
			imprimirSubArvore(no.noDireito, "     " + separator);
		}
	}

	private static class No<T> {
		private Object valor;
		private No<T> noDireito;
		private No<T> noEsquerdo;

		public No(Object valor) {
			this.valor = valor;
		}
	}

	public static void main(String[] args) {
		ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>(
				(o1, o2) -> ((Integer) o1).compareTo((Integer) o2));
		arvore.inserir(4);
		arvore.inserir(2);
		arvore.inserir(3);
		arvore.inserir(6);
		arvore.inserir(9);
		arvore.inserir(5);
		arvore.imprimirArvore();

	}

}
