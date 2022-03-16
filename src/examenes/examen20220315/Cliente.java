package examenes.examen20220315;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	public static List<Articulo> articulos = new ArrayList<Articulo>();
	public static Cliente instance = null;

	/**
	 * 
	 * @return
	 */
	public static Cliente getInstance() {
		if (instance == null) {
			instance = new Cliente();
		}
		return instance;
	}

	/**
	 * 
	 */
	public static void crearLista() {
		Magdalena m = new Magdalena(1, "Magdalena", 3, 2, 5);
		Gelatina g = new Gelatina(2, "Gelatina", 1, 1, "Etiqueta");
		Carne c = new Carne(3, "Carne", 9, 4, "Francia");
		Batido b = new Batido(4, "Batido", 5, 3, 7);
		articulos.add(m);
		articulos.add(g);
		articulos.add(c);
		articulos.add(b);

	}

	/**
	 * 
	 * @return
	 */
	public static void modLista(int id) {
		articulos.remove(id);
	}

	/**
	 * 
	 * @return
	 */
	public static List<Articulo> getLista() {
		return articulos;
	}

}
