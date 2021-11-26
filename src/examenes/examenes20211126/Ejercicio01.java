package examenes.examenes20211126;

public class Ejercicio01 {

	public static void main(String[] args) {

		/**
		 * Crea una clase con un método “main” que cree 10 números al azar, almacenando
		 * 5 en un primer array y 5 para un segundo array. Muestra los arrays en
		 * pantalla usando un método que debes crear en esta clase. Crea un nuevo array
		 * de 5 posiciones, que debes rellenar calculando la media de los números que
		 * ocupan la misma posición en los dos primeros arrays y almacenando dichas
		 * medias en la posición correspondiente del tercer array. Muestra el tercer
		 * array en pantalla.
		 */

		int array[] = new int[5];
		int array2[] = new int[5];
		float nuevoArray[] = new float[5];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			array2[i] = (int) Math.round(Math.random() * 100);
		}
		mostrarArray(array);
		System.out.println("");
		mostrarArray(array2);
		System.out.println("\nTercer array con la media de los dos otros arrays");
		for (int i = 0; i < nuevoArray.length; i++) {
			float media = 0;
			media = (array[i] + (float) array2[i]) / 2;
			nuevoArray[i] = media;
		}
		mostrarArrayFloat(nuevoArray);

	}

	public static void mostrarArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void mostrarArrayFloat(float array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
