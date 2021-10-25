package capitulo05.bloque02;

import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {
		int array[] = new int[5];
		int i = 0, aux = 0, num;
		Scanner sc = new Scanner(System.in);

		for (; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.print(array[i] + " ");
		}

		System.out.println("\nMover derecha cuanto?");
		num = sc.nextInt();
		while (num > 0) {
			aux = array[array.length - 1];

			for (int j = array.length - 1; j >= 0; j--) {

				if ((j - 1) >= 0) {
					array[j] = array[j - 1];
				}

			}
			array[0] = aux;

			num--;
			sc.close();

		}
		for (int j = 0; j < array.length; j++) {
			System.out.print(array[j] + " ");
		}
	}
}