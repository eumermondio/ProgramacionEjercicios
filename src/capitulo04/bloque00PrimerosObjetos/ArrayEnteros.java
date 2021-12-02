package capitulo04.bloque00PrimerosObjetos;

import java.util.Arrays;

public class ArrayEnteros {

	private NumeroEntero array[] = new NumeroEntero[100];

	/**
	 * 
	 */
	public ArrayEnteros() {
		for (int i = 0; i < array.length; i++) {
			array[i] = new NumeroEntero();
		}
	}

	public int SumaArrayEnteros() {
		int suma = 0;
		for (int i = 0; i < array.length; i++) {
			suma += this.array[i].getValor();
		}
		return suma;
	}

	public float mediaArrayEnteros() {
		return SumaArrayEnteros() / (float) array.length;
	}

	/**
	 * @param array
	 */
	public ArrayEnteros(NumeroEntero[] array) {
		this.array = array;
	}

	public String toString() {
		return "ArrayEnteros [array=" + Arrays.toString(array) + "]";
	}

	public NumeroEntero[] getArray() {
		return array;
	}

	public void setArray(NumeroEntero[] array) {
		this.array = array;
	}

}
