package capitulo05.bloque06;

public class Ejercicio03 {

	public static void main(String[] args) {
		int num = 0, suma = 0, cont = 0;
		float media = 0;
		do {
			num = numeroAzarUnoMil();
			suma += num;
			cont++;
			media = (float) suma / cont;
		} while (media < 499.5f || media > 500.5f);
		System.out.println("Cantidad de números generados al azar: " + cont + "\nValor de la media: " + media);

	}

	public static int numeroAzarUnoMil() {
		int num = (int) Math.round(Math.random() * (1000 - 1) + 1);
		return num;
	}
}
