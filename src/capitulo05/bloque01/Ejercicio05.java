package capitulo05.bloque01;

public class Ejercicio05 {

	public static void main(String[] args) {

		int array[] = new int[150], sumaPares = 0, sumaImpares = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random()*100);
			System.out.print(array[i] + " ");
			if ((array[i] & 1) == 0) {
				sumaPares += array[i];
			}
			if ((array[i] & 1) == 1) {
				sumaImpares += array[i];
			}
		}
		
		System.out.println("\nLa suma de los números pares del array es: " + sumaPares);
		System.out.println("La suma de los números impares del array es: " + sumaImpares);
		
	}

}
