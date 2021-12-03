package examenes.examenes2021203;

public class Ejercicio04 {

	public static void main(String[] args) {

		/**
		 * d. (2,5 puntos) Debes crear una clase Java, con un método “main” que tenga un
		 * array de elementos de tipo ‘char’. El array debe ser el siguiente: [‘H’, ‘o’,
		 * ‘l’, ‘a’, ‘ ’, ‘M’, ‘u’, ‘n’, ‘d’, ‘o’]. A continuación debes crear y usar un
		 * método como este “public static String minúsculas (char frase[])”. El método
		 * recibirá un array de elementos de tipo char y construirá y devolverá un
		 * String en el que estarán todas las letras convertidas en minúsculas. Puedes
		 * apoyarte de la imagen de la tabla Ascii que se adjunta en este documento.
		 */

		char array[] = new char[] { 'H', 'o', 'l', 'a', ' ', 'M', 'u', 'n', 'd', 'o' };
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
		System.out.println(minúsculas(array));

	}

	public static String minúsculas(char frase[]) {
		String str = "";
		int c = 0;

		for (int i = 0; i < frase.length; i++) {
			c = (int) frase[i];
			if (c <= 90 && c >= 65) {
				c += 32;
				frase[i] = (char) c;
			}
		}

		for (int i = 0; i < frase.length; i++) {
			str += frase[i];
		}

		return str;
	}

}
