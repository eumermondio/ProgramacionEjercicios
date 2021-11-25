package pruebasVarias;

public class MoverPosiArray {

	public static void main(String[] args) {

		int array[] = new int[] { 1, 2, 3, 4, 5 };
		int aux = 0;
		aux = array[array.length - 1];
		for (int i = array.length - 1; i >= 0; i--) {
			if (i > 0) {
				array[i] = array[i - 1];
			}
		}
		array[0] = aux;
		pruebasVarias.RecursosArrays.mostrarArray(array);
	}

}
