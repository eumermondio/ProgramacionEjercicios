package capitulo03.bloque02;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int repes, num1, num2 = 1, mayor = 0, menor = 0;
		System.out.println("Dime cuantos numeros quieres comparar");
		repes = sc.nextInt();
		for (int i = 0; i < repes; i++) {
			System.out.println("Dime el numero " + num2++);
			num1 = sc.nextInt();
			if (num1 > mayor) {
				mayor = num1;
			}
			if (num1 < mayor) {
				menor = num1;
			}
			
		}
		System.out.println("El número mayor es: " + mayor);
		System.out.println("El número menor es: " + menor);
	}

}
