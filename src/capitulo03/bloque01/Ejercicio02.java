package capitulo03.bloque01;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num, suma = 0, repes, num2=1;
		System.out.println("Cuantas numeros quieres comparar?");
		repes = sc.nextInt();

		for (int i = 0; i < repes; i++) {
			System.out.println("Dime el número " + num2++);
			num = sc.nextInt();
			if (num >= 10) {
				suma += num;
			}
		}
		System.out.println("La suma de los mayores es: " + suma);
	}

}
