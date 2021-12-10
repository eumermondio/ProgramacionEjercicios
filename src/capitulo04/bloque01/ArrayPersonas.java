package capitulo04.bloque01;

import java.util.Scanner;

public class ArrayPersonas {

	public Persona array[] = new Persona[3];

	public ArrayPersonas() {
		for (int i = 0; i < array.length; i++) {
			array[i] = new Persona();
		}
	}

	public void guardarPersona() {
		String opcion = "";
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				System.out.println("Nombre de la persona: ");
				opcion = sc.next();
				array[i].setNombre(opcion);
				System.out.println("Apellidos de la persona: ");
				opcion = sc.next();
				array[i].setApll(opcion);
				System.out.println("DNI de la persona: ");
				opcion = sc.next();
				array[i].setDni(opcion);
				System.out.println("Direccion de la persona: ");
				opcion = sc.next();
				array[i].setDireccion(opcion);
				System.out.println("Teléfono de la persona: ");
				opcion = sc.next();
				array[i].setTlf(opcion);
			}
		}
	}

}
