package capitulo07.EjercicioCRUDCompleto;

import java.util.Scanner;

public class Principal {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion = 0;
		do {
			System.out.println("\n0.-Salir del programa");
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
				menuCliente();
				break;
			case 4:
				menuConcesionario();
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
			System.out.println("\n0.-Volver al menú principal");
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
	public static void menuVentas() {
		int opcion = 0;
		do {
			System.out.println("\n0.-Volver al menú principal");
			System.out.println("1.-Listado de ventas");
			System.out.println("2.-Crear una venta");
			System.out.println("3.-Modificar una venta");
			System.out.println("4.-Eliminar una venta");
			opcion = sc.nextInt();
			switch (opcion) {
			case 0:
				break;
			case 1:
				GestionVenta.listarVentas();
				break;
			case 2:
				GestionVenta.crearVentas();
				break;
			case 3:
				GestionVenta.actualizarVentas();
				break;
			case 4:
				GestionVenta.borrarVentas();
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
	public static void menuConcesionario() {
		int opcion = 0;
		do {
			System.out.println("\n0.-Volver al menú principal");
			System.out.println("1.-Listado de concesionarios");
			System.out.println("2.-Crear un concesionario");
			System.out.println("3.-Modificar un concesionario");
			System.out.println("4.-Eliminar un concesionario");
			opcion = sc.nextInt();
			switch (opcion) {
			case 0:
				break;
			case 1:
				GestionConcesionario.listarConcesionario();
				break;
			case 2:
				GestionConcesionario.crearConcesionario();
				break;
			case 3:
				GestionConcesionario.actualizarConcesionario();
				break;
			case 4:
				GestionConcesionario.borrarConcesionario();
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
	public static void menuCliente() {
		int opcion = 0;
		do {
			System.out.println("\n0.-Volver al menú principal");
			System.out.println("1.-Listado de clientes");
			System.out.println("2.-Crear un cliente");
			System.out.println("3.-Modificar un cliente");
			System.out.println("4.-Eliminar un cliente");
			opcion = sc.nextInt();
			switch (opcion) {
			case 0:
				break;
			case 1:
				GestionCliente.listarClientes();
				break;
			case 2:
				GestionCliente.crearClientes();
				break;
			case 3:
				GestionCliente.actualizarClientes();
				break;
			case 4:
				GestionCliente.borrarClientes();
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
			System.out.println("\n0.-Volver al menú principal");
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
