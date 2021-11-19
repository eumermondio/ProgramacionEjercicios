package capitulo05.bloque07;

import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		int array[] = new int[] { 1, 2, 3, 4, 4, 4, 5, 5, 1, 6, 7 };
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime el número a contar ocs: ");
		int num = sc.nextInt();
		System.out.println("En el array hay: " + countOccurrences(array, num) + " ocurrencias");
		sc.close();
	}

	public static int countOccurrences(int array[], int num) {
		int cont = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num) {
				cont++;
			}
		}
		return cont;
	}

}
