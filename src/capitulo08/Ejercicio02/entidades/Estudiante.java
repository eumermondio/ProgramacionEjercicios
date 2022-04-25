package capitulo08.Ejercicio02.entidades;

public class Estudiante {
	protected int id;
	protected String nombre;
	protected String apellido1;
	protected String apellido2;
	protected String dni;
	protected String direccion;
	protected String email;
	protected String tlf;

	/**
	 * 
	 */
	public Estudiante() {
		super();
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param direccion
	 * @param email
	 * @param tlf
	 */
	public Estudiante(int id, String nombre, String apellido1, String apellido2, String dni, String direccion,
			String email, String tlf) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.direccion = direccion;
		this.email = email;
		this.tlf = tlf;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * @param apellido1 the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the tlf
	 */
	public String getTlf() {
		return tlf;
	}

	/**
	 * @param tlf the tlf to set
	 */
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

}
