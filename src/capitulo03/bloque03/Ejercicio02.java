package capitulo03.bloque03;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = 1, mayor = 0, menor = 0;

		for (int i = 0; num != 0; i++) {

			System.out.println("Dame un número");
			num = sc.nextInt();
			if (num == 0) {
				break;
			}
			if (i == 0) {
				mayor = num;
				menor = num;
			}
			if (num > mayor) {
				mayor = num;
			}
			if (num < menor) {
				menor = num;
			}

		}

		System.out.println("El mayor es: " + mayor + " el menor es: " + menor);

	}

}
