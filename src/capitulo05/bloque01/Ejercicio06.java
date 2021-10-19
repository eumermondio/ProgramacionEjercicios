package capitulo05.bloque01;

public class Ejercicio06 {

	public static void main(String[] args) {

		int array[] = new int[150], sumaPares = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random()*100);
			System.out.print(array[i] + " ");
			if ((i & 1) == 0) {
				sumaPares += array[i];
			}
		}
		System.out.println("\nLa suma de las posiciones pares es: " + sumaPares);
	}

}
