package capitulo08.Ejercicio02.entidades;

public class Materia {
	private int id;
	private String nombre;
	private String acronimo;
	private int idCurso;

	/**
	 * 
	 */
	public Materia() {
	}

	/**
	 * @param id
	 * @param nombre
	 * @param acronimo
	 * @param idCurso
	 */
	public Materia(int id, String nombre, String acronimo, int idCurso) {
		this.id = id;
		this.nombre = nombre;
		this.acronimo = acronimo;
		this.idCurso = idCurso;
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
	 * @return the acronimo
	 */
	public String getAcronimo() {
		return acronimo;
	}

	/**
	 * @param acronimo the acronimo to set
	 */
	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	/**
	 * @return the idCurso
	 */
	public int getIdCurso() {
		return idCurso;
	}

	/**
	 * @param idCurso the idCurso to set
	 */
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

}
