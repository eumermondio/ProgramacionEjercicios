package capitulo02.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio03 {

	public static void main(String[] args) {

		System.out.println("--------Calculadora Avanzada-------");
		System.out.println("0.-Salir");
		System.out.println("1.-Cálculo de la hipotenusa de un triángulo");
		System.out.println("2.-Cálculo de la superficie de una circunferencia.");
		System.out.println("3.-Cálculo del perímetro de una circunferencia.");
		System.out.println("4.-Cálculo del área de un rectángulo.");
		System.out.println("5.-Cálculo del área de un triángulo.");

		int x, y;
		double resultado, pi;
		pi = 3.1416;

		String str = JOptionPane.showInputDialog("Bienvenido a calculadora avanzada, Dime la opción deseada");
		int opcion = Integer.parseInt(str);

		switch (opcion) {
		case 0:
			break;
		case 1:
			str = JOptionPane.showInputDialog("Opción seleccionada: Cálculo de la hipotenusa\nIntroduzca el valor de un cateto");
			x = Integer.parseInt(str);
			str = JOptionPane.showInputDialog("Introduzca el valor de otro cateto");
			y = Integer.parseInt(str);
			resultado = (float) (Math.pow(x, 2.0f) + Math.pow(y, 2.0f));
			System.out.println("El resultado de la hipotenusa es: " + (Math.pow(resultado, 1/2.0f)));
			break;
		case 2:
			str = JOptionPane.showInputDialog("Opción seleccionada: Cálculo de la superficie\nDígame la longitud del radio");
			x = Integer.parseInt(str);
			resultado = (Math.pow(x, 2.0f) * pi);
			System.out.println("El resultado de la superficie es: " + resultado);
			break;
		case 3:
			str = JOptionPane.showInputDialog("Opción seleccionada: Cálculo del perímetro\nDígame la longitud del radio");
			x = Integer.parseInt(str);
			resultado = (2 * pi) * x;
			System.out.println("El resultado de el perímetro es de: " + resultado);

		}

	}

}


