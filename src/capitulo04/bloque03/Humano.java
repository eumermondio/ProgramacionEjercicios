package capitulo04.bloque03;

public class Humano extends Personaje {

	/**
	 * 
	 */
	public Humano() {
		super();
	}

	/**
	 * @param vida
	 * @param nombre
	 * @param vivo
	 */
	public Humano(int vida, String nombre, boolean vivo) {
		super(vida, nombre, vivo);
	}

	@Override
	public String toString() {
		return "Humano [getVida()=" + getVida() + ", getNombre()=" + getNombre() + ", isVivo()=" + isVivo();
	}

}
