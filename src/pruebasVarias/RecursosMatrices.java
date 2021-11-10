package pruebasVarias;

public class RecursosMatrices {

//	public static void main(String[] args) {
//
//		int matrix[][] = new int[3][3];
//		inicializarMatriz(matrix);
//		mostrarMatriz(matrix);
//
//	}

	public static void inicializarMatriz(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int) Math.round(Math.random() * 100);
			}
		}
	}

	public static void mostrarMatriz(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
