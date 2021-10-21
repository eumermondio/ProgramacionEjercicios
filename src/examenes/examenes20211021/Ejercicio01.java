package examenes.examenes20211021;

public class Ejercicio01 {

	public static void main(String[] args) {
		int num = 0, sumaMCinco = 0, sumaMedia = 0, contImpares = 0; // Declaro variables
		for (int i = 0; i < 9; i++) {
			num = (int) Math.round(Math.random() * 100);
			if ((num % 5) == 0) { // Compruebo que el resto de num entre 5 sale 0 para clasificarlo en multiplo de
									// 5
				sumaMCinco += num;
			}
			if ((num & 1) == 1) { // Compruebo que num es impar para hacer la media
				sumaMedia += num;
				contImpares++;
			}
			System.out.println("Número: " + num + " generado");
		}
		System.out.println("La suma de los múltiplos de 5 es: " + sumaMCinco); // Imprimo suma de multiplos de 5
		System.out.println("La media de los impares es: " + (sumaMedia / (float) contImpares));
	}

}
