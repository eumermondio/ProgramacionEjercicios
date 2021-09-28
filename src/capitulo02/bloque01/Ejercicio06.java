package capitulo02.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio06 {

	public static void main(String[] args) {

		String var1 = JOptionPane.showInputDialog("Introduce un número: ");
		int x = Integer.parseInt(var1);
		
		int resto= x % 2;
		
		if (resto == 0) {
			System.out.println("El número introducido fue: " + x + ", Se trata de un número par");
		}
		else {
			System.out.println("El número introducido fue: " + x + ", Se trata de un número impar");

		}
		
	}

}
