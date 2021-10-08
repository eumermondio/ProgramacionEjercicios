package capitulo03.bloque02;

import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numero, multiplo = 0, multi, limite, numero2;
		System.out.println("De que número quieres saber los múltiplos?");
		numero = sc.nextInt();
		System.out.println("Hasta que multiplo?");
		numero2 = sc.nextInt();
		for (int i = 0; i < numero2; i++) {
			multiplo++;
			multi = numero * multiplo;
			if (multi <= numero2) {
				System.out.println(numero + " por " + multiplo + " = " + multi);
			}
		}
		
	}

}
