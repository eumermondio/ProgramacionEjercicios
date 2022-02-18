package examenes.examenes20220218;

public class EjercicioA {

	public static void main(String[] args) {

		float pi = 0;
		int producto = 1;
		int toggler = 1;
		int k = 1, j = 1, c = 0, resK = k, resJ = j;
		for (int i = 0; i < 5; i++) {
			// Bucle para simbolo -

			if (toggler == 0) {
				for (resJ = 0; resJ < 3; j++) {
					producto *= j;
					resJ++;
				}
				pi -= 4f / producto;
				toggler = 1;
				resJ = j;
			}
			// Bucle para simbolo +

			if (toggler == 1) {
				for (resK = 0; resK < 3; k++) {
					if (c == 0) {
						pi = 3;
						c++;
					} else {
						producto *= k;
						resK++;
					}
				}
				pi += 4f / producto;
				toggler = 0;
				resK = k;
			}
		}
		System.out.println("Resultado de pi: " + pi);
	}
}
