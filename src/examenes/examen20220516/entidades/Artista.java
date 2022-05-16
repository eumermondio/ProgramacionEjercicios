package examenes.examen20220516.entidades;

public class Artista {
	private int id;
	private String nombre;
	private int idDisciplina;
	private int idMunicipio;
	private byte[] imagen;

	/**
	 * 
	 */
	public Artista() {
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
	 * @return the idDisciplina
	 */
	public int getIdDisciplina() {
		return idDisciplina;
	}

	/**
	 * @param idDisciplina the idDisciplina to set
	 */
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	/**
	 * @return the idMunicipio
	 */
	public int getIdMunicipio() {
		return idMunicipio;
	}

	/**
	 * @param idMunicipio the idMunicipio to set
	 */
	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	/**
	 * @return the imagen
	 */
	public byte[] getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	/**
	 * @param id
	 * @param nombre
	 * @param idDisciplina
	 * @param idMunicipio
	 * @param imagen
	 */
	public Artista(int id, String nombre, int idDisciplina, int idMunicipio, byte[] imagen) {
		this.id = id;
		this.nombre = nombre;
		this.idDisciplina = idDisciplina;
		this.idMunicipio = idMunicipio;
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
