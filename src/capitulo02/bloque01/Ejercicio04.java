package capitulo02.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio04 {

	public static void main(String[] args) {

		String var1 = JOptionPane.showInputDialog("Introduzca la primera variable: ");
		int x = Integer.parseInt(var1);

		String var2 = JOptionPane.showInputDialog("Introduzca la segunda variable: ");
		int y = Integer.parseInt(var2);

		String var3 = JOptionPane.showInputDialog("Introduzca la tercera variable: ");
		int z = Integer.parseInt(var3);

		String var4 = JOptionPane.showInputDialog("Introduzca la cuarta variable: ");
		int a = Integer.parseInt(var4);

		String var5 = JOptionPane.showInputDialog("Introduzca la quinta variable: ");
		int b = Integer.parseInt(var5);

		if (x <= y && x <= z && x <= a && x <= b) {
			System.out.println("El valor más bajo es: " + x);
		}

		else {

			if (y <= x && y <= z && y <= a && y <= b) {
				System.out.println("El valor más bajo es: " + y);
			} else {

				if (z <= x && z <= y && z <= a && z <= b) {
					System.out.println("El valor más bajo es: " + z);
				} else {

					if (a <= y && a <= z && a <= x && a <= b) {
						System.out.println("El valor más bajo es: " + a);
					} else {

						if (b <= y && b <= z && b <= a && b <= x) {
							System.out.println("El valor más bajo es: " + b);
						} 
					}
				}
			}

		}

	}

}
		
	


