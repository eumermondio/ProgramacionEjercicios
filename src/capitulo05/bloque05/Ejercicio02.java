package capitulo05.bloque05;

public class Ejercicio02 {

	public static void main(String[] args) {

		int array[] = new int[20];
		for (int i = 0; i < array.length; i++) {
			array[i] = (Ejercicio01.numerosAzar() / 10);
		}
		Ejercicio01.mostrarArray(array);
		porcentajeNotas(array);

	}

	public static void porcentajeNotas(int array[]) {
		int aprobados = 0, suspensos = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 5) {
				aprobados++;
			} else {
				suspensos++;
			}
		}

		System.out.println("\nEl porcentaje de aprobados es de: " + (float) ((aprobados * 100) / array.length));
		System.out.println("El porcentaje de suspensos es de: " + (float) ((suspensos * 100) / array.length));

	}

}
