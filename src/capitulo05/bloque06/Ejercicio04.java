package capitulo05.bloque06;

public class Ejercicio04 {

	public static void main(String[] args) {

		char matrix[][] = new char[10][20];
		int fila, colu;
		fila = (int) Math.round(Math.random() * (8 - 1) + 1);
		colu = (int) Math.round(Math.random() * (18 - 1) + 1);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[0][j] = '*';
				matrix[matrix.length - 1][j] = '*';
				matrix[i][0] = '*';
				matrix[i][matrix[i].length - 1] = '*';
				matrix[fila][colu] = '0';
			}
		}
		Ejercicio02.mostrarMatrizChar(matrix);
	}

}
