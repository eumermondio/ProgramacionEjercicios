package capitulo04.bloque00PrimerosObjetos;

import pruebasVarias.RecursosArrays;

public class NumeroEntero {

	private int valor;

	/**
	 * 
	 */
	public NumeroEntero() {
		this.valor = RecursosArrays.numerosAzar();
	}

	/**
	 * @param valor
	 */
	public NumeroEntero(int valor) {
		this.valor = valor;
	}

	public String toString() {
		return "NumeroEntero [valor=" + valor + "]";
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
