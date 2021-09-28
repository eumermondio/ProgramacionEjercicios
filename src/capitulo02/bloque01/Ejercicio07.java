package capitulo02.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio07 {

	public static void main(String[] args) {

		int constante = 1;
		String var1 = JOptionPane.showInputDialog("Introduce un número: ");
		int x = Integer.parseInt(var1);
		
		int y = x & constante;
		
		if (y != 0) {
		System.out.println("El número introducido era impar");
	}
		else {
			System.out.println("El número introducido era par");
		}

}
}
