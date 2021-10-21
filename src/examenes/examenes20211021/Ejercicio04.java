package examenes.examenes20211021;

public class Ejercicio04 {

	public static void main(String[] args) {
		int num, cont; //Declaro variables
		for (int i = 0; i < 9; i++) {
			num = (int) Math.round(Math.random() * 100);
			System.out.println("Numero: " + num + " generado"); //Imprimo numeros al azar

			cont = num; // Igualo valores para empezar desde el valor más alto
			for (; cont != 0; cont--) {
				if ((num % cont) == 0) {
					System.out.println(cont + " es divisor de " + num); // Imprimo los divisores
				}
			}

		}
	}
}