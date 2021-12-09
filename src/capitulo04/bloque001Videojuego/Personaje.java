package capitulo04.bloque001Videojuego;

public class Personaje {
	private int vida;
	private int potencia;
	private float precision;

	public String toString() {
		return "Personaje [vida=" + vida + ", potencia=" + potencia + ", precision=" + precision + "]";
	}

	/**
	 * @param vida
	 * @param potencia
	 * @param precision
	 */
	public Personaje(int vida, int potencia, float precision) {
		this.vida = vida;
		this.potencia = potencia;
		this.precision = precision;
	}

	/**
	 * 
	 */
	public Personaje() {
		this.vida = (int) Math.round(Math.random() * (100 - 90) + 90);
		this.potencia = (int) Math.round(Math.random() * (30 - 20) + 20);
		this.precision = (int) Math.round(Math.random() * (70 - 50) + 50);
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public float getPrecision() {
		return precision;
	}

	public void setPrecision(float precision) {
		this.precision = precision;
	}

}
