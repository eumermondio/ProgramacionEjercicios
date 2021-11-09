package capitulo05.bloque05;

public class Ejercicio01 {

	public static void main(String[] args) {

		int num = numerosAzar();
		int examenArray;
		int array[] = new int[num];
		inicializarArray(array);
		mostrarArray(array);
		examenArray = examinarArray(array.length);
		if (examenArray == -1) {
			System.out.println("\n-1");
		} else {
			System.out.println("\n" + array[examenArray]);
		}
	}

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

	public static int examinarArray(int num) {
		if ((num & 1) == 0) {
			return -1;
		} else {
			return ((num - 1) / 2);
		}
	}

}
