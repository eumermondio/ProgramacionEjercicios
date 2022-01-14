package capitulo04.bloque02herencia.articulosComestibles;

public class Perecederos extends Articulos {
	protected String fecha_cad;

	public Perecederos() {
		super();
	}

	public Perecederos(String str, String str2, float f, String s) {
		super(str, str2, f);
		this.fecha_cad = s;
	}

	
	
	/**
	 * @return the fecha_cad
	 */
	public String getFecha_cad() {
		return fecha_cad;
	}

	/**
	 * @param fecha_cad the fecha_cad to set
	 */
	public void setFecha_cad(String fecha_cad) {
		this.fecha_cad = fecha_cad;
	}

	@Override
	public String toString() {
		return "Perecederos [fecha_cad=" + fecha_cad + ", getCod()=" + getCod() + ", getNombre()=" + getNombre()
				+ ", getPrecio()=" + getPrecio();
	}

}
