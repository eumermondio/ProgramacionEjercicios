package capitulo05.bloque07;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		int array[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame número a añadir");
		int num = sc.nextInt();
		int newArray[] = addInteger(array, num);
		pruebasVarias.RecursosArrays.mostrarArray(newArray);
		sc.close();
	}

	public static int[] addInteger(int array[], int num) {
		int newArray[] = new int[array.length + 1];
		for (int i = 0; i < newArray.length; i++) {
			if (i == newArray.length - 1) {
				newArray[i] = num;
				break;
			}
			newArray[i] = array[i];

		}
		return newArray;
	}

}
