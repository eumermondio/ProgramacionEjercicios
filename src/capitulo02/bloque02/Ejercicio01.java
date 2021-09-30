package capitulo02.bloque02;

import javax.swing.JOptionPane;

public class Ejercicio01 {

	public static void main(String[] args) {

		String var1 = JOptionPane.showInputDialog("Introduzca el primer número: ");
		float x = Float.parseFloat(var1);
		System.out.println("El número introducido fue: " + x);

		float aSumax1 = 0;
		float aSumax2 = 0;
		float aSumax3 = 0;
		float aSumax4 = 0;

		if (x <= -0.1) {
			System.out.println("La clasificación del número es: Negativo");
			aSumax1 = x;
		} else {
			if (x >= 0 && x <= 25) {
				System.out.println("La clasificación del número es: Bajo");
				aSumax2 = x;

			} else {
				if (x >= 26 && x <= 250) {
					System.out.println("La clasificación del número es: Medio");
					aSumax3 = x;

				} else {
					if (x >= 251) {
						System.out.println("La clasificación del número es: Alto");
						aSumax4 = x;

					}
				}
			}

		}

		String var2 = JOptionPane.showInputDialog("Introduzca el primer número: ");
		float y = Float.parseFloat(var2);
		System.out.println("El número introducido fue: " + y);

		float aSumay1 = 0;
		float aSumay2 = 0;
		float aSumay3 = 0;
		float aSumay4 = 0;

		if (y <= -0.1) {
			System.out.println("La clasificación del número es: Negativo");
			aSumay1 = y;
		} else {
			if (y >= 0 && y <= 25) {
				System.out.println("La clasificación del número es: Bajo");
				aSumay2 = y;

			} else {
				if (y >= 26 && y <= 250) {
					System.out.println("La clasificación del número es: Medio");
					aSumay3 = y;

				} else {
					if (y >= 251) {
						System.out.println("La clasificación del número es: Alto");
						aSumay4 = y;

					}
				}
			}

		}

		String var3 = JOptionPane.showInputDialog("Introduzca el primer número: ");
		float z = Float.parseFloat(var3);
		System.out.println("El número introducido fue: " + z);

		float aSumaz1 = 0;
		float aSumaz2 = 0;
		float aSumaz3 = 0;
		float aSumaz4 = 0;

		if (z <= -0.1) {
			System.out.println("La clasificación del número es: Negativo");
			aSumaz1 = z;
		} else {
			if (z >= 0 && z <= 25) {
				System.out.println("La clasificación del número es: Bajo");
				aSumaz2 = z;

			} else {
				if (z >= 26 && z <= 250) {
					System.out.println("La clasificación del número es: Medio");
					aSumaz3 = z;

				} else {
					if (z >= 251) {
						System.out.println("La clasificación del número es: Alto");
						aSumaz4 = z;

					}
				}
			}

		}
		String var4 = JOptionPane.showInputDialog("Introduzca el primer número: ");
		float a = Float.parseFloat(var4);
		System.out.println("El número introducido fue: " + a);

		float aSumaa1 = 0;
		float aSumaa2 = 0;
		float aSumaa3 = 0;
		float aSumaa4 = 0;

		if (a <= -0.1) {
			System.out.println("La clasificación del número es: Negativo");
			aSumaa1 = a;
		} else {
			if (a >= 0 && a <= 25) {
				System.out.println("La clasificación del número es: Bajo");
				aSumaa2 = a;

			} else {
				if (a >= 26 && a <= 250) {
					System.out.println("La clasificación del número es: Medio");
					aSumaa3 = a;

				} else {
					if (a >= 251) {
						System.out.println("La clasificación del número es: Alto");
						aSumaa4 = a;

					}
				}
			}

		}
		
		String var5 = JOptionPane.showInputDialog("Introduzca el primer número: ");
		float b = Float.parseFloat(var5);
		System.out.println("El número introducido fue: " + b);

		float aSumab1 = 0;
		float aSumab2 = 0;
		float aSumab3 = 0;
		float aSumab4 = 0;

		if (b <= -0.1) {
			System.out.println("La clasificación del número es: Negativo");
			aSumab1 = b;
		} else {
			if (b >= 0 && b <= 25) {
				System.out.println("La clasificación del número es: Bajo");
				aSumab2 = b;

			} else {
				if (b >= 26 && b <= 250) {
					System.out.println("La clasificación del número es: Medio");
					aSumab3 = b;

				} else {
					if (b >= 251) {
						System.out.println("La clasificación del número es: Alto");
						aSumab4 = b;

					}
				}
			}

		}

		float sumaNegativo = aSumax1 + aSumay1 + aSumaz1 + aSumaa1 + aSumab1;
		System.out.println("La suma de todos los números de la categoría Negativo es: " + sumaNegativo);

		float sumaBajo = aSumax2 + aSumay2 + aSumaz2 + aSumaa2 + aSumab2;
		System.out.println("La suma de todos los números de la categoría Bajo es: " + sumaBajo);

		float sumaMedio = aSumax3 + aSumay3 + aSumaz3 + aSumaa3 + aSumab3;
		System.out.println("La suma de todos los números de la categoría Medio es: " + sumaMedio);

		float sumaAlto = aSumax4 + aSumay4 + aSumaz4 + aSumaa4 + aSumab4;
		System.out.println("La suma de todos los números de la categoría Alto es: " + sumaAlto);

	}
}


/*

String var2 = JOptionPane.showInputDialog("Introduzca el primer número: ");
float y = Float.parseFloat(var2);
System.out.println("El número introducido fue: " + y);
if (y <= -0.1) {
	System.out.println("La clasificación del número es: Negativo");
}
float aSumay1 = y;

if (y >= 0 && y <= 25) {
	System.out.println("La clasificación del número es: Bajo");
}
float aSumay2 = y;

if (y >= 26 && y <= 250) {
	System.out.println("La clasificación del número es: Medio");
}
float aSumay3 = y;

if (y >= 251) {
	System.out.println("La clasificación del número es: Alto");
}
float aSumay4 = y;

String var3 = JOptionPane.showInputDialog("Introduzca el primer número: ");
float z = Float.parseFloat(var3);
System.out.println("El número introducido fue: " + z);
if (z <= -0.1) {
	System.out.println("La clasificación del número es: Negativo");
}
float aSumaz1 = z;

if (z >= 0 && z <= 25) {
	System.out.println("La clasificación del número es: Bajo");
}
float aSumaz2 = z;

if (z >= 26 && z <= 250) {
	System.out.println("La clasificación del número es: Medio");
}
float aSumaz3 = z;

if (z >= 251) {
	System.out.println("La clasificación del número es: Alto");
}
float aSumaz4 = z;

String var4 = JOptionPane.showInputDialog("Introduzca el primer número: ");
float a = Float.parseFloat(var4);
System.out.println("El número introducido fue: " + a);
if (a <= -0.1) {
	System.out.println("La clasificación del número es: Negativo");
}
float aSumaa1 = a;

if (a >= 0 && a <= 25) {
	System.out.println("La clasificación del número es: Bajo");
}
float aSumaa2 = a;

if (a >= 26 && a <= 250) {
	System.out.println("La clasificación del número es: Medio");
}
float aSumaa3 = a;

if (a >= 251) {
	System.out.println("La clasificación del número es: Alto");
}
float aSumaa4 = a;

*
*/