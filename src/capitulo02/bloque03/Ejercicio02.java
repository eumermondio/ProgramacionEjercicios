package capitulo02.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio02 {

	public static void main(String[] args) {

		System.out.println("--------Calculadora Avanzada-------");
		System.out.println("0.-Salir");
		System.out.println("1.-Raíces");
		System.out.println("2.-Potencias");
		System.out.println("3.-Módulo de la división");

		int x, y;

		String str = JOptionPane.showInputDialog("Bienvenido a calculadora avanzada, Dime la opción deseada");
		int opcion = Integer.parseInt(str);

		switch (opcion) {
		case 0:
			break;
		case 1:
			str = JOptionPane.showInputDialog("Modo raíces seleccionado\nDígame el radicando");
			x = Integer.parseInt(str);
			str = JOptionPane.showInputDialog("Dígame el índice");
			y = Integer.parseInt(str);
			System.out.println("El resultado es: " + Math.pow(x, 1.0f / y));
			break;
		case 2:
			str = JOptionPane.showInputDialog("Modo potencias seleccionado\nDígame la base");
			x = Integer.parseInt(str);
			str = JOptionPane.showInputDialog("Dígame el exponente");
			y = Integer.parseInt(str);
			System.out.println("El resultado es: " + Math.pow(x, y));
			break;
		case 3:
			str = JOptionPane.showInputDialog("Modo división seleccionado\nDígame el dividendo");
			x = Integer.parseInt(str);
			str = JOptionPane.showInputDialog("Dígame el divisor");
			y = Integer.parseInt(str);
			System.out.println("El resto es: " + (x % y));

		}

	}

}
