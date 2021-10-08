package capitulo03.bloque02;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numero, multiplo = 0, multi;
		System.out.println("De que número quieres saber los múltiplos?(hasta el 100)");
		numero = sc.nextInt();
		for (int i = 0; i < 100; i++) {
			multiplo++;
			multi = numero * multiplo;
			if (multi <= 100) {
				System.out.println(numero + " por " + multiplo + " = " + multi);
			}
		}
	}

}
