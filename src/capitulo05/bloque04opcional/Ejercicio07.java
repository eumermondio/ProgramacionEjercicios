package capitulo05.bloque04opcional;

import java.util.Scanner;

public class Ejercicio07 {

	public static void main(String[] args) {

		// DECLARACION DE VARIABLES

		int filaArriba[] = new int[3];
		int filaMedio[] = new int[3];
		int filaAbajo[] = new int[3];

		int opcion = 1, fila = 1, colu = 1;
		boolean victoria1 = false;
		boolean victoria2 = false;

		Scanner sc = new Scanner(System.in);

		// MOSTRAR MENU Y PEDIR OPCION

		System.out.println("\tJUEGO DE TRES EN RAYA");
		System.out.println("OPCIONES:");
		System.out.println("0. Salir");
		System.out.println("1. Tutorial");
		System.out.println("2. Jugar");
		opcion = sc.nextInt();

		// COMPROBAR OPCIONES

		if (opcion == 0) {
			return;
		}
		if (opcion == 1) {

			System.out.println("Opción seleccionada: \nTutorial");
			System.out.println(
					"Bienvenido a tres en raya, consta de 2 jugadores que ponen una posición en\nun tablero de 3x3, gana quien junte "
							+ "3 posiciones seguidas en el tablero de forma vertical, horizontal o diagonal, las posiciones de indican"
							+ " asi: numero fila + numero columna asimismo\npara poner una posicion en la esquina superior derecha debes poner esto: 1 y 0, el centro: 2 y 1");
			return;
		}

		// CUERPO DEL JUEGO

		if (opcion == 2) {

			// MOSTRAR EL TABLERO POR PRIMERA VEZ

			for (int i = 0; i < filaArriba.length; i++) {
				System.out.print(filaArriba[i] + " ");
			}
			System.out.println();
			for (int i = 0; i < filaMedio.length; i++) {
				System.out.print(filaMedio[i] + " ");
			}
			System.out.println("");
			for (int i = 0; i < filaAbajo.length; i++) {
				System.out.print(filaAbajo[i] + " ");
			}

			System.out.println("");

			// DE AQUI EN ADELANTE EL SIGUIENTE FOR CONTEMPLA LAS 7 JUGADAS QUE PUEDE HABER
			// EN UN JUEGO ( 6 POSICIONAMIENTOS MAXIMO )
			// DESPUES EN CASO DE QUE EL NUMERO DE MOVIMIENTO SEA IMPAR, JUGARÁ EL 1, EN
			// CASO DE QUE SEA PAR JUGARÁ EL 2, HE USADO LAS
			// POSIBILIDADES DE JUGADAS COMO DISCRIMINANTE PARA SABER SI ESTARÁ JUGANDO 1 O
			// 2 YA QUE SOLO HAY 2 JUGADORES Y ÉSTOS
			// SOLAMENTE PODRÁN MOVER EN JUGADAS ALTERNATIVAS, DE OTRA FORMA EL TABLERO SOLO
			// SE RELLENARA CON 1's
			// ESO SE EJECUTARA MIENTRAS NO HAYA GANADO NADIE
			// DESPUES SE ELIGEN LAS COORDENADAS DEL TABLERO Y SE COMPRUEBA QUE SEAN VALORES
			// VÁLIDOS
			// LOS 3 FOR SIGUIENTE CONSISTEN EN IDENTIFICAR LAS COORDENADAS Y PONER EL DATO
			// 1 O 2 DEPENDIENDO DEL JUGADOR, EN CASO DE
			// QUE ESA CASILLA YA ESTE OCUPADA NO HARA NADA

			for (int movs = 7; movs > 0; movs--) {
				if ((movs & 1) == 1) {
					while (!victoria1) {
						System.out.println("Jugador 1");
						System.out.println("Elige fila");
						fila = sc.nextInt();
						System.out.println("Elige columna");
						colu = sc.nextInt();
						if ((fila < 0 || fila > 3) || (colu < 0 || colu > 2)) {
							return;
						}
						
						// RECORRER FILA DE ARRIBA Y EN CASO DE QUE LA FILA SEA 1, ES DECIR ESA FILA ES LA SELECCIONADA,
						// Y NO ESTA OCUPADA INSERTARÁ UN 1 A LA COLUMNA, ES DECIR, EL INDICE DEL ARRAY
						
						for (int i = 0; i < filaArriba.length; i++) {

							if (fila == 1 && (filaArriba[colu] != 1) && (filaArriba[colu] != 2)) {
								filaArriba[colu] = 1;

							}

						}
						
						// MOSTRAR FILA EN PANTALLA

						for (int i = 0; i < filaArriba.length; i++) {
							System.out.print(filaArriba[i] + " ");
						}

						System.out.println("");
						
						// RECORRER FILA DE MEDIO Y EN CASO DE QUE LA FILA SEA 2, ES DECIR ESA FILA ES LA SELECCIONADA,
						// Y NO ESTA OCUPADA INSERTARÁ UN 1 A LA COLUMNA, ES DECIR, EL INDICE DEL ARRAY

						for (int i = 0; i < filaMedio.length; i++) {

							if (fila == 2 && (filaMedio[colu] != 1) && (filaMedio[colu] != 2)) {
								filaMedio[colu] = 1;
							}

						}
						
						// MOSTRAR FILA EN PANTALLA

						for (int i = 0; i < filaMedio.length; i++) {
							System.out.print(filaMedio[i] + " ");
						}

						System.out.println("");

						// RECORRER FILA DE ABAJO Y EN CASO DE QUE LA FILA SEA 3, ES DECIR ESA FILA ES LA SELECCIONADA,
						// Y NO ESTA OCUPADA INSERTARÁ UN 1 A LA COLUMNA, ES DECIR, EL INDICE DEL ARRAY
						
						for (int i = 0; i < filaAbajo.length; i++) {

							if (fila == 3 && (filaAbajo[colu] != 1) && (filaAbajo[colu] != 2)) {

								filaAbajo[colu] = 1;

							}

						}
						
						// MOSTRAR FILA EN PANTALLA
						
						for (int i = 0; i < filaAbajo.length; i++) {
							System.out.print(filaAbajo[i] + " ");
						}

						System.out.println("");

						break;

					}
				}
				
				// PARTE DEL JUGADOR 2, LO MISMO QUE PARA EL JUGADOR 1 PERO EN VEZ DE METER EL VALOR 1 AL ARRAY METO EL 2

				if ((movs & 1) == 0) {
					while (!victoria2) {
						System.out.println("Jugador 2");
						System.out.println("Elige fila");
						fila = sc.nextInt();
						System.out.println("Elige columna");
						colu = sc.nextInt();
						if ((fila < 0 || fila > 3) || (colu < 0 || colu > 2)) {
							return;
						}

						for (int i = 0; i < filaArriba.length; i++) {

							if (fila == 1 && (filaArriba[colu] != 1) && (filaArriba[colu] != 2)) {
								filaArriba[colu] = 2;

							}

						}

						for (int i = 0; i < filaArriba.length; i++) {
							System.out.print(filaArriba[i] + " ");
						}

						System.out.println();

						for (int i = 0; i < filaMedio.length; i++) {

							if (fila == 2 && (filaMedio[colu] != 1) && (filaMedio[colu] != 2)) {
								filaMedio[colu] = 2;

							}

						}

						for (int i = 0; i < filaMedio.length; i++) {
							System.out.print(filaMedio[i] + " ");
						}

						System.out.println("");

						for (int i = 0; i < filaAbajo.length; i++) {

							if (fila == 3 && (filaAbajo[colu] != 1) && (filaAbajo[colu] != 2)) {

								filaAbajo[colu] = 2;

							}

						}

						for (int i = 0; i < filaAbajo.length; i++) {
							System.out.print(filaAbajo[i] + " ");
						}

						System.out.println("");

						break;

					}
				}

			}
		}

	}

}


// HACER CONDICION DE VICTORIAS