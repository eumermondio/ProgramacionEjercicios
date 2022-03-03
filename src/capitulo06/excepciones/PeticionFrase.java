package capitulo06.excepciones;

import java.util.Scanner;

public class PeticionFrase {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			pideFrase();
			System.out.println("Fin con éxito");
		} catch (WhiteSpacesOnlyException e) {
			System.out.println(e.getMessage());
		} catch (ShortPhraseException e) {
			System.out.println(e.getMessage());
		} catch (BombillaNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (BadWordException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void pideFrase()
			throws WhiteSpacesOnlyException, ShortPhraseException, BombillaNotFoundException, BadWordException {
		System.out.println("Dame la frase");
		String str = sc.nextLine();
		if (str.trim() == "") {
			throw new WhiteSpacesOnlyException("La frase es todo espacios en blanco");
		}
	}
}
