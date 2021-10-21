package examenes.examenes20211021;

public class Ejercicio03 {

	public static void main(String[] args) {
		int num = 0, cont = 0; 
		for (int i = 0; cont < 10; i++) { // Declaro variables y creo el for para imprimir pares entra 20 30 40 50
			num = (int) Math.round(Math.random() * 100);
			if ((num & 1) == 0) {

				if ((num >= 20 && num <= 30) || (num >= 40 && num <= 50)) { // Compruebo que este en el intervalo y que sea par
					cont++;
					System.out.println("Numero: " + num + " generado"); //Imprimo los numeros
				}

			}
		}
	}
}
