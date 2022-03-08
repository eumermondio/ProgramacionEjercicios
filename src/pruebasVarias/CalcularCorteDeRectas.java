package pruebasVarias;

public class CalcularCorteDeRectas {

	public static void main(String[] args) {

		float y = 0, y1 = 0, x = 0;

		for (x = 0; x < 1; x += 0.001) {
			y = (float) Math.sqrt(x + 1);
			y1 = (float) Math.log(x * 5);
			if (Math.abs(y - y1) < 0.001) {
				break;
			}
		}
		System.out.println("La x del corte es: " + x + " ,la y del corte es " + y);
	}

}
