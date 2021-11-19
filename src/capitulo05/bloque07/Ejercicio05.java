package capitulo05.bloque07;

import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {
		int array[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 3, 4, 2, 1, 4, 5, 5, 5, 5, 5, 3 };
		pruebasVarias.RecursosArrays.mostrarArray(array);
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nNúmero a borrar");
		num = sc.nextInt();
		int array2[] = removeInteger(array, num);
		pruebasVarias.RecursosArrays.mostrarArray(array2);

	}

	public static int[] removeInteger(int array[], int num) {

		int array2[] = new int[array.length - Ejercicio04.countOccurrences(array, num)];
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != num) {
				array2[k] = array[i];
				k++;
			}
		}
		return array2;
	}

}
