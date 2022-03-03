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
		String str2 = str.trim();
		int c = 0, d = 0;
		String[] array = str2.split(" ");
		if (str.trim() == "") {
			throw new WhiteSpacesOnlyException("La frase es todo espacios en blanco");
		}
		if (array.length <= 3) {
			throw new ShortPhraseException("La frase es corta");
		}
		for (int i = 0; i < array.length; i++) {
			c++;
			if (array[i].equalsIgnoreCase("bombilla")) {
				c++;
			}
			if (c < 1) {
				throw new BombillaNotFoundException("La frase no contiene la palabra bombilla");
			}
		}

		for (int i = 0; i < array.length; i++) {
			c++;
			if (array[i].equalsIgnoreCase("tonto") || array[i].equalsIgnoreCase("tonta")
					|| array[i].equalsIgnoreCase("idiota")) {
				d++;
			}
			if (d >= 1) {
				throw new BombillaNotFoundException("La frase contiene palabras malsonantes");
			}
		}
	}
}
