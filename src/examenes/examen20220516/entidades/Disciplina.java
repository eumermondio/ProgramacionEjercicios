package examenes.examen20220516.entidades;

public class Disciplina {
	private int id;
	private String descripcion;

	/**
	 * 
	 */
	public Disciplina() {
	}

	/**
	 * @param id
	 * @param descripcion
	 */
	public Disciplina(int id, String descripcion) {
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
