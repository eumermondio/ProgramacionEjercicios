package capitulo05.bloque03;

public class Ejercicio04 {

	public static void main(String[] args) {

		int array[] = new int[150], aux = 0, indiceMenor = 0, j = 1;
		for (int i = 0; i < array.length; i++) { // Inicializar array
			array[i] = (int) Math.round(Math.random() * 1000);
			System.out.print(array[i] + " ");
		}

		System.out.println("");

		for (int i = 0; i < array.length; i++) { //Comprobar menor
			indiceMenor = i;
			for (j = i + 1; j < array.length; j++) {
				if (array[indiceMenor] > array[j]) {
					indiceMenor = j;
				}
			}

			aux = array[i];
			array[i] = array[indiceMenor];
			array[indiceMenor] = aux;

		}

		for (int i = 0; i < array.length; i++) { // Visualizar array ordenado
			System.out.print(array[i] + " ");
		}

	}

}
