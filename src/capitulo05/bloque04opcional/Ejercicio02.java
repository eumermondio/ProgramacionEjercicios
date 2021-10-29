package capitulo05.bloque04opcional;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		volver();
	}

	public static String volver() {

		Scanner sc = new Scanner(System.in);
		int array[] = new int[10], cont = 1, num = 0, inicio, fin, aux, auxPreInicio = 0, i;

		for (i = 0; i < array.length; i++) {
			System.out.println("Dame el número: " + cont);
			num = sc.nextInt();
			array[i] = num;
			cont++;
		}
		cont = 0;
		System.out.println("");
		for (i = 0; i < array.length; i++) {
			System.out.println("Indice " + cont + " | " + array[i] + " ");
			cont++;
		}

		System.out.println("Dime el inicio: ");
		inicio = sc.nextInt();

		System.out.println("Dime el final: ");
		fin = sc.nextInt();
		i = 0;
		if ((inicio < fin) && (inicio >= 0 && inicio < 10) && (fin >= 0 && fin < 10)) {
			aux = array[array.length - 1];
			auxPreInicio = array[inicio - 1];
			for (i = array.length - 1; i >= 0; i--) {
				if (i != inicio && fin != i) {
					if ((i - 1) >= 0) {
						array[i] = array[i - 1];
					}
				}

			}
			array[0] = aux;
			array[fin + 1] = auxPreInicio;
			for (i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
		} else {
			return volver();
		}

		sc.close();
		return null;

	}

}
