package pruebasVarias;

import java.util.Date;
import java.util.Scanner;

public class FuerzaBrutaString {

	public static void main(String[] args) {

		int longitudClave = 0, cont = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime la longitud de tu clave");
		longitudClave = sc.nextInt();
		char[] alfabetoMinuscula = new char[26];
		char[] alfabetoMayuscula = new char[26];
		char[] clave = new char[longitudClave];
		int[] indicesRandom = new int[longitudClave];
		int[] indicesRandomDos = new int[longitudClave];
		char[] romper = new char[longitudClave];
		boolean claveRota = false;

		for (char i = 'A'; i <= 'Z'; i++) {
			alfabetoMayuscula[i - 'A'] = i;
		}
		for (int i = 0; i < alfabetoMayuscula.length; i++) {
			System.out.print(alfabetoMayuscula[i] + " ");

		}

		System.out.println("");

		for (char i = 'a'; i <= 'z'; i++) {
			alfabetoMinuscula[i - 'a'] = i;
		}

		System.out.println("");

		for (int i = 0; i < alfabetoMayuscula.length; i++) {
			System.out.print(alfabetoMinuscula[i] + " ");

		}

		System.out.println("");

		for (int i = 0; i < indicesRandom.length; i++) {
			indicesRandom[i] = obtenerNumeroAzar(longitudClave);
		}

		System.out.println("");

		for (int i = 0; i < indicesRandom.length; i++) {
			System.out.print(indicesRandom[i] + " ");
		}

		for (int i = 0; i < clave.length; i++) {
			if ((i & 1) == 0) {
				clave[i] = alfabetoMayuscula[indicesRandom[i]];
			} else {
				clave[i] = alfabetoMinuscula[indicesRandom[i]];
			}
		}
		System.out.println("");
		System.out.println("La clave es: \n");

		for (int i = 0; i < clave.length; i++) {
			System.out.print(clave[i] + " ");
		}
		System.out.println("\n");
		// Romper cadena de caracteres

		long millisDesde1970 = new Date().getTime();

		do {

			for (int i = 0; i < clave.length; i++) {
				for (int j = 0; j < longitudClave; j++) {
					indicesRandomDos[i] = obtenerNumeroAzar(longitudClave);
					if ((i & 1) == 0) {
						romper[i] = alfabetoMayuscula[indicesRandomDos[i]];
					} else {
						romper[i] = alfabetoMinuscula[indicesRandom[i]];
					}

					System.out.print(romper[i] + " ");
				}
				System.out.println("");

				if (clave[i] == romper[i]) {
					cont++;
				} else {
					i--;
				}
			}

			if (cont == longitudClave) {
				claveRota = true;
			}
			if (!claveRota) {
				System.out.println("No descifrada");
			}
			cont = 0;
		} while (!claveRota);

		System.out.println("Descifrado");
		System.out.println("");
		for (int i = 0; i < romper.length; i++) {
			System.out.print(romper[i] + " ");
		}

		long millisDespuesDeBusquedaPrimos = new Date().getTime();

		long restaDeMillis = millisDespuesDeBusquedaPrimos - millisDesde1970;
		System.out.println("");
		System.out.println("He tardado " + restaDeMillis + " milisegundos - " + (restaDeMillis / 1000) + " segundos");
	}

	public static int obtenerNumeroAzar(int longitudClave) {
		int array[] = new int[longitudClave], numero = 0;
		for (int i = 0; i < array.length; i++) {
			numero = (int) Math.round(Math.random() * 25);
		}
		return numero;
	}
}
