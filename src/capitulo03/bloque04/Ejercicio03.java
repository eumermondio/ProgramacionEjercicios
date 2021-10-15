package capitulo03.bloque04;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {

		int cont = 1, num = 1;
		do {
			int i = 0;
			while (i < 10) {

				if (num != 0) {
					System.out.println(num + " x " + cont + " = " + (num * cont));
					cont++;
				}
				if (cont > 10) {
					System.out.println("\n");
				}
				i++;

			}
			cont = 1;
			num++;
		} while (num <= 15);

	}

}
