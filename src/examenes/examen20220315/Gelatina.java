package examenes.examen20220315;

public class Gelatina extends Articulo {
	private String etiqueta;

	@Override
	public String getDescripcion() {
		return "Gelatina [etiqueta=" + etiqueta + ", id=" + id + ", descripcion=" + descripcion + ", precioUd="
				+ precioUd + ", uds=" + uds + "]";
	}

	/**
	 * 
	 */
	public Gelatina() {
	}

	/**
	 * @param etiqueta
	 */
	public Gelatina(int id, String descripcion, float precioUd, int uds, String etiqueta) {
		super(id, descripcion, precioUd, uds);
		this.etiqueta = etiqueta;
	}

	/**
	 * @return the etiqueta
	 */
	public String getEtiqueta() {
		return etiqueta;
	}

	/**
	 * @param etiqueta the etiqueta to set
	 */
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	@Override
	public String toString() {
		return "Gelatina [etiqueta=" + etiqueta + ", id=" + id + ", descripcion=" + descripcion + ", precioUd="
				+ precioUd + ", uds=" + uds + "]";
	}

}
