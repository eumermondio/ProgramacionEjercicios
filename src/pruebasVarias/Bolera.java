package pruebasVarias;

import java.util.Scanner;

public class Bolera {
	public static void main(String[] args) {
		int array[] = new int[10];
		int seguir = 0, c = 0, ptos = 0;
		boolean vic = false;
		Scanner sc = new Scanner(System.in);

		iniciaJuego(array);
		mostrarJuego(array);

		do {
			c++;
			System.out.println("\n");
			ordenarBolos(array);
			System.out.println("Tirada: " + c);
			System.out.println("Seguir: 1-Sí, 0-No?");
			seguir = sc.nextInt();
			if (seguir == 0) {
				break;
			}
			tirada(array);
			ordenarBolos(array);
			ptos += puntos(array, c);
			System.out.println("Puntos: " + ptos);
			vic = victoria(array);
		} while (!vic);

		System.out.println("Game Over");

	}

	public static int[] iniciaJuego(int array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = 1;
		}
		return array;
	}

	public static void ordenarBolos(int array[]) {
		int k = 0;
		for (int i = 4; i >= 0; i--) {
			System.out.println("");
			if (i == 3) {
				System.out.print(" ");
			}
			if (i == 2) {
				System.out.print("  ");
			}
			if (i == 1) {
				System.out.print("   ");
			}
			for (int j = i; j > 0; j--) {
				System.out.print(array[k] + " ");
				k++;
			}
		}
	}

	public static void mostrarJuego(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static int puntos(int array[], int tirada) {
		int ptos = 10, c = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				c++;
			}
		}

		for (int i = tirada; i > 1; i--) {
			if (tirada != 1) {
				ptos /= 2;
			}

		}
		if (tirada == 1) {
			return ptos * c;
		}
		return ptos * c;
	}

	public static boolean victoria(int array[]) {
		boolean vic = false;
		int c = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				c++;
			}
		}
		if (c == array.length) {
			vic = true;
		}
		return vic;
	}

	public static void tirada(int array[]) {
		int num = 0;
		for (int i = 0; i < array.length; i++) {
			num = (int) Math.round(Math.random() * 100);
			if (num < 50) {
				array[i] = 0;
			}
		}
	}

}
