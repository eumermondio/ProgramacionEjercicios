package capitulo05.bloque08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {

		List<Integer> lista = new ArrayList<Integer>();
		List<Integer> lista2 = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int opcion, min = 0, max = 0, lon = 0, pos = 0;

		do {
			System.out.println("0.-Salir");
			System.out.println("1.-Crear al azar lista de valores");
			System.out.println("2.-Calculo de la media, suma, mayor y menor");
			System.out.println("3.-Agregar una cantidad de valores");
			System.out.println("4.-Eliminar elementos en intervalo");
			System.out.println("5.-Imprimir lista");
			System.out.println("\nDime opción");
			opcion = sc.nextInt();

			switch (opcion) {
			case 0: {
				break;
			}
			case 1: {
				System.out.println("Dame la longitud");
				lon = sc.nextInt();
				System.out.println("Dame el mínimo");
				min = sc.nextInt();
				System.out.println("Dame el máximo");
				max = sc.nextInt();
				crearListaAzar(lista, lon, min, max);
				break;
			}
			case 2: {
				calcularMediaSumaMenorMayor(lista);
				break;
			}
			case 3: {
				System.out.println("Dame la posición");
				pos = sc.nextInt();
				System.out.println("Dame la cantidad de elementos");
				lon = sc.nextInt();
				System.out.println("Dame el mínimo");
				min = sc.nextInt();
				System.out.println("Dame el máximo");
				max = sc.nextInt();
				crearListaAzar(lista2, lon, min, max);
				insertarListas(lista, lista2, pos);
				break;
			}
			case 4: {
				System.out.println("Dame el mínimo");
				min = sc.nextInt();
				System.out.println("Dame el máximo");
				max = sc.nextInt();
				System.out.println("Valores eliminados: " + eliminarElementos(lista, min, max));
				break;
			}
			case 5: {
				imprimirLista(lista);
				break;
			}
			default:
				System.out.println("Opción no válida " + opcion);
			}

		} while (opcion != 0);

	}

	public static void crearListaAzar(List<Integer> l, int lon, int min, int max) {
		l.clear();
		for (int i = 0; i < lon; i++) {
			l.add((int) Math.round(Math.random() * (max - min) + min));
		}
	}

	public static void calcularMediaSumaMenorMayor(List<Integer> l) {
		int menor = 0, mayor = 0, suma = 0;
		menor = l.get(0).intValue();
		mayor = l.get(0).intValue();
		for (int i = 0; i < l.size(); i++) {
			suma += l.get(i).intValue();

			if (mayor < l.get(i).intValue()) {
				mayor = l.get(i).intValue();
			}

			if (menor > l.get(i).intValue()) {
				menor = l.get(i).intValue();
			}
		}
		System.out.println("Suma: " + suma);
		System.out.println("Mayor: " + mayor);
		System.out.println("Menor: " + menor);
		System.out.println("Media: " + (float) suma / l.size());

	}

	public static void insertarListas(List<Integer> l, List<Integer> l2, int pos) {
		l.addAll(pos, l2);
	}

	public static void imprimirLista(List<Integer> l) {
		for (Integer i : l) {
			System.out.print(i.intValue() + " ");
		}
		System.out.println("");
	}

	public static int eliminarElementos(List<Integer> l, int min, int max) {
		int c = 0;
		for (int i = l.size() - 1; i >= 0; i--) {
			if (l.get(i).intValue() >= min && l.get(i).intValue() <= max) {
				l.remove(i);
				c++;
			}
		}
		return c;
	}
}
