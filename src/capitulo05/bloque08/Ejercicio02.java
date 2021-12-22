package capitulo05.bloque08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		int opcion = 0, pos = 0, posI = 0, posF = 0;
		String str = "";
		Scanner sc = new Scanner(System.in);
		List<String> lista = new ArrayList<String>();
		List<String> lista2 = new ArrayList<String>();
		do {
			System.out.println("0.-Salir");
			System.out.println("1.-Agregar una línea");
			System.out.println("2.-Insertar línea en una posición");
			System.out.println("3.-Editar una línea");
			System.out.println("4.-Borrar una línea");
			System.out.println("5.-Cortar un conjunto de líneas");
			System.out.println("6.-Pegar un conjunto de líneas");
			System.out.println("7.-Imprimir texto");
			System.out.println("\nDime opción");
			opcion = sc.nextInt();

			switch (opcion) {
			case 0: {
				break;
			}
			case 1: {
				System.out.println("Escribe la línea a agregar");
				str = sc.next();
				agregarLinea(lista, str);
				break;
			}
			case 2: {
				System.out.println("Escribe la línea a agregar");
				str = sc.next();
				System.out.println("Escribe la posición");
				pos = sc.nextInt();
				insertarLinea(lista, str, pos);
				break;
			}
			case 3: {
				editarLinea(lista, str, pos);
				break;
			}
			case 4: {
				System.out.println("Escribe la posición");
				pos = sc.nextInt();
				borrarLinea(lista, pos);
				break;
			}
			case 5: {
				System.out.println("Escribe la posición inicial");
				posI = sc.nextInt();
				System.out.println("Escribe la posición final");
				posF = sc.nextInt();
				cortarLineas(lista, posI, posF, lista2);
				break;
			}
			case 6: {
				System.out.println("Escribe la posición");
				pos = sc.nextInt();
				pegarLineas(lista, pos, lista2);
				break;
			}
			case 7: {
				imprimirTexto(lista);
				break;
			}
			default:
				System.out.println("Opción no válida " + opcion);
			}

		} while (opcion != 0);
		sc.close();
	}

	public static void agregarLinea(List<String> l, String str) {
		l.add(str);
	}

	public static void imprimirTexto(List<String> l) {
		int c = 0;
		for (String s : l) {
			System.out.println(c + "| " + s.toString());
			c++;
		}
	}

	public static void insertarLinea(List<String> l, String str, int pos) {
		l.add(pos, str);
	}

	public static void editarLinea(List<String> l, String str, int pos) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe la posición");
		pos = sc.nextInt();
		System.out.println(l.get(pos).toString());
		System.out.println("Escribe la nueva línea");
		str = sc.next();
		l.set(pos, str);
		sc.close();

	}

	public static void borrarLinea(List<String> l, int pos) {
		l.remove(pos);
	}

	public static void cortarLineas(List<String> l, int posI, int posF, List<String> l2) {
		for (int i = posI; i <= posF; i++) {
			l2.add(l.get(i).toString());
		}
		for (int i = posF; i >= posI; i--) {
			l.remove(i);
		}
	}

	public static void pegarLineas(List<String> l, int pos, List<String> l2) {
		l.addAll(pos, l2);
	}

}
