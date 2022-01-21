package capitulo04.bloque03;

public class Main {

	public static void main(String[] args) {

		CampoBatalla.getInstance().mezclarArray(CampoBatalla.getInstance().getArrayH());
		CampoBatalla.getInstance().mezclarArray(CampoBatalla.getInstance().getArrayM());
		CampoBatalla.getInstance().batalla();

	}

}
