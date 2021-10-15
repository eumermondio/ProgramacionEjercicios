package capitulo03.bloque04;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = 0, i = 2;
		boolean primo = true;
		System.out.println("Dime el número que quieras saber si es primo");
		num = sc.nextInt();

		while (i < (num / 2 + 1)) {
			if ((num % i) == 0) {
				primo = false;
				break;
			}
			i++;
		}
		if (primo == true) {
			System.out.println("El número " + num + " es primo");
		} else {
			System.out.println("El número " + num + " es compuesto");
		}
	}

}
