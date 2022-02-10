package capitulo05.bloque09;

public class Articulo {
	private String cod;
	private int numEst;
	private int stock;

	/**
	 * 
	 */
	public Articulo() {
	}

	/**
	 * @param cod
	 * @param numEst
	 * @param stock
	 */
	public Articulo(String cod, int numEst, int stock) {
		this.cod = cod;
		this.numEst = numEst;
		this.stock = stock;
	}

	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}

	/**
	 * @param cod the cod to set
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}

	/**
	 * @return the numEst
	 */
	public int getNumEst() {
		return numEst;
	}

	/**
	 * @param numEst the numEst to set
	 */
	public void setNumEst(int numEst) {
		this.numEst = numEst;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Articulo [cod=" + cod + ", numEst=" + numEst + ", stock=" + stock + "]";
	}

}
