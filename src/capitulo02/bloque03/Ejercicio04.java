package capitulo02.bloque03;

import javax.swing.JOptionPane;

public class Ejercicio04 {

	public static void main(String[] args) {

		String str;
		int importe, cantidadPagada, cambio;
		int acumulado = 0;
		int devolver = 0;
		int devolver2 = 0;
		int devolver3 = 0;
		int devolver4 = 0;
		int devolver5 = 0;

		str = JOptionPane.showInputDialog("Introduzca el importe de la compra");
		importe = Integer.parseInt(str);

		str = JOptionPane.showInputDialog("Introduzca la cantidad pagada");
		cantidadPagada = Integer.parseInt(str);

		cambio = cantidadPagada - importe;
		
		System.out.println("El cambio (en unidades monetarias) es: " + cambio);

		if (cambio < 0) {
			System.out.println("El cambio a devolver no puede ser negativo, "
					+ "el cliente no ha pagado lo suficiente para adquirir el " + "artículo");
			return;
		}
		if (cambio == 0) {
			System.out.println("El cliente ha pagado el importe total del artículo, " + "no ha de devolverle nada");
			return;
		}

		if (cambio > 0) {
			devolver = cambio / 100;
			System.out.println(devolver + " Monedas de 100 = " + devolver * 100);
			acumulado = (cambio - (devolver * 100));
			System.out.println(acumulado);
						
		}
		if (acumulado != 0){
			devolver2 = acumulado / 50;
			System.out.println(devolver2 + " Monedas de 50 = " + devolver2 * 50);
			acumulado = (cambio - (devolver2 * 50) - devolver * 100);
			System.out.println(acumulado);	
		}
		if (acumulado != 0){
			devolver3 = acumulado / 25;
			System.out.println(devolver3 + " Monedas de 25 = " + devolver3 * 25);
			acumulado = (cambio - (devolver3 * 25) - devolver2 * 50 - devolver * 100);
			System.out.println(acumulado);	
		}
		if (acumulado != 0){
			devolver4 = acumulado / 5;
			System.out.println(devolver4 + " Monedas de 5 = " + devolver4 * 5);
			acumulado = (cambio - (devolver4 * 5) - devolver3 * 25 - devolver2 * 50 - devolver * 100);
			System.out.println(acumulado);	
		}
		if (acumulado != 0){
			devolver5 = acumulado / 1;
			System.out.println(devolver5 + " Monedas de 1 = " + devolver5 * 1);
			acumulado = (cambio - (devolver5 * 1) - devolver4 * 5 - devolver3 * 25 - devolver2 * 50 - devolver * 100);
			System.out.println(acumulado);	
		}

		
	}

}
