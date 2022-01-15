package capitulo04.bloque02herencia.cuestionario;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Pregunta array[] = new Pregunta[5];
		int puntos;
		System.out.println("5 preguntas, máximo 5 puntos");
		inicializarPreguntas(array);
		crearPreguntas(array);
		puntos = verPreguntas(array);
		System.out.println("Acertaste " + puntos + " de 5 preguntas");

	}

	/**
	 * 
	 * @param array
	 */
	private static void crearRespuestas(Pregunta[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] instanceof VyF) {
				array[i].setRespuesta("Verdadero o Falso");
				if (array[i].getPregunta() == "El buggati chiron alcanza los 600Km/h?") {
					((VyF) array[i]).setRespuestaCorrecta("f");
				}
				if (array[i].getPregunta() == "Es Pedro Sanchez el actual presidente de España?") {
					((VyF) array[i]).setRespuestaCorrecta("v");
				}
				if (array[i].getPregunta() == "Elon Mask es millonario?") {
					((VyF) array[i]).setRespuestaCorrecta("v");
				}
				if (array[i].getPregunta() == "Existen los ordenadores multiprocesador?") {
					((VyF) array[i]).setRespuestaCorrecta("v");
				}
				if (array[i].getPregunta() == "Es programación la mejor asignatura?") {
					((VyF) array[i]).setRespuestaCorrecta("v");
				}
			}
			if (array[i] instanceof Estandar) {
				if (array[i].getPregunta() == "Que país no es de la UE?") {
					array[i].setRespuesta("(A). España\n(B). Francia\n(C). Italia\n(D). China");
					((Estandar) array[i]).setRespuestaCorrecta("d");
				}
				if (array[i].getPregunta() == "Que río es de España?") {
					array[i].setRespuesta("(A). Nilo\n(B). Amazonas\n(C). Tajo\n(D). Paraná");
					((Estandar) array[i]).setRespuestaCorrecta("c");
				}
				if (array[i].getPregunta() == "Que actor es Amador Rivas en LQSA?") {
					array[i].setRespuesta(
							"(A). Jose Luis Gil\n(B). Pablo Chiapella\n(C). Jordi Sánchez\n(D). Nacho Guerreros");
					((Estandar) array[i]).setRespuestaCorrecta("b");
				}
				if (array[i].getPregunta() == "Que animal es mas grande?") {
					array[i].setRespuesta("(A). Perro\n(B). Gato\n(C). Conejo\n(D). Cóndor");
					((Estandar) array[i]).setRespuestaCorrecta("d");
				}
				if (array[i].getPregunta() == "Selecciona el factorial de 6") {
					array[i].setRespuesta("(A). 720\n(B). 5040\n(C). 255\n(D). 12345");
					((Estandar) array[i]).setRespuestaCorrecta("a");
				}
			}
		}
	}

	/**
	 * 
	 * @param array
	 */
	private static int verPreguntas(Pregunta[] array) {
		Scanner sc = new Scanner(System.in);
		String respuesta;
		int puntos = 0;
		for (int i = 0; i < array.length; i++) {

			if (array[i] instanceof Estandar) {
				System.out.println("Estandar: " + array[i].getPregunta());
				System.out.println("Responda opción (A - D)");
				System.out.println(((Estandar) array[i]).getRespuesta());
				respuesta = sc.next();
				if (respuesta.equalsIgnoreCase("a") || respuesta.equalsIgnoreCase("b")
						|| respuesta.equalsIgnoreCase("c") || respuesta.equalsIgnoreCase("d")) {
					if (respuesta.equalsIgnoreCase(((Estandar) array[i]).getRespuestaCorrecta())) {
						puntos += 1;
					}
				} else {
					sc.nextLine();
					System.out.println("Respuesta no válida");
				}
			}

			if (array[i] instanceof VyF) {
				System.out.println("Verdadero o Falso: " + array[i].getPregunta());
				System.out.println("Responda opción (V o F)");
				respuesta = sc.next();
				if (respuesta.equalsIgnoreCase("v") || respuesta.equalsIgnoreCase("f")) {
					if (respuesta.equalsIgnoreCase(((VyF) array[i]).getRespuestaCorrecta())) {
						puntos += 1;
					}
				} else {
					sc.nextLine();
					System.out.println("Respuesta no válida");
				}
			}
		}
		return puntos;
	}

	/**
	 * 
	 * @param array
	 */
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

	/**
	 * 
	 * @param array
	 */
	private static void crearPreguntas(Pregunta[] array) {
		String preguntasVyF[] = new String[5];
		String preguntasEstandar[] = new String[5];
		byte j = 0;
		preguntasEstandar[0] = "Que país no es de la UE?";
		preguntasEstandar[1] = "Que río es de España?";
		preguntasEstandar[2] = "Que actor es Amador Rivas en LQSA?";
		preguntasEstandar[3] = "Que animal es mas grande?";
		preguntasEstandar[4] = "Selecciona el factorial de 6";
		preguntasVyF[0] = "El buggati chiron alcanza los 600Km/h?";
		preguntasVyF[1] = "Es Pedro Sanchez el actual presidente de España?";
		preguntasVyF[2] = "Elon Mask es millonario?";
		preguntasVyF[3] = "Existen los ordenadores multiprocesador?";
		preguntasVyF[4] = "Es programación la mejor asignatura?";
		mezclarPreguntas(preguntasEstandar, preguntasVyF);
		for (int i = 0; i < array.length; i++) {
			if (array[i] instanceof Estandar) {
				array[i].setPregunta(preguntasEstandar[j]);
			}
			if (array[i] instanceof VyF) {
				array[i].setPregunta(preguntasVyF[j]);
			}
			j++;
		}
		crearRespuestas(array);
	}

	/**
	 * 
	 * @param preguntasEstandar
	 * @param preguntasVyF
	 */
	private static void mezclarPreguntas(String[] preguntasEstandar, String[] preguntasVyF) {
		int random = 0;
		String aux = "";
		for (int i = 0; i < preguntasVyF.length; i++) {
			random = (int) Math.round(Math.random() * preguntasVyF.length - 1);
			if (random < 0) {
				i--;
				break;
			}
			if (random < preguntasVyF.length - 1) {
				aux = preguntasVyF[random];
				preguntasVyF[random] = preguntasVyF[random + 1];
				preguntasVyF[random + 1] = aux;
			}
		}
		for (int i = 0; i < preguntasEstandar.length; i++) {
			random = (int) Math.round(Math.random() * preguntasEstandar.length - 1);
			if (random < 0) {
				i--;
				break;
			}
			if (random < preguntasEstandar.length - 1) {
				aux = preguntasEstandar[random];
				preguntasEstandar[random] = preguntasEstandar[random + 1];
				preguntasEstandar[random + 1] = aux;
			}
		}
	}
}
