package pruebasVarias;

import java.util.Scanner;

public class Cerradura {

	public static void main(String[] args) {

		// Simulacion de cerradura con numeros al azar del 0 al 5. Si los aciertas
		// termina

		int cerradura[] = new int[4];
		int llave[] = new int[4];
		int cont = 0;
		boolean estaAbierto = false;
		System.out.println("Cerradura");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < cerradura.length; i++) {
			cerradura[i] = (int) Math.round(Math.random() * 5);

		}
		do {
			for (int i = 0; i < llave.length; i++) {
				System.out.println("Introduce numero del 0 al 5");
				llave[i] = sc.nextInt();
			}
			System.out.println("Llave");
			for (int i = 0; i < llave.length; i++) {
				System.out.print(llave[i] + " ");
			}
			System.out.println("");
			for (int i = 0; i < llave.length; i++) {
				if (llave[i] == cerradura[i]) {
					cont++;
				}
			}
			if (cont == cerradura.length) {
				estaAbierto = true;
			}
			System.out.println(cont + " de " + cerradura.length);
			if (!estaAbierto) {
				System.out.println("No conseguiste abrir la cerradura");
			}
			cont = 0;
		} while (!estaAbierto);
		for (int i = 0; i < llave.length; i++) {
			System.out.print(cerradura[i] + " ");
		}
		System.out.println("Abriste la cerradura!");
	}
}
