package capitulo03.bloque02;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int repes, num1, num2 = 1;
		float acumulado = 0;
		System.out.println("Dime de cuantos numeros quieres hacer la media");
		repes = sc.nextInt();
		for (int i = 0; i < repes; i++) {
			System.out.println("Dime el número " + num2++);
			num1 = sc.nextInt();
			acumulado += num1;
		}
		System.out.println("La media es : " + acumulado / repes);

	}

}
