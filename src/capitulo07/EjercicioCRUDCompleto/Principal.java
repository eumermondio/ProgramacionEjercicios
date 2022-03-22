package capitulo07.EjercicioCRUDCompleto;

import java.util.Scanner;

public class Principal {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion = 0;
		do {
			System.out.println("\n0.-Salir");
			System.out.println("1.-Gestión de fabricantes");
			System.out.println("2.-Gestión de coches");
			System.out.println("3.-Gestión de clientes");
			System.out.println("4.-Gestión de concesionarios");
			System.out.println("5.-Gestión de ventas");
			opcion = sc.nextInt();
			switch (opcion) {
			case 0:
				break;
			case 1:
				menuFabricante();
				break;
			case 2:
				menuCoches();
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}

		} while (opcion != 0);

	}

	/**
	 * 
	 */
	public static void menuFabricante() {
		int opcion = 0;
		do {
			System.out.println("\n0.-Salir");
			System.out.println("1.-Listado de fabricantes");
			System.out.println("2.-Crear un fabricante");
			System.out.println("3.-Modificar un fabricante");
			System.out.println("4.-Eliminar un fabricante");
			opcion = sc.nextInt();
			switch (opcion) {
			case 0:
				break;
			case 1:
				GestionFabricante.listarFabricantes();
				break;
			case 2:
				GestionFabricante.crearFabricantes();
				break;
			case 3:
				GestionFabricante.actualizarFabricantes();
				break;
			case 4:
				GestionFabricante.borrarFabricantes();
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}

		} while (opcion != 0);
	}

	/**
	 * 
	 */
	public static void menuCoches() {
		int opcion = 0;
		do {
			System.out.println("\n0.-Salir");
			System.out.println("1.-Listado de coche");
			System.out.println("2.-Crear un coche");
			System.out.println("3.-Modificar un coche");
			System.out.println("4.-Eliminar un coche");
			opcion = sc.nextInt();
			switch (opcion) {
			case 0:
				break;
			case 1:
				GestionCoche.listarCoches();
				break;
			case 2:
				GestionCoche.crearCoches();
				break;
			case 3:
				GestionCoche.actualizarCoches();
				break;
			case 4:
				GestionCoche.borrarCoches();
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}

		} while (opcion != 0);
	}

}