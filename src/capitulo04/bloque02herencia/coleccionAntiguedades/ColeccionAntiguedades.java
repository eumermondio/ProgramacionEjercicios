package capitulo04.bloque02herencia.coleccionAntiguedades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ColeccionAntiguedades {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Antiguedad> lista = new ArrayList<Antiguedad>();
		int opcion = 0;

		do {
			System.out.println("\t\tIntroducir productos");
			System.out.println("0.-Salir");
			System.out.println("1.-Introducir productos");
			System.out.println("2.-Ver productos");
			opcion = sc.nextInt();

			switch (opcion) {
			case 0:
				break;
			case 1:
				System.out.println("Array lleno");
				introducirAntiguedades(lista);
				break;
			case 2:
				verAntiguedades(lista);
				break;

			default:
				System.out.println("Valor inesperado: " + opcion);
			}

		} while (opcion != 0);

	}

	private static void verAntiguedades(List<Antiguedad> lista) {
		for (Antiguedad a : lista) {
			System.out.println(a.toString());
		}
	}

	private static void introducirAntiguedades(List<Antiguedad> lista) {
		Scanner sc = new Scanner(System.in);
		int tipo = 0;
		String fecha;
		System.out.println("Tipo de antiguedad ( 0 - 3 )\n0.-Arte 1.-Joya 2.-Coche 3.-Libro");
		tipo = sc.nextInt();
		switch (tipo) {
		case 0:

			break;
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		default:
			System.out.println("Opción no válida " + tipo);
			break;
		}
	}

}
