package capitulo01.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio03 {

	public static void main(String[] args) {

	String primero = JOptionPane.showInputDialog("Dime el primer número: "); //Doy por hecho que los numeros son int y no float
	int primeroInt = Integer.parseInt(primero);
	
	String segundo = JOptionPane.showInputDialog("Dime el segundo número: ");
	int segundoInt = Integer.parseInt(segundo);
	
	String tercero = JOptionPane.showInputDialog("Dime el tercer número: ");
	int terceroInt = Integer.parseInt(tercero);
	
	System.out.println("La suma de los números es: " + (primeroInt + segundoInt + terceroInt));	//Suma de las variables

		
	}

}
