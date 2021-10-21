package examenes.examenes20211021;

import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {
		int num, azar; // Declaro variables
		Scanner sc = new Scanner(System.in);

		System.out.println("Dime un número de 1 cifra");
		num = sc.nextInt(); // Pido el número
		if (num > 9) {
			System.out.println("Número incorrecto");
			return; // Si el numero es mayor que 10 se cierra
		}
		for (int i = 0; i < 99; i++) {
			azar = (int) Math.round(Math.random() * 100); // Creo 100 numeros al azar
			System.out.println(azar);
			if (((azar - num) % 10) == 0) {
				System.out.println(azar + " termina en " + num); //Compruebo si terminan en num
			}
		}

	}

}
