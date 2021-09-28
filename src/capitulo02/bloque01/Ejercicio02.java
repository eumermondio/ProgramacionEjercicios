package capitulo02.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio02 {

	public static void main(String[] args) {

		String var1 = JOptionPane.showInputDialog("Introduzca la primera variable: ");
		int x = Integer.parseInt(var1);
		
		String var2 = JOptionPane.showInputDialog("Introduzca la segunda variable: ");
		int y = Integer.parseInt(var2);
		
		if (x < y) {
			System.out.println("El valor menor introducido es: " + x);
		}
		
		else {
			System.out.println("El valor menor introducido es: " + y);

		}
		
	}

}
