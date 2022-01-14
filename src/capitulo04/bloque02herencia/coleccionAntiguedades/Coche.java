package capitulo04.bloque02herencia.coleccionAntiguedades;

public class Coche extends Antiguedad {

	protected String matricula;

	public Coche() {
		super();
	}

	public Coche(String fabricacion, String origen, float precio, String matricula) {
		super(fabricacion, origen, precio);
		this.matricula = matricula;
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", getFabricacion()=" + getFabricacion() + ", getOrigen()="
				+ getOrigen() + ", getPrecio()=" + getPrecio();
	}

}
