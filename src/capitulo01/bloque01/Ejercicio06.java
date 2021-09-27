package capitulo01.bloque01;

import javax.swing.JOptionPane;

public class Ejercicio06 {

	public static void main(String[] args) {

		String var1 = JOptionPane.showInputDialog("Introduzca el actual valor del euríbor: ");
		float euribor = Float.parseFloat(var1);
		
		String var2 = JOptionPane.showInputDialog("Introduzca el diferencial: ");
		float diferencial = Float.parseFloat(var2);
		
		String var3 = JOptionPane.showInputDialog("Introduzca el capital: ");
		float capital = Float.parseFloat(var3);
		
		String var4 = JOptionPane.showInputDialog("Introduzca el número de plazos mensuales: ");
		int plazosMensuales = Integer.parseInt(var4);
		
		//Cálculo del interés anual
		
		float interesAnual = euribor + diferencial;
		System.out.println("El interés anual del banco será de: " + interesAnual);
		
		//Cálculo del interés mensual
		
		float var5 = interesAnual / 12;
		float interesMensual = var5 / 100;
		System.out.println("El interés mensual del banco será de: " + interesMensual);
		
		//Cálculo de la cuota mensual
		
		float parte1 = (interesMensual * (1 + interesMensual));
		double parte2 = Math.pow(parte1, plazosMensuales);
		double parte4 = 1 + interesMensual;
		double parte5 = Math.pow(parte4, plazosMensuales);
		double parte6 = parte5 - 1;
		double cuotaMensual = (parte2 / parte6) * capital;
		System.out.println("La cuota mensual es de: " + cuotaMensual);
		
		
	}

}


// 0.1          1                 150000                   120 


/*
 * Se deben pedir al usuario los datos de Euribor (float), Diferencial (float), Capital (float) y
 *  Número de plazos mensuales para pagar la hipoteca (int). A partir de esos datos se debe calcular y 
 *  mostrar al usuario el importe de la cuota mensual.*/
 
/*
 * Interés Anual = Euribor + Diferencial (Ganancia del banco o caja)
Capital = Cantidad de unidades monetarias de la hipoteca
N = Número de plazos mensuales de la hipoteca.
*/
