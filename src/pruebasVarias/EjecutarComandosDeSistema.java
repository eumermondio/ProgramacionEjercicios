package pruebasVarias;

import java.io.*;
import java.util.Scanner;

public class EjecutarComandosDeSistema {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = null, comando = "";
		try {
			System.out.println("Que comando quieres ejecutar?");
			comando = sc.next();
			// Ejecuto el comando
			Process p = Runtime.getRuntime().exec(comando);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

			// Leo la salida del comando
			System.out.println("Salida:\n");
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}
			System.out.println("");
			// Leo posibles errores de la salida del comando
			System.out.println("Errores:\n");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
