package capitulo05.bloque07;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		int array[] = new int[] { 1, 2, 3, 3, 5, 6, 7 };
		int buscar, sust;
		pruebasVarias.RecursosArrays.mostrarArray(array);
		Scanner sc = new Scanner(System.in);
		System.out.println("\nNúmero a buscar: ");
		buscar = sc.nextInt();
		System.out.println("Número a reemplazar: ");
		sust = sc.nextInt();
		findAndReplace(array, buscar, sust);
		sc.close();
	}

	public static void findAndReplace(int array[], int buscar, int sustituto) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == buscar) {
				array[i] = sustituto;
			}
		}
		pruebasVarias.RecursosArrays.mostrarArray(array);
	}

}
