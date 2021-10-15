package capitulo03.bloque04;

import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {

		int num = 0, i = 1;
		double factorial = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("De qué número quieres saber el factorial?");
		num = sc.nextInt();

		while (i < num) {
			factorial *= num;
			num--;
		}
		System.out.println("El factorial es: " + factorial);

	}

}
