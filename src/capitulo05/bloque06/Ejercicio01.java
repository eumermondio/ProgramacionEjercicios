package capitulo05.bloque06;

public class Ejercicio01 {

	public static void main(String[] args) {

		int array[] = new int[7]; // { 1, 2, 3, 4, 2, 6, 7 };
		int num = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = devolverEnteroAzarCeroyCuarentaNueve(num);
			if (i != 0) {
				if (i < array.length) {
					for (int j = i; j > 0; j--) {
						if (array[i] == array[j - 1]) {
							array[i] = devolverEnteroAzarCeroyCuarentaNueve(num);
							j++;
						}
					}
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	public static int devolverEnteroAzarCeroyCuarentaNueve(int num) {
		int limSup = 49, limInf = 1;
		num = (int) Math.round(Math.random() * (limSup - limInf) + limInf);
		return num;

	}

}
