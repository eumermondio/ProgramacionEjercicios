package capitulo05.bloque04opcional;

public class Ejercicio01 {

	public static void main(String[] args) {

		int array[] = new int[20], i, j, aux = 0;
		for (i = 0; i < array.length; i++) { // Inicializar el array con aleatorios 0 - 100
			array[i] = (int) Math.round(Math.random() * 100);
			System.out.print(array[i] + " ");
		}
		
		System.out.println("");
		
		//Primero la i vale 1 ya que voy a revisar 
		//desde el primer número array[1], guardo el primer valor en aux para despues usarlo,
		//compruebo que j sea mayor de 0 para no salirme del bucle, y que la posi anterior a j sea impar para moverlo a la derecha despues

		for (i = 1; i < array.length; i++) { 
			aux = array[i];
			for (j = i; j > 0 && ((array[j - 1] & 1) == 1); j--) {
				array[j] = array[j - 1];
			}
			array[j] = aux;
		}

		for (i = 0; i < array.length; i++) { // Imprime array ordenado de par a impar
			System.out.print(array[i] + " ");
		}
	}

}
