package examenes.examenes20220218;

import java.util.Iterator;
import java.util.Scanner;

public class EjercicioC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int contadorLetras = 0, contadorMinus = 0, contadorMayus = 0, contadorNumeros = 0;
		System.out.println("Dime la cadena: ");
		String str = sc.nextLine();
		System.out.println("Cadena antes: " + str);
		String str2 = new String(str.trim());
		System.out.println("Cadena despues: " + str2);
		////////////////////////////////////////////
		String[] palabras = str2.split(" ");
		for (int i = 0; i < palabras.length; i++) {
			System.out.println(palabras[i] + " ");
		}
		////////////////////////////////////////////
		for (int i = 0; i < palabras.length; i++) {
			System.out.println("");
			for (int j = 0; j < palabras[i].length(); j++) {
				if (Character.isLetter(palabras[i].charAt(j))) {
					contadorLetras++;
				}
				if (Character.isUpperCase(palabras[i].charAt(j))) {
					contadorMayus++;
				}
				if (Character.isLowerCase(palabras[i].charAt(j))) {
					contadorMinus++;
				}
				if (Character.isDigit(palabras[i].charAt(j))) {
					contadorNumeros++;
				}
			}
			System.out.println("La palabra: " + palabras[i] + " tiene " + contadorLetras + " letras");
			System.out.println("La palabra: " + palabras[i] + " tiene " + contadorMayus + " mayusculas");
			System.out.println("La palabra: " + palabras[i] + " tiene " + contadorMinus + " minusculas");
			System.out.println("La palabra: " + palabras[i] + " tiene " + contadorNumeros + " numeros");

			contadorLetras = 0;
			contadorMayus = 0;
			contadorMinus = 0;
			contadorNumeros = 0;
		}

	}

}
