package capitulo04.bloque02herencia.coleccionAntiguedades;

public class Arte extends Antiguedad {

	protected String medida;

	public Arte() {
		super();
	}

	public Arte(String fabricacion, String origen, float precio, String medida) {
		super(fabricacion, origen, precio);
		this.medida = medida;
	}

	/**
	 * @return the medida
	 */
	public String getMedida() {
		return medida;
	}

	/**
	 * @param medida the medida to set
	 */
	public void setMedida(String medida) {
		this.medida = medida;
	}

	@Override
	public String toString() {
		return "Arte [medida=" + medida + ", getFabricacion()=" + getFabricacion() + ", getOrigen()=" + getOrigen()
				+ ", getPrecio()=" + getPrecio();
	}

}
