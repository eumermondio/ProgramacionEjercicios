package examenes.examenes20211126;

import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {

		/**
		 * Crea una clase que inicialice un array de 25 posiciones con elementos al azar
		 * entre 0 y 100. Convierte el array en una matriz de 5x5 elementos, para lo que
		 * debes leer los elementos de izquierda a derecha y almacenarlos en la matriz
		 * desde la izquierda a la derecha y de arriba hacia abajo. Si llegas hasta este
		 * punto tendrás una puntuación de 9 sobre 10. Si quieres la máxima nota,
		 * prepárate para recibir arrays cuya longitud sea un cuadrado perfecto (4, 9,
		 * 16, 25, 36, 49, 64, etc.....).
		 */

		int array[] = new int[25];
		int matrix[][] = new int[(int) Math.pow(array.length, 1.0f / 2)][(int) Math.pow(array.length, 1.0f / 2)];
		if (!esCuadrada(matrix, array)) {
			return;
		}
		Ejercicio03.inicializarArrayCien(array);
		Ejercicio01.mostrarArray(array);
		arrayToMatrix(matrix, array);
		System.out.println("");
		mostrarMatrix(matrix);
	}

	public static boolean esCuadrada(int matrix[][], int array[]) {
		int cont = 0;
		boolean esCuadrada = true;

		// Compruebo que la matriz se puede convertir a cuadrado perfecto

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				cont++;
			}
		}
		if (cont != array.length) {
			System.out.println("La matriz no puede ser cuadrado perfecto");
			esCuadrada = false;
		}
		return esCuadrada;
	}

	public static void arrayToMatrix(int matrix[][], int array[]) {
		int k = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = array[k];
				k++;
			}
		}
	}

	public static void mostrarMatrix(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println("");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
	}
}
