package capitulo08.Ejercicio01;

public class Venta {
	private int id;
	private int idCli;
	private int idConce;
	private int idCoche;
	private String fecha;
	private float precio;

	/**
	 * 
	 */
	public Venta() {
		super();
	}

	/**
	 * @param id
	 * @param idCli
	 * @param idConce
	 * @param idCoche
	 * @param fecha
	 * @param precio
	 */
	public Venta(int id, int idCli, int idConce, int idCoche, String fecha, float precio) {
		super();
		this.id = id;
		this.idCli = idCli;
		this.idConce = idConce;
		this.idCoche = idCoche;
		this.fecha = fecha;
		this.precio = precio;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the idCli
	 */
	public int getIdCli() {
		return idCli;
	}

	/**
	 * @param idCli the idCli to set
	 */
	public void setIdCli(int idCli) {
		this.idCli = idCli;
	}

	/**
	 * @return the idConce
	 */
	public int getIdConce() {
		return idConce;
	}

	/**
	 * @param idConce the idConce to set
	 */
	public void setIdConce(int idConce) {
		this.idConce = idConce;
	}

	/**
	 * @return the idCoche
	 */
	public int getIdCoche() {
		return idCoche;
	}

	/**
	 * @param idCoche the idCoche to set
	 */
	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
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
