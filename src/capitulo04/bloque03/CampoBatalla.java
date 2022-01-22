package capitulo04.bloque03;

import java.util.Arrays;

public class CampoBatalla {
	private String nombre;
	private Malvado arrayM[] = new Malvado[20];
	private Humano arrayH[] = new Humano[20];
	private byte disparosMalvados = 0;
	private byte disparosHumanos = 0;

	// Instancia estática
	private static CampoBatalla instance = null;

	// Getter de la instancia estática
	public static CampoBatalla getInstance() {
		if (instance == null) {
			instance = new CampoBatalla();
		}
		return instance;
	}

	/**
	 * 
	 * @param array
	 */
	public void mezclarArray(Personaje array[]) {
		byte random = 0;
		Personaje aux = null;
		for (int i = 0; i < array.length; i++) {
			random = (byte) Math.round(Math.random() * array.length - 2);
			if (random < 0 || random > 18) {
				i--;
				break;
			}
			aux = array[random];
			array[random] = array[random + 1];
			array[random + 1] = aux;
		}
	}

	/**
	 * 
	 */
	public void batalla() {
		boolean algunVivo = true;
		byte mayor = 0, indiceMasDificil = 0;
		Humano primerHumanoVivo = null;
		Malvado primerMaloVivo = null;
		byte arrayStatsMalvados[] = new byte[20];
		byte arrayStatsHumanos[] = new byte[20];

		do {
			primerHumanoVivo = (Humano) instance.getPrimerPersonajeVivo(arrayH);
			primerMaloVivo = (Malvado) instance.getPrimerPersonajeVivo(arrayM);

			for (int i = 0; i < arrayH.length; i++) {
				System.out.println(arrayH[i].toString());
			}
			System.out.println("");
			for (int i = 0; i < arrayM.length; i++) {
				System.out.println(arrayM[i].toString());
			}
			System.out.println("");

//			System.out.println(primerHumanoVivo.toString());
//			System.out.println(primerMaloVivo.toString());
//			System.out.println("");

			instance.dispara(primerHumanoVivo, primerMaloVivo, arrayStatsMalvados, arrayStatsHumanos);

			if (instance.getPrimerPersonajeVivo(arrayH) == null) {
				algunVivo = false;
				System.out.println("Ganan los malvados");
				// System.out.println("Disparos necesarios para matar los humanos: " +
				// disparosMalvados);
			}
			if (instance.getPrimerPersonajeVivo(arrayM) == null) {
				algunVivo = false;
				System.out.println("Ganan los humanos");
				// System.out.println("Disparos necesarios para matar los malvados: " +
				// disparosHumanos);
			}
			// Ver el mas dificil de matar
			for (byte i = 0; i < arrayStatsHumanos.length; i++) {
				mayor = arrayStatsHumanos[0];
				if (mayor < arrayStatsHumanos[i]) {
					mayor = arrayStatsHumanos[i];
					indiceMasDificil = i;
				}
			}

			System.out.println("Humano más dificil de matar: " + arrayH[indiceMasDificil].toString() + " con " + mayor
					+ " disparos necesarios para morir");
			mayor = 0;
			indiceMasDificil = 0;

			for (byte i = 0; i < arrayStatsMalvados.length; i++) {
				mayor = arrayStatsMalvados[0];
				if (mayor < arrayStatsMalvados[i]) {
					mayor = arrayStatsMalvados[i];
					indiceMasDificil = i;
				}
			}

			System.out.println("Malvado más dificil de matar: " + arrayM[indiceMasDificil].toString() + " con " + mayor
					+ " disparos necesarios para morir");

		} while (algunVivo);
	}

	/**
	 * 
	 * @param h
	 * @param m
	 */
	public void dispara(Humano h, Malvado m, byte arrayStatsMalvados[], byte arrayStatsHumanos[]) {
		byte damage = 0;
		int i = 0, j = 0;
		damage = (byte) Math.round(Math.random() * (25 - 5) + 5);
		m.setVida(m.getVida() - damage);
		disparosMalvados = contadorDisparos(disparosMalvados);
		if (m.getVida() <= 0) {
			m.setVivo(false);
			System.out.println(m.toString() + " Disparos para morir: " + disparosMalvados);
			arrayStatsMalvados[i] = disparosMalvados;
			disparosMalvados = 0;
			i++;
		}
		damage = (byte) Math.round(Math.random() * (25 - 5) + 5);
		h.setVida(h.getVida() - damage);
		disparosHumanos = contadorDisparos(disparosHumanos);
		if (h.getVida() <= 0) {
			h.setVivo(false);
			System.out.println(h.toString() + " Disparos para morir: " + disparosHumanos);
			arrayStatsHumanos[i] = disparosHumanos;
			disparosHumanos = 0;
			j++;
		}
	}

	private byte contadorDisparos(byte c) {
		c++;
		return c;

	}

	/**
	 * @param array
	 * @return
	 */
	public Personaje getPrimerPersonajeVivo(Personaje array[]) {
		for (Personaje p : array) {
			if (p.isVivo()) {
				return p;
			}
		}
		return null;

	}

	/**
	 * 
	 */
	public CampoBatalla() {
		this.nombre = "Campo 1";
		// Inicializar los personajes
		for (int i = 0; i < arrayH.length; i++) {
			arrayH[i] = new Humano();
		}

		arrayH[arrayH.length - 1].setVida(arrayH[arrayH.length - 1].getVida() * 2);

		for (int i = 0; i < arrayM.length; i++) {
			arrayM[i] = new Malvado();
		}

		arrayM[arrayM.length - 1].setVida(arrayM[arrayM.length - 1].getVida() * 2);
	}

	/**
	 * @param nombre
	 * @param arrayM
	 * @param arrayH
	 */
	public CampoBatalla(String nombre, Malvado[] arrayM, Humano[] arrayH) {
		this.nombre = nombre;
		this.arrayM = arrayM;
		this.arrayH = arrayH;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the arrayM
	 */
	public Malvado[] getArrayM() {
		return arrayM;
	}

	/**
	 * @param arrayM the arrayM to set
	 */
	public void setArrayM(Malvado[] arrayM) {
		this.arrayM = arrayM;
	}

	/**
	 * @return the arrayH
	 */
	public Humano[] getArrayH() {
		return arrayH;
	}

	/**
	 * @param arrayH the arrayH to set
	 */
	public void setArrayH(Humano[] arrayH) {
		this.arrayH = arrayH;
	}

	@Override
	public String toString() {
		return "CampoBatalla [nombre=" + nombre + ", arrayM=" + Arrays.toString(arrayM) + ", arrayH="
				+ Arrays.toString(arrayH) + "]";
	}

	/**
	 * 
	 * @param args
	 */

}
