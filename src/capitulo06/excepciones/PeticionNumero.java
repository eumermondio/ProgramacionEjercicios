package capitulo06.excepciones;

import java.util.Scanner;

public class PeticionNumero {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			pideNumeroPar();
		} catch (OddNumberException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void pideNumeroPar() throws OddNumberException {
		int x = 0;
		while (true) {
			System.out.println("Mete un número");
			x = sc.nextInt();
			if ((x % 2) != 0) {
				throw new OddNumberException("Número impar detectado: " + x);
			}
		}
	}
}