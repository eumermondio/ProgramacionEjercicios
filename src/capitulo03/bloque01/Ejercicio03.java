package capitulo03.bloque01;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {

		int contadorPositivos = 0, contadorNegativos = 0, repes, num2 = 1, num;
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantas numeros quieres clasificar?");
		repes = sc.nextInt();
		for (int i = 0; i < repes; i++) {
			System.out.println("Dime el numero " + num2++);
			num = sc.nextInt();
			if (num < 0) {
				contadorNegativos++;
			}
			if (num > 0) {
				contadorPositivos++;
			}
			if (num == 0) {
				System.out.println("No vale el 0");
				break;
			}
		}
		System.out.println("Cantidad de números negativos introducidos: " + "" + contadorNegativos
				+ "\nCantidad de números positivos " + "introducidos: " + contadorPositivos);
	}

}
