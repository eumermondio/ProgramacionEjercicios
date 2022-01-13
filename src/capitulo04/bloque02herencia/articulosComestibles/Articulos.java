package capitulo04.bloque02herencia.articulosComestibles;

public class Articulos {
	protected String cod;
	protected String nombre;
	protected float precio;

	/**
	 * 
	 */

	public Articulos() {
		super();
	}

	/**
	 * @param cod
	 * @param nombre
	 * @param precio
	 */
	public Articulos(String cod, String nombre, float precio) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.precio = precio;
	}

	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}

	/**
	 * @param cod the cod to set
	 */
	public void setCod(String cod) {
		this.cod = cod;
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

}
