package capitulo06.wrappersyproperties;

import java.util.Scanner;

public class Ejercicio02 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String pass = "";
		boolean hayMayus = false, hayMinus = false, hayNum = false, haySimbolo = false, valida = false;
		do {
			System.out.println("Escribe la pass");
			pass = sc.next();
			for (int i = 0; i < pass.length(); i++) {
				if (Character.isUpperCase(pass.charAt(i))) {
					hayMayus = true;
				}
				if (Character.isLowerCase(pass.charAt(i))) {
					hayMinus = true;
				}
				if (Character.isDigit(pass.charAt(i))) {
					hayNum = true;
				}
				if (!Character.isDigit(pass.charAt(i)) && !Character.isLetter(pass.charAt(i))) {
					haySimbolo = true;
				}
				if (hayMayus && hayMinus && hayNum && haySimbolo) {
					valida = true;
				}
			}
			haySimbolo = false;
			hayMayus = false;
			hayNum = false;
			hayMinus = false;
		} while (!valida);
		System.out.println("Pass valida: " + pass);
	}

}
