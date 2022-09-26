package pruebasVarias;

import java.util.Scanner;

public class PruebaInicialCristian {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

//		ejercicio1();
//		ejercicio2();
//		ejercicio3();
//		ejercicio4();
//		ejercicio5();
//		ejercicio6();
//		ejercicio7();
//		ejercicio8();
//		ejercicio9();
		ejercicio10();

	}

	private static void ejercicio7() {
		int suma = 0, num = 0, c = 0;
		float media = 0;
		do {
			System.out.println("Dame un numero");
			num = sc.nextInt();
			suma += num;
			if (num == 0) {
				break;
			}
			c++;
		} while (true);
		media = suma / (float) c;
		System.out.println(media);
	}

	private static void ejercicio6() {
		for (int i = 1; i <= 3000; i++) {
			if ((i % 3) == 0) {
				System.out.println(i + " es multiplo de 3");
			}
		}
	}

	private static void ejercicio8() {
		for (int i = 0; i < 255; i++) {
			System.out.println((char) i);
		}
	}

	private static void ejercicio5() {
		int suma = 0;
		for (int i = 0; i < 8; i++) {
			System.out.println("Dame un numero");
			suma += sc.nextInt();
		}
		System.out.println(suma);
	}

	private static void ejercicio4() {
		do {
			System.out.println("Dame un numero");
		} while (sc.nextInt() != 0);
	}

	private static void ejercicio9() {
		System.out.println("Dame un numero");
		int num = sc.nextInt();
		int fact = 1;
		for (int i = 2; i <= num; i++) {
			fact *= i;
		}
		System.out.println("El factorial de " + num + " es " + fact);
	}

	private static void ejercicio10() {
		int num = 0, mayor = 0, menor = 9999;
		do {
			System.out.println("Dame un numero");
			num = sc.nextInt();
			if (num < 0) {
				break;
			}
			if (mayor < num) {
				mayor = num;
			}
			if (menor > num) {
				menor = num;
			}
			System.out.println("Mayor: " + mayor + "\nMenor: " + menor);
		} while (num != 0);
	}

	private static void ejercicio3() {
		int array[] = new int[3];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Dame un numero");
			array[i] = sc.nextInt();
		}
		int mayor = array[0];
		for (int i = 0; i < array.length; i++) {
			if (mayor < array[i]) {
				mayor = array[i];
			}
		}
		System.out.println("El mayor es: " + mayor);
	}

	private static void ejercicio2() {
		System.out.println("Dame un numero");
		if ((sc.nextInt() % 2) == 0) {
			System.out.println("El numero es par");
		} else {
			System.out.println("El numero es impar");
		}
	}

	private static void ejercicio1() {
		int x = 0, y = 0;
		System.out.println("Dame un numero");
		x = sc.nextInt();
		System.out.println("Dame un numero");
		y = sc.nextInt();
		if (x == y) {
			System.out.println("Son iguales");
		} else {
			if (x > y) {
				System.out.println("El numero más grande es: " + x);
			} else {
				System.out.println("El numero más grande es: " + y);
			}
		}
	}

}
