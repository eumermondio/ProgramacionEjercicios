package capitulo05.bloque05;

import java.util.Iterator;

import pruebasVarias.*;

public class Ejercicio04 {

	public static void main(String[] args) {

		int matrix[][] = new int[3][2]; // { { 0, 1, 1, 1, 2 }, { 1, 0, 1, 1, 1 }, { 1, 1, 0, 1, 1 }, { 1, 1, 1, 0, 1 },
		// { 2, 1, 1, 1, 0 } };
		boolean esPositivo = true;
		inicializarMatrizMenosCienACien(matrix);
		RecursosMatrices.mostrarMatriz(matrix);
		esPositivo = comprobarMatrizPositiva(matrix);
		if (esPositivo) {
			System.out.println("Matriz positiva");

		} else {
			System.out.println("Matriz negativa");
		}
		// comprobarMatrizDiagonal(matrix);
		// comprobarMatrizTriangularSuperior(matrix);
		System.out.println("La matriz dispersa: " + comprobarMatrizDispersa(matrix));
		// construirArrayConMatrizCuadrada(matrix);
		System.out.println("La matriz es simetrica: " + comprobarMatrizSimetrica(matrix));
		// realizarMatrizOpuesta(matrix);
		realizarMatrizTraspuesta(matrix);

	}

	public static boolean comprobarMatrizPositiva(int matrix[][]) {
		boolean esPositivo = true;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 0) {
					esPositivo = false;
				}
			}
		}
		return esPositivo;
	}

	public static void inicializarMatrizMenosCienACien(int matrix[][]) {
		int limInf = -100, limSup = 100;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int) Math.round(Math.random() * (limSup - limInf) + limInf);
			}
		}
	}

	public static void comprobarMatrizDiagonal(int matrix[][]) {
		boolean esDiagonal = false;
		int cont = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {

				if (matrix[i][j] != 0) {
					cont++;
				} else {
					cont--;
				}

				if (cont == (~matrix[i].length) + 1) {
					esDiagonal = true;
				}
			}

		}
		if (esDiagonal) {
			System.out.println("La matriz es diagonal");
		} else {
			System.out.println("La matriz no es diagonal");
		}

	}

	public static void comprobarMatrizTriangularSuperior(int matrix[][]) {
		boolean esTriangular = true;

		// Recorro la matriz de la esquina superior izquierda a la inferior derecha

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					esTriangular = false;
				}
			}
		}

		// Recorro la matriz de la esquina superior izquierda a la inferior derecha

		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (matrix[i][j] != 0) {
					esTriangular = false;
				}
			}
		}

		if (esTriangular) {
			System.out.println("La matriz es triangular");
		} else {
			System.out.println("La matriz no es triangular 🤢");
		}
	}

	public static boolean comprobarMatrizDispersa(int matrix[][]) {

		boolean esDispersa = true;
		int cont = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					break;
				}
				if (matrix[i][j] != 0) {
					cont++;
				}

				if (cont == matrix[i].length) {
					esDispersa = false;
					return esDispersa;

				}

			}
			cont = 0;
		}
		return esDispersa;
	}

	public static void construirArrayConMatrizCuadrada(int matrix[][]) {

		int array[] = new int[(int) Math.pow(matrix.length, 2)];
		int k = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				array[k] = matrix[i][j];
				k++;
			}
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static boolean comprobarMatrizSimetrica(int matrix[][]) {
		int k = 0;
		boolean esSimetrica = true;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if ((i != j) && (matrix[i][j] != matrix[j][i])) {
					esSimetrica = false;
					return esSimetrica;
				}
			}
		}
		return esSimetrica;
	}

	public static void realizarMatrizOpuesta(int matrix[][]) {

		for (int i = 0; i < matrix.length; i++) {
			System.out.println("");
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (~matrix[i][j] + 1);
				System.out.print(matrix[i][j] + " ");
			}

		}

	}

	public static int[][] realizarMatrizTraspuesta(int matrix[][]) {

		int matriz[][] = new int[matrix[0].length][matrix.length];
		int aux = matrix[2][1];
		int aux2 = matrix[2][0];

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length - 1; j++) {
				if (i < matriz.length && j < matriz[i].length) {
					//aux = matrix[i][j];
				}

				matriz[j][i] = matrix[i][j];
			}

			
		}
		matriz[matrix[0].length - 1][matrix.length - 1] = aux;
		matriz[matrix[0].length - 2][matrix.length - 1] = aux2;
// Mostrar matriz
		for (int i = 0; i < matriz.length; i++) {
			System.out.println("");
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
		}

		return matriz;
	}
}
