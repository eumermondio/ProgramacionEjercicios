package capitulo04.bloque01;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int opcion = 0, i = 0, c = 0;
		boolean estaLlena = false;
		Persona arrayP[] = new Persona[3];
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("0- Salir");
			if (!estaLlena) {
				System.out.println("1- Introducir datos de persona");
			}
			System.out.println("2- Ver las personas introducidas, con todos sus datos");
			System.out.println("Selecciona opción: ");
			opcion = sc.nextInt();
			switch (opcion) {
			case 0:
				break;
			case 1:
				System.out.println("Introducir datos: ");
				String dato = "";
				for (; i < arrayP.length;) {
					if (arrayP[i] == null) {
						arrayP[i] = new Persona();
						System.out.println("Nombre de la persona: ");
						dato = sc.next();
						arrayP[i].setNombre(dato);
						System.out.println("Apellidos de la persona: ");
						dato = sc.next();
						arrayP[i].setApll(dato);
						System.out.println("DNI de la persona: ");
						dato = sc.next();
						arrayP[i].setDni(dato);
						System.out.println("Direccion de la persona: ");
						dato = sc.next();
						arrayP[i].setDireccion(dato);
						System.out.println("Teléfono de la persona: ");
						dato = sc.next();
						arrayP[i].setTlf(dato);
					}
					i++;
					c++;
					estaLlena = c == arrayP.length ? !estaLlena : estaLlena;
					if (estaLlena) {
						System.out.println("Agenda llena");
					}
					break;
				}

				break;
			case 2:
				System.out.println("Mostrar datos: ");
				try {
					for (int j = 0; j < arrayP.length; j++) {
						System.out.println(arrayP[j].toString());
					}
				} catch (Exception e) {
					System.out.println("Agenda vacía");
				}
				break;
			default:
				System.out.println("Valor no esperado: " + opcion);
			}

		} while (opcion != 0);

	}
}
