package capitulo05.bloque04opcional;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {

		String array[] = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V",
				"H", "L", "C", "K", "E" };
		Scanner sc = new Scanner(System.in);
		long num, resto;
		do {
			System.out.println("Dime DNI");
			num = sc.nextInt();
		} while (num < 11111111 || num > 99999999);
		resto = num % 23;
		if (resto >= 0 && resto <= 22) {
			for (int i = 0; i < array.length; i++) {
				if (resto == i) {
					System.out.println("DNI Completo: " + num + array[i]);
				}
			}
		}

	}

}
