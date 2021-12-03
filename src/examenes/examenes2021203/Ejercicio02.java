package examenes.examenes2021203;

public class Ejercicio02 {

	public static void main(String[] args) {

		/**
		 * b. (2,5 puntos) Crea una clase con un método “main” que cree un array de 5
		 * posiciones con números generados al azar entre 0 y 100. Muestra el array.
		 * Crea un nuevo array de 5 posiciones en el que copies los números del primer
		 * array en posiciones aleatorias del segundo array. No puedes repetir números
		 * del primer array en el segundo array.
		 */

		int array[] = new int[5];
		int array1[] = new int[5];
		inicializaArray(array);
		System.out.println("Array:");
		muestraArray(array);
		copiarArray(array, array1);
		System.out.println("\nArray 1 copiado:");
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + " ");
		}
		desordenaArray(array1);
		System.out.println("\nArray 1 desordenado:");
		muestraArray(array1);

	}

	public static void inicializaArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
		}
	}

	public static int[] copiarArray(int array[], int array1[]) {
		for (int i = 0; i < array.length; i++) {
			array1[i] = array[i];
		}
		return array1;
	}

	public static void desordenaArray(int array[]) {
		int aux = array[0];
		for (int i = 0; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[array.length - 1] = aux;
	}

	public static void muestraArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
