package capitulo05.bloque02;

public class Ejercicio04 {

	public static void main(String[] args) {

		int array[] = new int[5];
		int array1[] = new int[5];
		int i = 0;

		for (; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.print(array[i] + " ");
		}
		
		i = 0;
		
		System.out.println("\nMover derecha");
		for (int j = 0; j < array.length;j++) {
			
			if (j == 0) {
				array1[0] = array[4];
				System.out.print(array1[0] + " ");
			}
			
			array1[j] = array[i];
			System.out.print(array[j] + " ");
			
			if (j == 3) {
				break;
			}
			
		}

	}

}
