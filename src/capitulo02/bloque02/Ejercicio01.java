package capitulo02.bloque02;

import javax.swing.JOptionPane;

public class Ejercicio01 {

	public static void main(String[] args) {

		String var1 = JOptionPane.showInputDialog("Introduzca el primer número: ");
		float x = Float.parseFloat(var1);
		System.out.println("El número introducido fue: " + x);
		if (x <= -0.1) {
			System.out.println("La clasificación del número es: Negativo");
		}
		
		String var2 = JOptionPane.showInputDialog("Introduzca el segundo número: ");
		float y = Float.parseFloat(var2);
		System.out.println("El número introducido fue: " + y);
		if (y >= 0 && y <= 25) {
			System.out.println("La clasificación del número es: Bajo");
		}
		
		String var3 = JOptionPane.showInputDialog("Introduzca el segundo número: ");
		float z = Float.parseFloat(var3);
		System.out.println("El número introducido fue: " + z);
		if (z >= 26 && z <= 250) {
			System.out.println("La clasificación del número es: Medio");
	}

}
}
