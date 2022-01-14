package capitulo04.bloque02herencia.coleccionAntiguedades;

public class Antiguedad {
	protected String fabricacion;
	protected String origen;
	protected float precio;

	/**
	 * 
	 */

	public Antiguedad() {
		super();
	}

	/**
	 * @param fabricacion
	 * @param origen
	 * @param precio
	 */
	public Antiguedad(String fabricacion, String origen, float precio) {
		this.fabricacion = fabricacion;
		this.origen = origen;
		this.precio = precio;
	}

	/**
	 * @return the fabricacion
	 */
	public String getFabricacion() {
		return fabricacion;
	}

	/**
	 * @param fabricacion the fabricacion to set
	 */
	public void setFabricacion(String fabricacion) {
		this.fabricacion = fabricacion;
	}

	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String toString() {
		return "Antiguedad [fabricacion=" + fabricacion + ", origen=" + origen + ", precio=" + precio + "]";
	}
}
