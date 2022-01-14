package capitulo04.bloque02herencia.coleccionAntiguedades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ColeccionAntiguedades {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Antiguedad> lista = new ArrayList<Antiguedad>();
		byte opcion = 0;

		do {
			System.out.println("\t\tIntroducir antiguedades");
			System.out.println("0.-Salir");
			System.out.println("1.-Introducir antiguedades");
			System.out.println("2.-Ver productos");
			opcion = sc.nextByte();

			switch (opcion) {
			case 0:
				break;
			case 1:
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

	/**
	 * 
	 * @param lista
	 */
	private static void introducirAntiguedades(List<Antiguedad> lista) {
		Scanner sc = new Scanner(System.in);
		byte tipo = 0;
		float precio = 0;
		String fabricacion, origen, extra, extra2;
		System.out.println("Tipo de antiguedad ( 0 - 3 )\n0.-Arte 1.-Joya 2.-Coche 3.-Libro");
		tipo = sc.nextByte();

		System.out.println("Introduce fabricacion");
		fabricacion = sc.next();
		System.out.println("Introduce origen");
		origen = sc.next();
		System.out.println("Introduce precio");
		precio = sc.nextFloat();

		switch (tipo) {
		case 0:
			System.out.println("Introduce medida");
			extra = sc.next();
			lista.add(new Arte(fabricacion, origen, precio, extra));
			break;
		case 1:
			System.out.println("Introduce material");
			extra = sc.next();
			lista.add(new Joya(fabricacion, origen, precio, extra));
			break;
		case 2:
			System.out.println("Introduce matricula");
			extra = sc.next();
			lista.add(new Coche(fabricacion, origen, precio, extra));
			break;
		case 3:
			System.out.println("Introduce autor");
			extra2 = sc.next();
			System.out.println("Introduce titulo");
			extra = sc.next();
			lista.add(new Libro(fabricacion, origen, precio, extra, extra2));
			break;
		default:
			System.out.println("Opción no válida " + tipo);
			break;
		}
	}

}
