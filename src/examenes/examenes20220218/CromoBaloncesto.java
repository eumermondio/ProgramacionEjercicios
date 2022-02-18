package examenes.examenes20220218;

public class CromoBaloncesto {

	protected int id;
	protected String nombre;
	protected int puntos;
	protected int rebotes;

	/**
	 * 
	 */
	public CromoBaloncesto() {
	}

	/**
	 * @param id
	 * @param nombre
	 * @param puntos
	 * @param rebotes
	 */
	public CromoBaloncesto(int id, String nombre, int puntos, int rebotes) {
		this.id = id;
		this.nombre = nombre;
		this.puntos = puntos;
		this.rebotes = rebotes;
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
	 * @return the puntos
	 */
	public int getPuntos() {
		return puntos;
	}

	/**
	 * @param puntos the puntos to set
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	/**
	 * @return the rebotes
	 */
	public int getRebotes() {
		return rebotes;
	}

	/**
	 * @param rebotes the rebotes to set
	 */
	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}

	@Override
	public String toString() {
		return "CromoBaloncesto [id=" + id + ", nombre=" + nombre + ", puntos=" + puntos + ", rebotes=" + rebotes + "]";
	}

}
