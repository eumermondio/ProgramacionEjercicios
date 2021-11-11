package capitulo05.bloque05;

import pruebasVarias.*;

public class Ejercicio04 {

	public static void main(String[] args) {

		int matrix[][] = new int[][] { { 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1 }, { 1, 5, 0, 1, 1 }, { 1, 5, 5, 0, 3 },
				{ 1, 3, 3, 2, 0 } };
		boolean esPositivo = true;
		// inicializarMatrizMenosCienACien(matrix);
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

}
