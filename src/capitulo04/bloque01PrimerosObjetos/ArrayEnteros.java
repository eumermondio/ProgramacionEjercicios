package capitulo04.bloque01PrimerosObjetos;

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
