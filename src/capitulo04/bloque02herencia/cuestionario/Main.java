package capitulo04.bloque02herencia.cuestionario;

public class Main {

	public static void main(String[] args) {

		Pregunta array[] = new Pregunta[5];

		inicializarPreguntas(array);
		crearPreguntas(array);
		verPreguntas(array);

	}

	private static void verPreguntas(Pregunta[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].toString());
		}
	}

	private static void inicializarPreguntas(Pregunta[] array) {
		byte random = 0;
		random = (byte) Math.round(Math.random());
		for (int i = 0; i < array.length; i++) {
			if (random == 0) {
				array[i] = (i <= array.length / 2) ? new VyF() : new Estandar();
			} else {
				array[i] = (i >= array.length / 2) ? new Estandar() : new VyF();
			}

		}
	}

	private static void crearPreguntas(Pregunta[] array) {
		String preguntasVyF[] = new String[5];
		String preguntasEstandar[] = new String[5];
		char c = 0;
		int k = 0;
		int j = 0;
		for (; j < array.length; j++) {

			for (int i = 0; i < preguntasEstandar.length; i++) {
				c = (char) Math.round(Math.random() * (122 - 48) + 48);
				preguntasEstandar[i] += c;
			}
			for (int i = 0; i < preguntasVyF.length; i++) {
				c = (char) Math.round(Math.random() * (122 - 48) + 48);
				preguntasVyF[i] += c;
			}
		}
		j = 0;
		while (j < array.length) {
			if (k < preguntasEstandar.length) {
				if (array[j] instanceof Estandar) {
					array[j].setPregunta(preguntasEstandar[k]);
				}
				if (array[j] instanceof VyF) {
					array[j].setPregunta(preguntasVyF[k]);
				}
			}
			j++;
			k++;
		}
	}
}
