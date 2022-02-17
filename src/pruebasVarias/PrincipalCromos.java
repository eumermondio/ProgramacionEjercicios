package pruebasVarias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrincipalCromos {

	private static HashMap<Integer, CromoBaloncesto> hm = new HashMap<Integer, CromoBaloncesto>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		runApp();
	}

	public static void runApp() {

		int opcion = 0;

		for (int i = 0; i < 3; i++) {
			hm.put(i, new CromoBaloncesto(i, null, i, i));
		}

		do {
			System.out.println("0.-Salir");
			System.out.println("1.-Ver cromos");
			System.out.println("2.-Meter cromos");
			System.out.println("3.-Borrar cromo");
			System.out.println("4.-Imprimir el jugador con mas puntos");
			System.out.println("Dame una opción: ");
			opcion = sc.nextInt();

			switch (opcion) {
			case 0:
				break;
			case 1:
				verCromos();
				break;
			case 2:
				meterCromos();
				break;
			case 3:
				borrarCromos();
				break;
			case 4:
				mejorCromo();
				break;
			default:
				System.out.println("Valor no válido: " + opcion);
			}

		} while (opcion != 0);
	}

	/**
	 * 
	 */
	private static void mejorCromo() {
		Iterator<CromoBaloncesto> it = hm.values().iterator();
		float mayor = 0;
		CromoBaloncesto c = null;
		List<CromoBaloncesto> puntos = new ArrayList<CromoBaloncesto>();
		while (it.hasNext()) {
			puntos.add(it.next());
		}
		mayor = puntos.get(0).getPuntos();
		for (int i = 0; i < puntos.size(); i++) {
			if (mayor < puntos.get(i).getPuntos()) {
				mayor = puntos.get(i).getPuntos();
				c = puntos.get(i);
			}
		}
		System.out.println("El mejor cromo es: " + c + " con " + mayor + " puntos");
	}

	/**
	 * 
	 */
	private static void borrarCromos() {
		int x;
		System.out.println("Dame id: ");
		x = sc.nextInt();
		hm.remove(x);
	}

	/**
	 * 
	 */
	private static void meterCromos() {
		String s;
		int x;
		CromoBaloncesto c = new CromoBaloncesto();
		System.out.println("Dame id: ");
		x = sc.nextInt();
		c.setId(x);
		System.out.println("Dame nombre: ");
		s = sc.next();
		c.setNombre(s);
		System.out.println("Dame rebotes: ");
		x = sc.nextInt();
		c.setRebotes(x);
		System.out.println("Dame puntos: ");
		x = sc.nextInt();
		c.setPuntos(x);
		hm.put(c.getId(), c);
	}

	private static void verCromos() {
		Iterator<CromoBaloncesto> it = hm.values().iterator();
		while (it.hasNext()) {
			CromoBaloncesto c = (CromoBaloncesto) it.next();
			System.out.println(c);

		}
	}

}
