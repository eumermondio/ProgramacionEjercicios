package capitulo04.bloque02herencia.coleccionAntiguedades;

public class Libro extends Antiguedad {
	protected String titulo;
	protected String autor;

	public Libro() {
		super();
	}

	/**
	 * 
	 * @param fabricacion
	 * @param origen
	 * @param precio
	 * @param titulo
	 * @param autor
	 */

	public Libro(String fabricacion, String origen, float precio, String titulo, String autor) {
		super(fabricacion, origen, precio);
		this.titulo = titulo;
		this.autor = autor;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", getFabricacion()=" + getFabricacion()
				+ ", getOrigen()=" + getOrigen() + ", getPrecio()=" + getPrecio();
	}
}
