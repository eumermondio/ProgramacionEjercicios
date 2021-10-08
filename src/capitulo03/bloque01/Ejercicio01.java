package capitulo03.bloque01;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num, suma = 0;

		for (int i = 0; i < 4; i++) {
			System.out.println("Dime un número");
			num = sc.nextInt();
			if (num >= 10) {
				suma += num;
			}
		}
		System.out.println("La suma de los mayores es: " + suma);
	}

}
