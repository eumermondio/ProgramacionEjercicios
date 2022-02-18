package examenes.examenes20220218;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EjercicioB {

	private static HashMap<Integer, CromoBaloncesto> hm = new HashMap<Integer, CromoBaloncesto>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion = 0;

		CromoBaloncesto cromo1 = new CromoBaloncesto(1, "Gasol", 700, 567);
		CromoBaloncesto cromo2 = new CromoBaloncesto(2, "Rubio", 800, 57);
		CromoBaloncesto cromo3 = new CromoBaloncesto(3, "Brian", 900, 5670);
		hm.put(cromo1.getId(), cromo1);
		hm.put(cromo2.getId(), cromo2);
		hm.put(cromo3.getId(), cromo3);

		do {
			System.out.println("0.-Salir");
			System.out.println("1.-Visualizar cromos");
			System.out.println("2.-Introducir cromo");
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
				introducirCromos();
				break;
			case 3:
				borrarCromos();
				break;
			case 4:
				verMejorCromo();
				break;
			default:
				System.out.println("Valor no válido: " + opcion);
			}

		} while (opcion != 0);
	}

	/**
	 * 
	 */
	private static void verMejorCromo() {
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
	private static void introducirCromos() {
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

	/**
	 * 
	 */
	private static void verCromos() {
		Iterator<CromoBaloncesto> it = hm.values().iterator();
		while (it.hasNext()) {
			CromoBaloncesto c = (CromoBaloncesto) it.next();
			System.out.println(c);

		}
	}

}
