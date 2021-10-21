package examenes.examenes20211021;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		int num = 0, limSup = 1, limInf = -1, i = 0; //Declaro variables
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime el límite inferior");
		limInf = sc.nextInt(); // Pido limite inferior
		System.out.println("Dime el límite superior");
		limSup = sc.nextInt();
		while (limInf < 0 && limSup > 0) //Mientras se cumpla que limInf negativo y limSup positivo
		while (i < 9) {
			num = (int) Math.round(Math.random() * (limSup - limInf) + limInf);
			System.out.println("Número: " + num + " generado"); //Impresion de numeros al azar
			i++;
		}
		
	}
}
