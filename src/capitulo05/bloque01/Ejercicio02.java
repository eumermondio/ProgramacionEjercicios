package capitulo05.bloque01;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {

		int array[] = new int[150], limInf, limSup;
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime el límite inferior");
		limInf = sc.nextInt();
		System.out.println("Dime el límite superior");
		limSup = sc.nextInt();
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random()*(limSup - limInf) + limInf);
			System.out.print(array[i] + " ");
		}
		
	}

}
