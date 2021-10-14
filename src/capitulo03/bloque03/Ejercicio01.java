package capitulo03.bloque03;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = 1, cont = 0;
		float suma = 0;

		for (; num != 0;) {

			System.out.println("Dame un número");
			num = sc.nextInt();

			if (num != 0) {
				suma += num;
				cont++;
			}

		}

		System.out.println("La suma de los números introducidos es de: " + suma + " la media es de: " + (suma / cont));

	}

}
