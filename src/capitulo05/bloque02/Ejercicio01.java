package capitulo05.bloque02;

public class Ejercicio01 {

	public static void main(String[] args) {
		int limSup = 100, limInf = -100, num = 0;
		int array[] = new int[150];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * (limSup - limInf) + limInf);
			//System.out.println(array[i] + " ");
			if ((array[i] & 1) == 0) {
				num = ~array[i] + 1;
				System.out.println("Par cambiado de signo (ANTES): " + array[i] + " (DESPUES): " + num + "\n");
			}
		}
	
	}

}
