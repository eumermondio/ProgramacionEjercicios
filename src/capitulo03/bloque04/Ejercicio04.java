package capitulo03.bloque04;

import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i = (int) Math.pow(2, 7), num;
		System.out.println("Dime el número a pasar a binario (8 bits)");
		num = sc.nextInt();
		
		while (i > 0) {
			if ((num & i) != 0) {
				System.out.print("1");
			} else {
				System.out.print("0");
			}
			i /= 2;
		}
		
		
		
	}

}
