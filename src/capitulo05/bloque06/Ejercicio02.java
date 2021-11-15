package capitulo05.bloque06;

public class Ejercicio02 {

	public static void main(String[] args) {

		char matrix[][] = new char[10][30];
		int num = 0;
		for (int i = 0; i < matrix.length; i++) {
			num = (int) Math.round(Math.random() * 29);
			for (int j = 0; j < matrix[i].length; j++) {
				if (j < num) {
					matrix[i][j] = '*';
				} else {
					matrix[i][j] = ' ';
				}
			}
		}

		mostrarMatrizChar(matrix);

	}

	public static void mostrarMatrizChar(char matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println("");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
		}
	}

}
