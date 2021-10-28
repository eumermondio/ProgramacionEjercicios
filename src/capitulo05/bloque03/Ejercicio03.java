package capitulo05.bloque03;

public class Ejercicio03 {

	public static void main(String[] args) {

		int array[] = new int[150], aux = 0, i;
		for (i = 0; i < array.length; i++) { // Inicializar array
			array[i] = (int) Math.round(Math.random() * 1000);
			System.out.print(array[i] + " ");
		}

		System.out.println("");
		
		

		for (i = 0; i < array.length; i++) { // Visualizar array ordenado
			System.out.print(array[i] + " ");
		}

	}

}
