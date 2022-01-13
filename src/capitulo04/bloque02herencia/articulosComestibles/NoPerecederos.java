package capitulo04.bloque02herencia.articulosComestibles;

public class NoPerecederos extends Articulos {

	public NoPerecederos() {
		super();
	}

	public NoPerecederos(String str, String str2, float f) {
		super(str, str2, f);
	}

	@Override
	public String toString() {
		return "NoPerecederos [getCod()=" + getCod() + ", getNombre()=" + getNombre() + ", getPrecio()=" + getPrecio();
	}

}
