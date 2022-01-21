package capitulo04.bloque03;

public class Personaje {
	protected int vida;
	protected String nombre;
	protected boolean vivo = true;

	/**
	 * 
	 */
	public Personaje() {
		this.vida = (int) Math.round(Math.random() * (100 - 50) + 50);
	}

	/**
	 * @param vida
	 * @param nombre
	 * @param vivo
	 */
	public Personaje(int vida, String nombre, boolean vivo) {
		this.vida = vida;
		this.nombre = nombre;
		this.vivo = vivo;
	}

	/**
	 * @return the vida
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * @param vida the vida to set
	 */
	public void setVida(int vida) {
		this.vida = vida;
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
	 * @return the vivo
	 */
	public boolean isVivo() {
		return vivo;
	}

	/**
	 * @param vivo the vivo to set
	 */
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	@Override
	public String toString() {
		return "Personaje [vida=" + vida + ", nombre=" + nombre + ", vivo=" + vivo + "]";
	}

}
