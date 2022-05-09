package examenes.examen20220509.entidades;

public class Acuerdo {
	private int id;
	private String descripcion;
	private int idIdioma;

	/**
	 * 
	 */
	public Acuerdo() {
		super();
	}

	/**
	 * @param id
	 * @param descripcion
	 * @param idIdioma
	 */
	public Acuerdo(int id, String descripcion, int idIdioma) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.idIdioma = idIdioma;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the idIdioma
	 */
	public int getIdIdioma() {
		return idIdioma;
	}

	/**
	 * @param idIdioma the idIdioma to set
	 */
	public void setIdIdioma(int idIdioma) {
		this.idIdioma = idIdioma;
	}

	@Override
	public String toString() {
		return descripcion;
	}

}
