package examenes.examen20220315;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Caja {
	public static HashMap<Integer, Articulo> compra = new HashMap<Integer, Articulo>();
	public static Caja instance = null;

	/**
	 * 
	 * @return
	 */
	public static Caja getInstance() {
		if (instance == null) {
			instance = new Caja();
		}
		return instance;
	}

	/**
	 * 
	 * @return
	 */
	public static HashMap<Integer, Articulo> getCompra() {
		return compra;
	}

	/**
	 * 
	 */
	public static void setCompra() {
		List<Articulo> articulos = new ArrayList<Articulo>();
		articulos = Cliente.getInstance().getLista();
		for (Articulo a : articulos) {
			compra.put(a.getId(), a);
		}

	}

	/**
	 * 
	 * @param id
	 */
	public static void modCompra(int id) {
		compra.remove(id);
		Cliente.getInstance().modLista(id);

	}

	/**
	 * 
	 * @return
	 */
	public static float calculaTotal(float pago) throws NotEnoughCashException {
		float total = 0;
		Articulo p = null;
		Iterator<Articulo> it = compra.values().iterator();
		while (it.hasNext()) {
			p = it.next();
			total += (p.getPrecioUd() * p.getUds());
		}
		if (pago < total) {
			throw new NotEnoughCashException(pago + " no son suficientes € para pagar una compra de: " + total);
		}
		return total;

	}
}
