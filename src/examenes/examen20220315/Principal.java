package examenes.examen20220315;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Principal {
	private static Properties propiedades = null;
	static Scanner sc = new Scanner(System.in);
	static List<Articulo> articulos = new ArrayList<Articulo>();
	static HashMap<Integer, Articulo> compra = new HashMap<Integer, Articulo>();

	/**
	 * 
	 * @return
	 */
	public static Properties getPropiedades() {
		if (propiedades == null) {
			propiedades = new Properties();
			try {
				// Otra forma de leer el fichero de propiedades
				File file = new File("./src/examenes/examen20220315/ejemplo.properties");
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
		Cliente cliente = new Cliente();
		Caja caja = new Caja();
		cliente.crearLista();
		articulos = cliente.getLista();
		for (Articulo a : articulos) {
			System.out.println(a.getDescripcion());
		}
		caja.setCompra();
		compra = caja.getCompra();
		System.out.println("\n\n\n");
		Iterator<Articulo> it = compra.values().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("\nQue articulo vas a borrar?");
		String opcion = sc.next();
		caja.modCompra(Integer.parseInt(opcion));
		System.out.println("\n");
		Iterator<Articulo> it2 = compra.values().iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}

		System.out.println("Cuanto vas a pagar?");
		String pago = sc.next();
		try {
			System.out.println("Total: " + caja.calculaTotal(Integer.parseInt(pago)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (NotEnoughCashException e) {
			e.printStackTrace();
		}

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
