package capitulo03.bloque04;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {

		int limiteInf = 0, limiteSup = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Limite inferior");
		limiteInf = sc.nextInt();
		
		System.out.println("Limite superior");
		limiteSup = sc.nextInt();

		while (limiteInf < limiteSup) {

			boolean numeroEsPrimo = true;
			int i = 2;
			while (i < limiteInf) {
				if (limiteInf % i == 0) {
					numeroEsPrimo = false;
					break;
				}
				i++;
			}

			if (numeroEsPrimo == true) {
				System.out.println("el número " + limiteInf + " es primo");
			}
			limiteInf++;

		}

	}
}
