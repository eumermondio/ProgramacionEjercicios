package capitulo05.bloque03;

public class Ejercicio03 {

	public static void main(String[] args) {

		int array[] = new int[20], aux = 0, i, salto = 0;
		for (i = 0; i < array.length; i++) { // Inicializar array
			array[i] = (int) Math.round(Math.random() * 1000);
			System.out.print(array[i] + " ");
		}

		System.out.println("");

		for (salto = 6; salto > 0; salto--) { //Ordenar array SHELL
			for (i = 0; i < array.length; i++) {
				if ((i + salto) < array.length) {
					if (array[i + salto] < array[i]) {
						aux = array[i];
						array[i] = array[i + salto];
						array[i + salto] = aux;
					}
				}
			}
		}

		for (i = 0; i < array.length; i++) { // Visualizar array ordenado
			System.out.print(array[i] + " ");
		}

	}

}
