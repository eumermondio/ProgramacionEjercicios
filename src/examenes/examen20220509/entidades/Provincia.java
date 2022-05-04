package examenes.examen20220509.entidades;

public class Provincia {
	protected int id;
	protected String provincia;

	/**
	 * 
	 */
	public Provincia() {
	}

	/**
	 * @param id
	 * @param provincia
	 */
	public Provincia(int id, String provincia) {
		this.id = id;
		this.provincia = provincia;
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
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return provincia;
	}

}
