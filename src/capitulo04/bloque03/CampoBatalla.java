package capitulo04.bloque03;

import java.util.Arrays;

public class CampoBatalla {
	private String nombre;
	private Malvado arrayM[] = new Malvado[20];
	private Humano arrayH[] = new Humano[20];

	/**
	 * 
	 */
	public CampoBatalla() {
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

	public static void main(String[] args) {
		CampoBatalla campo = new CampoBatalla();
	}

}
