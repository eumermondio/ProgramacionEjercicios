package capitulo05.bloque03;

public class Ejercicio01 {

	public static void main(String[] args) {

		int array[] = new int[150], aux = 0;
		boolean hayIntercambio = true;
		for (int i = 0; i < array.length; i++) { //Inicializar array
			array[i] = (int) Math.round(Math.random() * 1000);
			System.out.print(array[i] + " ");
		}

		System.out.println("");
		while (hayIntercambio) { //Proceso de ordenación
			hayIntercambio = false;
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					hayIntercambio = true;
					aux = array[j];
					array[j] = array[j + 1];
					array[j + 1] = aux;
				}
			}

		}

		for (int i = 0; i < array.length; i++) { //Visualizar array ordenado
			System.out.print(array[i] + " ");
		}

	}
}
