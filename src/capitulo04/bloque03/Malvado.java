package capitulo04.bloque03;

public class Malvado extends Personaje {

	/**
	 * 
	 */
	public Malvado() {
		super();
	}

	/**
	 * @param vida
	 * @param nombre
	 * @param vivo
	 */
	public Malvado(int vida, String nombre, boolean vivo) {
		super(vida, nombre, vivo);
	}

	@Override
	public String toString() {
		return "Malvado [getVida()=" + getVida() + ", getNombre()=" + getNombre() + ", isVivo()=" + isVivo();
	}

}
