package examenes.examen20220516.entidades;

public class Municipio {
	protected int id;
	protected int idProvincia;
	protected String nombre;

	/**
	 * 
	 */
	public Municipio() {
	}

	/**
	 * @param id
	 * @param idProvincia
	 * @param codMunicipio
	 * @param nombre
	 */
	public Municipio(int id, int idProvincia, String nombre) {
		this.id = id;
		this.idProvincia = idProvincia;
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
	 * @return the idProvincia
	 */
	public int getIdProvincia() {
		return idProvincia;
	}

	/**
	 * @param idProvincia the idProvincia to set
	 */
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
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

	@Override
	public String toString() {
		return nombre;
	}

}
