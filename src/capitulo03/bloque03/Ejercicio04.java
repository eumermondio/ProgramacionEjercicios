package capitulo03.bloque03;

import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = 1, contPos = 0, contNeg = 0;

		for (; num != 0;) {
			System.out.println("Dime un número");
			num = sc.nextInt();
			 if (num == 0) {
				 break;
			 }

			 if (num > 0) {
				 contPos++;
			 }
			 
			 if (num < 0) {
				 contNeg++;
			 }
		}
		System.out.println("Números positivos: " + contPos);
		System.out.println("Números negativos: " + contNeg);
	}

}
