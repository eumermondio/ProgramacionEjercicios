package capitulo05.bloque06;

public class Ejercicio05 {

	public static void main(String[] args) {

		char matrix[][] = new char[10][20];
		int num;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				num = (int) Math.round(Math.random());
				matrix[0][j] = '*';
				matrix[matrix.length - 1][j] = '*';
				matrix[i][0] = '*';
				matrix[i][matrix[i].length - 1] = '*';
				if ((num == 0) && (matrix[i][j] != '*')) {
					matrix[i][j] = '0';
				}
				if ((num == 1) && (matrix[i][j] != '*')) {
					matrix[i][j] = '1';
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			System.out.println("");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
	}

}
