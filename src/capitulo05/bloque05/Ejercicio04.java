package capitulo05.bloque05;

import pruebasVarias.*;

public class Ejercicio04 {

	public static void main(String[] args) {

		int matrix[][] = new int[][] { { 1, 1, 1, 1, 1 }, { 0, 5, 1, 1, 1 }, { 0, 0, 9, 1, 1 }, { 0, 0, 0, 4, 3 },
				{ 0, 0, 0, 0, 7 } };
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
		comprobarMatrizTriangular(matrix);

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

	public static void comprobarMatrizTriangular(int matrix[][]) {
		boolean esTriangular = true;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					esTriangular = false;
				}
			}
		}

		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				if (matrix[i][j] == 0) {
					esTriangular = false;
				}
			}
		}

		if (esTriangular) {
			System.out.println("La matriz es triangular");
		} else {
			System.out.println("La matriz no es triangular");
		}
	}

}
