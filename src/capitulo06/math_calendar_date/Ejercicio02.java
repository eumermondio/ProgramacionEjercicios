package capitulo06.math_calendar_date;

public class Ejercicio02 {

	public static void main(String[] args) {

		double pi = 0;
		int toggler = 0;
		int factor = 3;

		pi = (4 / 1);

		for (float i = 0; i < 1; i += 0.00001) {
			if (toggler == 0) {
				pi -= (4f / factor);
				toggler = 1;
			}
			factor += 2;
			if (toggler == 1) {
				pi += (4f / factor);
				toggler = 0;
			}
			factor += 2;
		}
		System.out.println("PI: " + pi);
	}
}
