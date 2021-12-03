package examenes.examenes2021203;

public class Ejercicio01 {

	public static void main(String[] args) {

		/**
		 * a. (2,5 puntos) Crea una clase con un método “main” que cree una matriz
		 * cuadrada de 4x4 con los siguientes datos [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10,
		 * 11, 12], [13, 14, 15, 16]]. Debes crear y usar un método que reciba como
		 * argumento de entrada una matriz cuadrada y devuelva true si todos los
		 * elementos están ordenados en un orden de lectura de izquierda a derecha y de
		 * arriba hacia abajo. Si los elementos no están ordenados se debe devolver un
		 * valor false.
		 */

		int matrix[][] = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		mostrarMatriz(matrix);
		System.out.println("\nLa matrix ordenada: " + ordenada(matrix));

	}

	public static void mostrarMatriz(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println("");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
	}

	public static boolean ordenada(int matrix[][]) {
		boolean ordenada = false;
		boolean hayIntercambio = true;
		int array[] = new int[matrix.length * matrix[0].length];
		int k = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				array[k] = matrix[i][j];
				k++;
			}
		}
		System.out.println("");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		while (hayIntercambio) { // Proceso de ordenación
			hayIntercambio = false;
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					ordenada = false;
					return ordenada;
				}
			}

		}
		ordenada = true;
		return ordenada;
	}
}
