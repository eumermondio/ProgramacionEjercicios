package pruebasVarias;

public class PruebaEj4Matrix {

	public static void main(String[] args) {

		int matrix[][] = new int[3][3];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (j != 0) {
					matrix[i][j] = randomNumCeroMil();
				} else {
					matrix[i][j] = randomNumCeroMil();
				}
			}
		}

		RecursosMatrices.mostrarMatriz(matrix);
		comprobarIgualesFilas(matrix);
		posicionMayorMenor(matrix);
	}

	public static int randomNumCeroMil() {
		int num;
		num = (int) Math.round(Math.random() * 1000);
		return num;
	}

	public static void posicionMayorMenor(int matrix[][]) {
		int mayor = 0, mayor2 = 0, menor2 = 0, menor = 0;
		int mayorAc, menorAc;
		mayorAc = matrix[0][0];
		menorAc = matrix[0][0];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > mayorAc) {
					mayor = i;
					mayor2 = j;
				}
				if (matrix[i][j] < menorAc) {
					menor = i;
					menor2 = j;
				}
			}
		}

		System.out.println("Mayor i: " + mayor + " Menor i: " + menor);
		System.out.println("Mayor j: " + mayor2 + " Menor j: " + menor2);
	}

	public static void comprobarIgualesFilas(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (j > 0) {
					int k = j;
					while (k > 0) {
						if (matrix[i][k - 1] == matrix[i][j]) {
							matrix[i][j] = randomNumCeroMil();
						}
						k--;
					}
				}
			}
		}

		RecursosMatrices.mostrarMatriz(matrix);
	}

}
