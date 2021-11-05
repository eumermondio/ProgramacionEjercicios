package pruebasVarias;

import java.util.Date;

public class CerraduraConFuerzaBruta {

	public static void main(String[] args) {

		int cerradura[] = new int[6];
		int llave[] = new int[6];
		int cont = 0;
		int indiceExcluido[] = new int[llave.length];
		boolean estaAbierto = false;
		System.out.println("Cerradura");
		for (int i = 0; i < cerradura.length; i++) {
			cerradura[i] = (int) Math.round(Math.random() * 5);

		}
		long millisDesde1970 = new Date().getTime();
		do {

			for (int i = 0; i < llave.length; i++) {
				llave[i] = (int) Math.round(Math.random() * 5);
			}
			System.out.println("Llave");
			for (int i = 0; i < llave.length; i++) {
				System.out.print(llave[i] + " ");
			}
			System.out.println("");
			for (int i = 0; i < llave.length; i++) {
				if (llave[i] == cerradura[i]) {
					cont++;
					indiceExcluido[i] = i;
				}

			}
			if (cont == cerradura.length) {
				estaAbierto = true;
			}
			System.out.println(cont + " de " + cerradura.length);
			if (!estaAbierto) {
				System.out.println("No conseguiste abrir la cerradura");
			}
			cont = 0;
		} while (!estaAbierto);
		for (int i = 0; i < llave.length; i++) {
			System.out.print(cerradura[i] + " ");
		}
		System.out.println("Abriste la cerradura!");
		long millisDespuesDeBusquedaPrimos = new Date().getTime();

		long restaDeMillis = millisDespuesDeBusquedaPrimos - millisDesde1970;

		System.out.println("He tardado " + restaDeMillis + " milisegundos - " + (restaDeMillis / 1000) + " segundos");
		for (int i = 0; i < indiceExcluido.length; i++) {
			System.out.print(indiceExcluido[i] + " ");
		}
	}
}
