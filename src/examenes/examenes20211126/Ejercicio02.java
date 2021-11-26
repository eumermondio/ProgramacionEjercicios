package examenes.examenes20211126;

public class Ejercicio02 {

	public static void main(String[] args) {

		/**
		 * Crea una clase con un método “main” que cree un array de 100 posiciones y
		 * rellene el array con valores al azar entre -100 y 100. Calcula el valor medio
		 * de todos los del array. Calcula el porcentaje de todos números del array que
		 * están debajo del valor medio.
		 */

		int array[] = new int[100];
		inicializarArrayMCien(array);
		Ejercicio01.mostrarArray(array);
		System.out.println("\nMedia del array: " + mediaArray(array));
		System.out.println(
				"Porcentaje de nums por debajo de la media: " + porcentajeDebajoMedia(array, mediaArray(array)) + " %");

	}

	public static void inicializarArrayMCien(int array[]) {
		int limInf = -100, limSup = 100;
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * (limSup - limInf) + limInf);
		}
	}

	public static float mediaArray(int array[]) {
		float media = 0;
		float suma = 0;
		for (int i = 0; i < array.length; i++) {
			suma += array[i];
		}
		media = suma / array.length;
		return media;
	}

	public static float porcentajeDebajoMedia(int array[], float media) {
		float porcentaje = 0, cont = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < media) {
				cont++;
			}
		}
		porcentaje = ((float) (cont * 100) / array.length);
		return porcentaje;
	}

}
