package capitulo05.bloque03;

public class Ejercicio02 {

	public static void main(String[] args) {
		int array[] = new int[150], aux = 0, j = 1;
		for (int i = 0; i < array.length; i++) { // Inicializar array
			array[i] = (int) Math.round(Math.random() * 1000);
			System.out.print(array[i] + " ");
		}

		System.out.println("");

		for (int i = 1; i < array.length; i++) {
			aux = array[i];
			for (j = i; j > 0 && array[j - 1] > aux; j--) {
				array[j] = array[j - 1];
			}
			array[j] = aux;
		}

		for (int i = 0; i < array.length; i++) { // Visualizar array ordenado
			System.out.print(array[i] + " ");
		}

	}

}
