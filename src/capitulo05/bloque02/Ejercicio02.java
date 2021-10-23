package capitulo05.bloque02;

public class Ejercicio02 {

	public static void main(String[] args) {

		int array1[] = new int[150], array2[] = new int[150], array3[] = new int[150], i = 0, j = 0, k = 0;

		for (; i < array1.length; i++) {
			array1[i] = (int) Math.round(Math.random() * 100);
			System.out.print(array1[i] + " ");

		}
		i = 0;
		System.out.println("");
		for (; j < array2.length; j++) {
			array2[j] = (int) Math.round(Math.random() * 100);
			System.out.print(array2[j] + " ");
		}
		j = 0;
		System.out.println("");
		for (; k < array3.length; k++) {
			if (((k & 1) == 1) && ((i & 1) == 1)) {
				array3[k] = array1[i];
				System.out.print(array3[k] + " ");

			}
			if (((k & 1) == 0) && ((j & 1) == 0)) {
				array3[k] = array2[j];
				System.out.print(array3[k] + " ");

			}
			i++;
			j++;

		}
	}

}
