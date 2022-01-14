package capitulo04.bloque02herencia.coleccionAntiguedades;

public class Joya extends Antiguedad {

	protected String material;

	public Joya() {
		super();
	}

	public Joya(String fabricacion, String origen, float precio, String material) {
		super(fabricacion, origen, precio);
		this.material = material;
	}

	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * @param material the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Joya [material=" + material + ", getFabricacion()=" + getFabricacion() + ", getOrigen()=" + getOrigen()
				+ ", getPrecio()=" + getPrecio();
	}

}
