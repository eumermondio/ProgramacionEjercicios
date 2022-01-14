package capitulo04.bloque02herencia.articulosComestibles;

import java.util.Scanner;

public class Tienda {

	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i = 0;
		Articulos array[] = new Articulos[4];
		int opcion = 0;

		do {
			System.out.println("\t\tIntroducir productos");
			System.out.println("0.-Salir");
			if (i < array.length) {
				System.out.println("1.-Introducir productos");
			}
			System.out.println("2.-Ver productos");
			opcion = sc.nextInt();

			switch (opcion) {
			case 0:
				break;
			case 1:
				if (i >= array.length) {
					System.out.println("Array lleno");
					break;
				}
				i = introducirProductos(array, i);
				break;
			case 2:
				verProductos(array);
				break;

			default:
				System.out.println("Valor inesperado: " + opcion);
			}

		} while (opcion != 0);

	}

	/**
	 * 
	 * @param array
	 */

	private static void verProductos(Articulos[] array) {
		int i12 = 1;
		for (Articulos a : array) {
			if (a == null) {
				System.out.println(i12 + " --> " + "Vacío");
				i12++;
			} else {
					System.out.println(a.toString());
			}
		}
	}

	/**
	 * 
	 * @param array
	 * @param i
	 * @return
	 */

	private static int introducirProductos(Articulos array[], int i) {
		Scanner sc = new Scanner(System.in);
		int tipo = 0;
		float precio = 0;
		String fecha;
		System.out.println("Es perecedero el producto? ( 0 - 1 )\n0.-No\t1.-Sí");
		tipo = sc.nextInt();
		String str, str2, repe;
		if (tipo == 0) {

			System.out.println("Código del producto: ");
			str = sc.next();

			System.out.println("Nombre del producto: ");
			str2 = sc.next();

			System.out.println("Precio del producto: ");
			precio = sc.nextFloat();

			array[i] = new NoPerecederos(str, str2, precio);

		} else {

			System.out.println("Código del producto: ");
			str = sc.next();

			System.out.println("Nombre del producto: ");
			str2 = sc.next();

			System.out.println("Precio del producto: ");
			precio = sc.nextFloat();

			System.out.println("Fecha de caducidad del producto: ");
			fecha = sc.next();

			array[i] = new Perecederos(str, str2, precio, fecha);
		}
		i++;
		System.out.println("Artículo añadido");
		return i;
	}

}
