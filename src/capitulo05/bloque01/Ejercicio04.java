package capitulo05.bloque01;

import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {

		int array[] = new int[150], num;
		Scanner sc = new Scanner(System.in);
		boolean seEncuentra = false;

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.print(array[i] + " ");
		}
		System.out.println("\nQué número quieres buscar?");
		num = sc.nextInt();

		for (int i = 0; i < array.length; i++) {
			if (array[i] == num) {
				seEncuentra = true;
				break;
			}
		}
		if (seEncuentra == true) {
			System.out.println("Se encontró el " + num + " en el array");
		} else {
			System.out.println("No se encontró el " + num + " en el array");
		}

	}

}
