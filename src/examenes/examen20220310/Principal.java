package examenes.examen20220310;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Principal {
	static List<Persona> personas = new ArrayList<Persona>();
	static List<Tiradas> jugadas = new ArrayList<Tiradas>();
	private static Properties propiedades = null;
	static Scanner sc = new Scanner(System.in);

	public static Properties getPropiedades() {
		if (propiedades == null) {
			propiedades = new Properties();
			try {
				// Otra forma de leer el fichero de propiedades
				File file = new File("./src/examenes/examen20220310/ejemplo.properties");
				propiedades.load(new FileReader(file));

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return propiedades;
	}

	public static void main(String[] args) {

		String nombre = Principal.getProperty("NOMBRE");
		System.out.println(nombre);

//Inicializacion de personas y tiradas
		crearJugadas();
		personas.add(new Persona(0, "A"));
		personas.add(new Persona(0, "B"));
		personas.add(new Persona(0, "C"));
		personas.add(new Persona(0, "D"));

		try {
			juego();
		} catch (MissShootException e) {
			e.printStackTrace();
		}
	}

	public static void juego() throws MissShootException {
		String str;
		int turno = 0, posicion = 0;
		int azar = 0, j, c = 0;
		while (turno < 10) {
			for (int i = 0; i < 3; i++) {
				System.out.println("Jugador: " + personas.get(posicion).getNombre());
				System.out.println("\n\tA que zona quieres tirar?");
				// Muestro las jugadas
				for (j = 0; j < jugadas.size(); j++) {
					System.out.println(
							"Jugada: " + jugadas.get(j).getId() + " con " + jugadas.get(j).getPuntos() + " puntos");
				}
				str = sc.next();
				azar = (int) Math.round(Math.random() * 100);
				if (jugadas.get(Integer.parseInt(str) - 1).getProb() >= azar) {
					personas.get(posicion).setPuntos(
							jugadas.get(Integer.parseInt(str) - 1).getPuntos() + personas.get(posicion).getPuntos());
				} else {
					if (jugadas.get(Integer.parseInt(str) - 1).getId() == 22) {
						throw new MissShootException("Se fallo el tiro");
					}
				}
			}
			posicion++;
			c++;
			if (c == 4) {
				c = 0;
				turno++;
				posicion = 0;
			}

		}
		System.out.println("Fin de la partida");

		System.out.println("\nPUNTOS GENERALES");

		for (Persona p : personas) {
			System.out.println(p);
		}

		int array[] = new int[4];
		for (int i = 0; i < array.length; i++) {
			array[i] = personas.get(i).getPuntos();
		}

		// Ordeno array
		boolean hayIntercambio = true;
		int aux = 0;
		while (hayIntercambio) { // Proceso de ordenación
			hayIntercambio = false;
			for (int k = 0; k < array.length - 1; k++) {
				if (array[k] > array[k + 1]) {
					hayIntercambio = true;
					aux = array[k];
					array[k] = array[k + 1];
					array[k + 1] = aux;
				}
			}

		}

		System.out.println("\nPODIO");
		j = 0;
		for (Persona p : personas) {
			if (array[j] == p.getPuntos()) {
				System.out.println(p);
			}
			j++;
		}
	}

	/**
	 * 
	 */
	public static void crearJugadas() {
		long rnd = 0;
		for (int i = 0; i < 20; i++) {
			rnd = Math.round(Math.random() * (90 - 10) + 10);
			jugadas.add(new Tiradas(rnd, i + 1, i + 1, null));
		}
		rnd = Math.round(Math.random() * (90 - 10) + 10);
		jugadas.add(new Tiradas(rnd, 50, 21, null));
		rnd = Math.round(Math.random() * (90 - 10) + 10);
		jugadas.add(new Tiradas(rnd, 100, 22, null));
	}

	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static String getProperty(String nombrePropiedad) {
		return getPropiedades().getProperty(nombrePropiedad);
	}

}
