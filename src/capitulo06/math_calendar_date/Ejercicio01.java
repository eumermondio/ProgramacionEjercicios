package capitulo06.math_calendar_date;

public class Ejercicio01 {

	public static void main(String[] args) {

		float y1 = 0, y2 = 0;

		for (float x = 0; x < 1; x += 0.001) {
			y1 = (float) Math.sqrt(x);
			y2 = -(float) Math.log(x);
			if (Math.abs(y1 - y2) < 0.001) {
				System.out.println("La X se corta en: " + y1 + " " + y2);
			}
		}

	}

}
