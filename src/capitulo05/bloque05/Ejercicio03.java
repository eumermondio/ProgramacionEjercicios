package capitulo05.bloque05;

public class Ejercicio03 {

	public static void main(String[] args) {

		float array[] = new float[20];
		int cont = 0;

		// Recorro el array inicializandolo y mostrandolo en pantalla

		for (int i = 0; i < array.length; i++) {
			array[i] = (float) Math.round(Math.random() * 100) + (float) Math.random();
//		 Compruebo que el actual valor de array[i] sea menor o igual que el mismo valor 
//			casteado a entero ( esto lo hago para que pierda la parte decimal ) más .049, si esto 
//			se da quiere decir que ese valor del array se comprende entre el .00 y .49
			if (array[i] <= (int) array[i] + 0.49f) {
				cont++;
			}
		}
		imprimirArrayDecimal(array);
		System.out.println("\nNúmeros entre .00 y .49: " + cont);

	}
	
	public static void imprimirArrayDecimal(float array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
