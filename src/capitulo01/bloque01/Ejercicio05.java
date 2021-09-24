package capitulo01.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio05 {

	public static void main(String[] args) {

		String str1 = JOptionPane.showInputDialog("Escribe la primera variable: ");
		String str2 = JOptionPane.showInputDialog("Escribe la segunda variable: ");
		System.out.println("(Antes)" + "La primera variable es: " + str1 + "\nLa segunda variable es: " + str2);
		//Intercambio de variables
		int var1 = Integer.parseInt(str1);
		int var2 = Integer.parseInt(str2);
		System.out.println("\n(Después)" + "La primera variable es: "+ var1 + "\nLa segunda variable es: " + var2);
		
	}

}
