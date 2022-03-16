package examenes.examen20220315;

public abstract class Articulo {
	protected int id;
	protected String descripcion;
	protected float precioUd;
	protected int uds;

	/**
	 * 
	 */
	public Articulo() {
	}

	/**
	 * @param id
	 * @param descripcion
	 * @param precioUd
	 * @param uds
	 */
	public Articulo(int id, String descripcion, float precioUd, int uds) {
		this.id = id;
		this.descripcion = descripcion;
		this.precioUd = precioUd;
		this.uds = uds;
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
	 * @return the descripcion
	 */
	public abstract String getDescripcion();

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the precioUd
	 */
	public float getPrecioUd() {
		return precioUd;
	}

	/**
	 * @param precioUd the precioUd to set
	 */
	public void setPrecioUd(float precioUd) {
		this.precioUd = precioUd;
	}

	/**
	 * @return the uds
	 */
	public int getUds() {
		return uds;
	}

	/**
	 * @param uds the uds to set
	 */
	public void setUds(int uds) {
		this.uds = uds;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", descripcion=" + descripcion + ", precioUd=" + precioUd + ", uds=" + uds + "]";
	}

}
