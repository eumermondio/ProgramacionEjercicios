package capitulo01.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio01 {

	public static void main(String[] args) {
		String str = JOptionPane.showInputDialog("Introduzca un número entero: ");
		int var1 = Integer.parseInt(str);
		
		str = JOptionPane.showInputDialog("Introduzca un número flotante: ");
		float var2 = Float.parseFloat(str);
		
		str = JOptionPane.showInputDialog("Introduzca un número double: ");
		double var3 = Double.parseDouble(str);
		
		System.out.println("Número introducido: " + var1 + " ,número flotante: " + var2 + " ,número double: " + var3);
	}

}
