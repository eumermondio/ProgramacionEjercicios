package examenes.examen20220315;

public class Carne extends Articulo {
	private String procedencia;

	@Override
	public String getDescripcion() {
		return "Carne [procedencia=" + procedencia + ", id=" + id + ", descripcion=" + descripcion + ", precioUd="
				+ precioUd + ", uds=" + uds + "]";
	}

	/**
	 * 
	 */
	public Carne() {
	}

	/**
	 * @param procedencia
	 */
	public Carne(int id, String descripcion, float precioUd, int uds, String procedencia) {
		super(id, descripcion, precioUd, uds);
		this.procedencia = procedencia;
	}

	/**
	 * @return the procedencia
	 */
	public String getProcedencia() {
		return procedencia;
	}

	/**
	 * @param procedencia the procedencia to set
	 */
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	@Override
	public String toString() {
		return "Carne [procedencia=" + procedencia + ", id=" + id + ", descripcion=" + descripcion + ", precioUd="
				+ precioUd + ", uds=" + uds + "]";
	}

}
