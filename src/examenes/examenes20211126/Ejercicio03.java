package examenes.examenes20211126;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {

		/**
		 * Crea una clase con un método “main” que cree un array de 10 posiciones y
		 * rellene con valores al azar entre 0 y 100. Pide al usuario que indique una
		 * posición del array. Elimina el elemento del array cuya posición sea la
		 * indicada por el usuario. Desplaza todos los elementos, que se encuentren a la
		 * derecha de la posición indicada, un lugar a la izquierda. Completa el hueco
		 * del último elemento con un valor al azar.
		 */

		int array[] = new int[10];
		int pos;
		inicializarArrayCien(array);
		Ejercicio01.mostrarArray(array);
		Scanner sc = new Scanner(System.in);
		System.out.println("\nDime una posi del array: ");
		pos = sc.nextInt();

		// Eliminar el valor del array

		for (int i = 0; i < array.length; i++) {
			if (pos == i) {
			} else {
				array[i] = array[i];
			}
		}

//Mover los valores

		for (int i = pos; i < array.length; i++) {
			if (i < array.length - 1) {
				array[i] = array[i + 1];
			}
			if (i == array.length - 1) {
				array[i] = (int) Math.round(Math.random() * 100);
			}
		}

		Ejercicio01.mostrarArray(array);

	}

	public static void inicializarArrayCien(int array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
		}
	}
}
