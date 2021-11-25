package pruebasVarias;

public class CalcularNotas {

	public static void main(String[] args) {

		int notas[] = new int[] { 2, 6, 10, 9, 5, 3 };
		String alumnos[] = new String[] { "Paco", "Maria", "Rafa", "Cris", "Jesus", "Juanca" };
		String notasString[] = new String[] { "Suspenso", "Bien", "Notable", "Sobresaliente" };
		calcularNota(notas, alumnos, notasString);

	}

	public static void calcularNota(int notas[], String alumnos[], String notasS[]) {
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] < 5) {
				System.out.println("Alumno: " + alumnos[i] + " Nota: " + notas[i] + " " + notasS[0]);
			}
			if (notas[i] < 7 && notas[i] >= 5) {
				System.out.println("Alumno: " + alumnos[i] + " Nota: " + notas[i] + " " + notasS[1]);
			}
			if (notas[i] < 9 && notas[i] >= 7) {
				System.out.println("Alumno: " + alumnos[i] + " Nota: " + notas[i] + " " + notasS[2]);
			}
			if (notas[i] >= 9) {
				System.out.println("Alumno: " + alumnos[i] + " Nota: " + notas[i] + " " + notasS[3]);
			}
		}
	}

}
