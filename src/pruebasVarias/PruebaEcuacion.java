package pruebasVarias;

import java.util.Scanner;

public class PruebaEcuacion {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			ecuaciondeSegundoGrado();
		} catch (NoSolutionException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (NumberException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void ecuaciondeSegundoGrado() throws NoSolutionException, NumberException {
		String a1, b1, c1;
		int a, b, c;
		double x;
		System.out.println("Valor de A");
		a1 = sc.next();
		System.out.println("Valor de B");
		b1 = sc.next();
		System.out.println("Valor de C");
		c1 = sc.next();
		if (Character.isDigit(Integer.parseInt(a1)) || Character.isDigit(Integer.parseInt(b1))
				|| Character.isDigit(Integer.parseInt(c1))) {
			throw new NumberException("Valores erróneos");
		}
		a = Integer.parseInt(a1);
		b = Integer.parseInt(b1);
		c = Integer.parseInt(c1);
		x = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
		if (Math.pow(b, 2) - (4 * a * c) < 0) {
			throw new NoSolutionException("La ecuacion no tiene solucion");
		}
		System.out.println("Primera solucion: " + x);
		x = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
		System.out.println("Segunda solucion: " + x);
	}
}
