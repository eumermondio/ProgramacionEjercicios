package pruebasVarias;

public class RecursosArrays {

	public static int numerosAzar() {

		int num;
		num = (int) Math.round(Math.random() * 100);
		return num;

	}

	public static void inicializarArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = numerosAzar();
		}
	}

	public static void mostrarArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void imprimirArrayDecimal(float array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void inicializarArraysDecimales(float array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (float) Math.round(Math.random() * 100) + (float) Math.random();
		}
	}

}
