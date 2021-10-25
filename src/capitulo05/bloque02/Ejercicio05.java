package capitulo05.bloque02;

import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {

		int array[] = new int[5], posi;
		Scanner sc = new Scanner(System.in);
		int i = 0, j = 0;

		for (; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.print(array[i] + " ");
		}

		i = 0;

		System.out.println("\nMover derecha");

		System.out.println("Dime las posis a mover");
		posi = sc.nextInt();
		while (0 < posi) {

			for (; j < array.length; j++) {

				if (j == 0) {
					System.out.print(array[4] + " ");
				}
				System.out.print(array[j] + " ");
				array[j] = array[i];

				if (j == 3) {
					break;
				}
				i++;

			}
			i = 0;
			j = 0;
			posi--;
		}

	}

}
