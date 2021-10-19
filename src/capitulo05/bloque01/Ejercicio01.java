package capitulo05.bloque01;

public class Ejercicio01 {

	public static void main(String[] args) {

		int array[] = new int[150];
		int suma = 0, menor = 0, mayor = 0;
		float media;
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.print(array[i] + " ");
			suma += array[i];
			if (i == 0) {
				mayor = array[0];
				menor = array[0];
			}
			if (array[i] > mayor) {
				mayor = array[i];
			}
			if (array[i] < menor) {
				menor = array[i];
			}
		}
		media = (float) suma / array.length;
		System.out.println("\nLa suma es: " + suma);
		System.out.println("La media es: " + media);
		System.out.println("El mayor es: " + mayor);
		System.out.println("El menor es: " + menor);

	}

}
