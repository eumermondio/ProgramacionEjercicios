package capitulo01.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio02 {

	public static void main(String[] args) {
		
		String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		int var1 = Integer.parseInt(str);
		System.out.println("Número introducido: " + var1);
		
		String str2 = JOptionPane.showInputDialog("Introduzca un número flotante: ");
		float var2 = Float.parseFloat(str2);
		System.out.println("Número introducido: " + var2);
		
		String str3 = JOptionPane.showInputDialog("Introduzca un número double: ");
		double var3 = Double.parseDouble(str3);
		System.out.println("Número introducido: " + var3);
		
	}

}
