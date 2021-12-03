package examenes.examenes2021203;

public class Ejercicio03 {

	public static void main(String[] args) {

		/**
		 * c. (2,5 puntos) Serie de Rafanacci. Explicación: el ejercicio recuerda a la
		 * serie de Fibonacci, en la que cada número era la suma de los dos anteriores,
		 * quedando 1 -> 1 -> 2 -> 3 -> 5 -> 8 -> 13....; en la serie de Rafanacci cada
		 * número será la multiplicación de los dos anteriores, más la mitad del número
		 * inmediatamente anterior, quedando 1 -> (0*1)+0,5 = 0,5 -> (1*0,5) + 0,25 =
		 * 0,75 -> (0,5*0,75) + 0,365 = 0,74 ............... Crea una clase Java con un
		 * método “main” que introduzca en un array los 10 primeros términos de la serie
		 * de Rafanacci
		 */

		float array[] = new float[10];
		int k = 0;
		System.out.println("Inicialización de los dos primeros");
		for (int i = 2; i > 0; i--) {
			array[k] = i / 2f;
			System.out.print(array[k] + " ");
			k++;
		}

		for (int i = 2; i < array.length; i++) {
			array[i] = (array[i - 1] * array[i - 2]) + (array[i - 1] / 2f);
		}

		System.out.println("");

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

}
