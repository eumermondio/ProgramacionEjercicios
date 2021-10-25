package capitulo05.bloque02;

public class Ejercicio04 {

	public static void main(String[] args) {

		int array[] = new int[5];
		int i = 0, aux = 4;

		for (; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.print(array[i] + " ");
		}

		i = 0;

		System.out.println("\nMover derecha");

		for (int j = 0; j < array.length; j++) {

			array[j] = array[aux];
			System.out.println(array[j] + " ");
			aux--;
			if (aux == 0) {
				break;
			}
		}

	}

}
