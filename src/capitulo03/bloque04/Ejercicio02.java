package capitulo03.bloque04;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {

		int limiteInf = 0, limiteSup = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Dime el límite inferior");
		limiteInf = sc.nextInt();
		System.out.println("Dime el límite superior");
		limiteSup = sc.nextInt();

		for (int numero = 2; numero < limiteInf; numero++) {

			boolean numeroEsPrimo = true;
			if (limiteSup >= limiteInf) {
				for (int i = 2; i < (numero / 2 + 1); i++) {
					if (numero % i == 0) {
						numeroEsPrimo = false;
						break;
					}
				}
			}

			if (numeroEsPrimo == true) {
				System.out.println("el número " + numero + " es primo");
			}

		}
	}

}

// PREGUNTAR EN CLASE
