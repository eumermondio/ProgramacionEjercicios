package capitulo08.Ejercicio02.entidades;

public class Sexo {
	protected int id;
	protected String descripcion;

	public Sexo() {

	}

	/**
	 * @param id
	 * @param descripcion
	 */
	public Sexo(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
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

}
