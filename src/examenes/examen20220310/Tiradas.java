package examenes.examen20220310;

public class Tiradas {
	protected long prob;
	protected int puntos;
	protected int id;
	protected String desc;

	/**
	 * 
	 */
	public Tiradas() {
	}

	/**
	 * @param prob
	 * @param puntos
	 * @param id
	 * @param desc
	 */
	public Tiradas(long prob, int puntos, int id, String desc) {
		this.prob = prob;
		this.puntos = puntos;
		this.id = id;
		this.desc = desc;
	}

	/**
	 * @return the prob
	 */
	public long getProb() {
		return prob;
	}

	/**
	 * @param prob the prob to set
	 */
	public void setProb(long prob) {
		this.prob = prob;
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
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Tiradas [prob=" + prob + ", puntos=" + puntos + ", id=" + id + ", desc=" + desc + "]";
	}

}
