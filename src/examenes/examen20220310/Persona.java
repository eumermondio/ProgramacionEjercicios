package examenes.examen20220310;

public class Persona {
	protected int puntos;
	protected String nombre;

	/**
	 * 
	 */
	public Persona() {
	}

	/**
	 * @param puntos
	 * @param nombre
	 */
	public Persona(int puntos, String nombre) {
		this.puntos = puntos;
		this.nombre = nombre;
	}

	/**
	 * @return the puntos
	 */
	public int getPuntos() {
		return puntos;
	}

	/**
	 * @param puntos the puntos to set
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
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

	@Override
	public String toString() {
		return "Persona [puntos=" + puntos + ", nombre=" + nombre + "]";
	}

}
