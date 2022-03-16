package examenes.examen20220315;

public class Batido extends Articulo {
	private int litros;

	@Override
	public String getDescripcion() {
		return "Batido [litros=" + litros + ", id=" + id + ", descripcion=" + descripcion + ", precioUd=" + precioUd
				+ ", uds=" + uds + "]";
	}

	/**
	 * 
	 */
	public Batido() {
	}

	/**
	 * @param litros
	 */
	public Batido(int id, String descripcion, float precioUd, int uds, int litros) {
		super(id, descripcion, precioUd, uds);
		this.litros = litros;
	}

	/**
	 * @return the litros
	 */
	public int getLitros() {
		return litros;
	}

	/**
	 * @param litros the litros to set
	 */
	public void setLitros(int litros) {
		this.litros = litros;
	}

	@Override
	public String toString() {
		return "Batido [litros=" + litros + ", id=" + id + ", descripcion=" + descripcion + ", precioUd=" + precioUd
				+ ", uds=" + uds + "]";
	}

}
