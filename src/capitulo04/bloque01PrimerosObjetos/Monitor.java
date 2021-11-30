package capitulo04.bloque01PrimerosObjetos;

public class Monitor {

	private int pulgada;
	private int resolucion;
	private int relacion;
	private int contraste;
	private int brillo;
	private int conectores;

	public Monitor() {

	}

	public Monitor(int pulgada, int resolucion, int relacion, int brillo, int conectores, int contraste) {
		this.pulgada = pulgada;
		this.resolucion = resolucion;
		this.relacion = relacion;
		this.contraste = contraste;
		this.brillo = brillo;
		this.conectores = conectores;

	}

	public String toString() {
		return "Monitor [pulgada=" + pulgada + ", resolucion=" + resolucion + ", relacion=" + relacion + ", contraste="
				+ contraste + ", brillo=" + brillo + ", conectores=" + conectores + "]";

	}

	public int getPulgada() {
		return pulgada;
	}

	public void setPulgada(int pulgada) {
		this.pulgada = pulgada;
	}

	public int getResolucion() {
		return resolucion;
	}

	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}

	public int getRelacion() {
		return relacion;
	}

	public void setRelacion(int relacion) {
		this.relacion = relacion;
	}

	public int getContraste() {
		return contraste;
	}

	public void setContraste(int contraste) {
		this.contraste = contraste;
	}

	public int getBrillo() {
		return brillo;
	}

	public void setBrillo(int brillo) {
		this.brillo = brillo;
	}

	public int getConectores() {
		return conectores;
	}

	public void setConectores(int conectores) {
		this.conectores = conectores;
	}

}
