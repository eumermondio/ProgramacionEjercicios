package capitulo05.bloque02;

public class Ejercicio04 {

	public static void main(String[] args) {

		int array[] = new int[5]; //Declaro el array
		int i = 0, aux = 0; //Declaro la i y aux

		for (; i < array.length; i++) { //Bucle para inicializar el array
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.print(array[i] + " ");
		}

		System.out.println("\nMover derecha");
		aux = array[array.length - 1]; //Guardo en la variable auxiliar la ultima posicion del array

		for (int j = array.length - 1; j >= 0; j--) { //Recorro el array a la inversa

			if ((j - 1) >= 0) { //En caso de que la j - 1 sea mayor igual de 0 ( sea un indice valido no fuera de los limites del array )
				array[j] = array[j - 1];
			}

		}
		array[0] = aux;
		for (int j = 0; j < array.length; j++) {
			System.out.print(array[j] + " ");
		}

	}
}
