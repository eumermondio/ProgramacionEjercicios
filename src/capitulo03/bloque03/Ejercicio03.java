package capitulo03.bloque03;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cont = 1, num = 1;
		

		for (; num != 0;) {
			System.out.println("Dime el número para saber su tabla");
			num = sc.nextInt();

			for (int i = 0; i < 10; i++) {

				if (num != 0) {
					System.out.println(num + " x " + cont + " = " + (num * cont));
					cont++;
				}
				
			}
			cont = 1;
		}

	}

}
