package pruebasVarias;

public class PruebaRecursos {

	public static void main(String[] args) {

		
		System.out.println("Array entero");
		int array[] = new int[10];
		RecursosArrays.inicializarArray(array);
		RecursosArrays.mostrarArray(array);
		
		
		System.out.println("\n\nNúmero al azar");
		
		
		int azar = RecursosArrays.numerosAzar();
		System.out.println(azar);
		
		System.out.println("\nArray decimal");
		
		float arrayDecimal[] = new float[5];
		RecursosArrays.inicializarArraysDecimales(arrayDecimal);
		RecursosArrays.imprimirArrayDecimal(arrayDecimal);
		
		System.out.println("\n\nMatriz entera");
		
		int matrix[][] = new int[5][5];
		RecursosMatrices.inicializarMatriz(matrix);
		RecursosMatrices.mostrarMatriz(matrix);
		
	}

}
