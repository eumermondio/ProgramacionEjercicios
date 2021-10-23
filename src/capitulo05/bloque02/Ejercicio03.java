package capitulo05.bloque02;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {

		int array[] = new int[150], num;
		Scanner sc = new Scanner(System.in);
		System.out.println("Número");
		num = sc.nextInt();
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.print(array[i] + " ");

		}
		System.out.println("");
		for (int i = 0; i < array.length; i++) {
			array[i] *= num;
			System.out.print(array[i] + " ");
		}
		sc.close();

	}

}
