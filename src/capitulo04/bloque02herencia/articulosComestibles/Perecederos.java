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

	@Override
	public String toString() {
		return "Perecederos [fecha_cad=" + fecha_cad + ", getCod()=" + getCod() + ", getNombre()=" + getNombre()
				+ ", getPrecio()=" + getPrecio();
	}

}
