package capitulo04.bloque00PrimerosObjetos;

public class CromosBaloncesto {
	private String nombreJugador;
	private int altura;
	private int peso;
	private float puntosMedios;

	public CromosBaloncesto() {

	}

	public CromosBaloncesto(String nombreJugador, int altura, int peso, float puntos) {
		this.nombreJugador = nombreJugador;
		this.altura = altura;
		this.peso = peso;
		this.puntosMedios = puntos;
	}

	public String toString() {
		return "cromosBaloncesto [nombreJugador=" + nombreJugador + ", altura=" + altura + ", peso=" + peso
				+ ", puntosMedios=" + puntosMedios + "]";
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public float getPuntos() {
		return puntosMedios;
	}

	public void setPuntosMedios(float puntosMedios) {
		this.puntosMedios = puntosMedios;
	}

}
