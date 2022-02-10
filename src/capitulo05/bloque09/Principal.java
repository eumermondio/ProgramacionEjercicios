package capitulo05.bloque09;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {

	private static HashMap<String, Articulo> hm = new HashMap<String, Articulo>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		runApp();
	}

	/**
	 * 
	 */
	public static void runApp() {
		int opcion = 0;
		do {

			System.out.println("0.-Salir");
			System.out.println("1.-Lista de artículos");
			System.out.println("2.-Crear nuevo artículo");
			System.out.println("3.-Eliminar artículo");
			System.out.println("4.-Actualizar artículo");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				verArticulos();
				break;
			case 2:
				crearArticulo();
				break;
			case 3:
				eliminarArticulo();
				break;
			case 4:
				actualizarArticulo();
				break;
			default:
				System.out.println("Valor no válido: " + opcion);
			}

		} while (opcion != 0);
	}

	/**
	 * 
	 */
	private static void actualizarArticulo() {

		
		
	}

	/**
	 * 
	 */
	public static void eliminarArticulo() {
		String cod;
		System.out.println("Código del artículo a eliminar: ");
		cod = sc.next();
		if (hm.get(cod) == null) {
			System.out.println("No existe el artículo");
		} else {
			System.out.println("Artículo de código: " + hm.get(cod).getCod() + " eliminado");
			hm.remove(cod);
		}
	}

	/**
	 * 
	 */
	public static void crearArticulo() {
		String s;
		int estante = 0, stock = 0;
		System.out.println("Código: ");
		s = sc.next();
		System.out.println("Estante: ");
		estante = sc.nextInt();
		System.out.println("Stock: ");
		stock = sc.nextInt();
		Articulo a = new Articulo(s, estante, stock);
		hm.put(a.getCod(), a);
	}

	/**
	 * 
	 */
	public static void verArticulos() {
		Iterator<Articulo> it = hm.values().iterator();
		if (!it.hasNext()) {
			System.out.println("Lista vacía");
		}
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
