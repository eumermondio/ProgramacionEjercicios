package capitulo04.bloque01;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int opcion = 0;
		ArrayPersonas arrayI12[] = new ArrayPersonas[3];
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("0- Salir");
			System.out.println("1- Introducir datos de persona");
			System.out.println("2- Ver las personas introducidas, con todos sus datos");
			System.out.println("Selecciona opción: ");
			opcion = sc.nextInt();
			switch (opcion) {
			case 0:
				break;
			case 1:
				System.out.println("Introducir datos");

				break;
			case 2:
				System.out.println("Mostrar datos");
				break;

			default:
				throw new IllegalArgumentException("Valor no esperado: " + opcion);
			}
		} while (opcion != 0);

	}

}
