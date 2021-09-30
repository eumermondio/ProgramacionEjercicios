package capitulo02.bloque02;

import javax.swing.JOptionPane;

public class Ejercicio02 {

	public static void main(String[] args) {

		String var1 = JOptionPane.showInputDialog("Introduzca el primer número: ");
		float x = Float.parseFloat(var1);
		
		if (x < 0) {
			return; 	
		}
		
		System.out.println("El número introducido fue: " + x);

		float aSumax2 = 0;
		float aSumax3 = 0;
		float aSumax4 = 0;
		int acumulante1 = 0;
		int acumulante2 = 0;
		int acumulante3 = 0;
		int acumulante4 = 0;
		int acumulante5 = 0;
		int acumulante6 = 0;
		int acumulante7 = 0;
		int acumulante8 = 0;
		int acumulante9 = 0;
		int acumulante10 = 0;
		int acumulante11 = 0;
		int acumulante12 = 0;



		if (x >= 0 && x <= 25) {
			System.out.println("La clasificación del número es: Bajo");
			acumulante1 = (int) aSumax2 + 1;

		} else {
			if (x >= 26 && x <= 250) {
				System.out.println("La clasificación del número es: Medio");
				acumulante2 = (int) aSumax3 + 1;

			} else {
				if (x >= 251) {
					System.out.println("La clasificación del número es: Alto");
					acumulante3 = (int) aSumax4 + 1;

				}

			}

		}

		String var2 = JOptionPane.showInputDialog("Introduzca el primer número: ");
		float y = Float.parseFloat(var2);
		
		if (y < 0) {
			return; 	
		}
		
		System.out.println("El número introducido fue: " + y);

		float aSumay2 = 0;
		float aSumay3 = 0;
		float aSumay4 = 0;

		if (y >= 0 && y <= 25) {
			System.out.println("La clasificación del número es: Bajo");
			acumulante4 = (int) aSumay2 + 1;

		} else {
			if (y >= 26 && y <= 250) {
				System.out.println("La clasificación del número es: Medio");
				acumulante5 = (int) aSumay3 + 1;

			} else {
				if (y >= 251) {
					System.out.println("La clasificación del número es: Alto");
					acumulante6 = (int) aSumay4 + 1;

				}
			}
		}

		String var3 = JOptionPane.showInputDialog("Introduzca el primer número: ");
		float z = Float.parseFloat(var3);
		
		if (z < 0) {
			return; 	
		}
		
		System.out.println("El número introducido fue: " + z);

		float aSumaz2 = 0;
		float aSumaz3 = 0;
		float aSumaz4 = 0;

		if (z >= 0 && z <= 25) {
			System.out.println("La clasificación del número es: Bajo");
			acumulante7 = (int) aSumaz2 + 1;

		} else {
			if (z >= 26 && z <= 250) {
				System.out.println("La clasificación del número es: Medio");
				acumulante8 = (int) aSumaz3 + 1;

			} else {
				if (z >= 251) {
					System.out.println("La clasificación del número es: Alto");
					acumulante9 = (int) aSumaz4 + 1;

				}

			}

		}
		String var4 = JOptionPane.showInputDialog("Introduzca el primer número: ");
		float a = Float.parseFloat(var4);
		
		if (a < 0) {
			return; 	
		}
		
		System.out.println("El número introducido fue: " + a);

		float aSumaa2 = 0;
		float aSumaa3 = 0;
		float aSumaa4 = 0;

		if (a >= 0 && a <= 25) {
			System.out.println("La clasificación del número es: Bajo");
			acumulante10 = (int) aSumaa2 + 1;

		} else {
			if (a >= 26 && a <= 250) {
				System.out.println("La clasificación del número es: Medio");
				acumulante11 = (int) aSumaa3 + 1;

			} else {
				if (a >= 251) {
					System.out.println("La clasificación del número es: Alto");
					acumulante12 = (int) aSumaa4 + 1;

				}
			}

		}
		
		int bajos = acumulante1 + acumulante4 + acumulante7 + acumulante10;
		int medios = acumulante2 + acumulante5 + acumulante8 + acumulante11;
		int altos = acumulante3 + acumulante6 + acumulante9 + acumulante12;


		System.out.println("Números introducidos en la categoría Bajos: " + bajos);
		System.out.println("Números introducidos en la categoría Medios: " + medios);
		System.out.println("Números introducidos en la categoría Altos: " + altos);

		
		
		
		/*
		
		float sumaBajo = aSumax2 + aSumay2 + aSumaz2 + aSumaa2;
		System.out.println("La suma de todos los números de la categoría Bajo es: " + sumaBajo);

		float sumaMedio = aSumax3 + aSumay3 + aSumaz3 + aSumaa3;
		System.out.println("La suma de todos los números de la categoría Medio es: " + sumaMedio);

		float sumaAlto = aSumax4 + aSumay4 + aSumaz4 + aSumaa4;
		System.out.println("La suma de todos los números de la categoría Alto es: " + sumaAlto);

		
		*/
		
		
		
	}

}
