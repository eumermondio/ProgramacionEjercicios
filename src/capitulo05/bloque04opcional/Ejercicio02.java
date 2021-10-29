package capitulo05.bloque04opcional;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int array[] = new int[10], cont = 1, num = 0, inicio, fin;

		for (int i = 0; i < array.length; i++) {
			System.out.println("Dame el número: " + cont);
			num = sc.nextInt();
			array[i] = num;
			cont++;
		}
		cont = 0;
		System.out.println("");
		for (int i = 0; i < array.length; i++) {
			System.out.println("Indice " + cont + " | " + array[i] + " ");
			cont++;
		}

		System.out.println("Dime el inicio: ");
		inicio = sc.nextInt();

		System.out.println("Dime el final: ");
		fin = sc.nextInt();

		sc.close();
	}

}
