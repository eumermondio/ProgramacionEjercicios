package capitulo08.Ejercicio01;

public class Fabricante {
	private int id;
	private String cif;
	private String nombre;

	/**
	 * 
	 */
	public Fabricante() {
	}

	/**
	 * @param id
	 * @param cif
	 * @param nombre
	 */
	public Fabricante(int id, String cif, String nombre) {
		this.id = id;
		this.cif = cif;
		this.nombre = nombre;
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
	 * @return the cif
	 */
	public String getCif() {
		return cif;
	}

	/**
	 * @param cif the cif to set
	 */
	public void setCif(String cif) {
		this.cif = cif;
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

}
