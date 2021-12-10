package capitulo04.bloque01;

public class Persona {
	private String nombre;
	private String apll;
	private String dni;
	private String direccion;
	private String tlf;

	/**
	 * 
	 */
	public Persona() {

	}

	/**
	 * @param nombre
	 * @param apll
	 * @param dni
	 * @param direccion
	 * @param tlf
	 */
	public Persona(String nombre, String apll, String dni, String direccion, String tlf) {
		this.nombre = nombre;
		this.apll = apll;
		this.dni = dni;
		this.direccion = direccion;
		this.tlf = tlf;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApll() {
		return apll;
	}

	public void setApll(String apll) {
		this.apll = apll;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apll=" + apll + ", dni=" + dni + ", direccion=" + direccion + ", tlf="
				+ tlf + "]";
	}
	
}
