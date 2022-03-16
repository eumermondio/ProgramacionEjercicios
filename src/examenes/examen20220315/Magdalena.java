package examenes.examen20220315;

public class Magdalena extends Articulo {
	private int peso;

	@Override
	public String getDescripcion() {
		return "Magdalena [peso=" + peso + ", id=" + id + ", descripcion=" + descripcion + ", precioUd=" + precioUd
				+ ", uds=" + uds + "]";
	}

	/**
	 * 
	 */
	public Magdalena() {
	}

	/**
	 * @param peso
	 */
	public Magdalena(int id, String descripcion, float precioUd, int uds, int peso) {
		super(id, descripcion, precioUd, uds);
		this.peso = peso;
	}

	/**
	 * @return the peso
	 */
	public int getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Magdalena [peso=" + peso + ", id=" + id + ", descripcion=" + descripcion + ", precioUd=" + precioUd
				+ ", uds=" + uds + "]";
	}

}
