package capitulo07.Ejercicio01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		conexion();
		int opcion = 0;
		do {
			System.out.println("0.-Salir");
			System.out.println("1.-Salir");
			System.out.println("2.-Salir");
			System.out.println("3.-Salir");
			System.out.println("4.-Salir");

		} while (opcion != 0);
	}

	public static void conexion() {
		try {
			// A través de la siguiente línea comprobamos si tenemos acceso al driver MySQL,
			// si no fuera así
			// no podemos trabajar con esa BBDD.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Necesitamos obtener un acceso a la BBDD, eso se materializa en un objeto de
			// tipo Connection, al cual
			// le tenemos que pasar los parámetros de conexión.
			Connection conexion = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost/tutorialjavacoches?serverTimezone=UTC", "java", "Abcdefgh.1");

			// Para poder ejecutar una consulta necesitamos utilizar un objeto de tipo
			// Statement
			Statement s = (Statement) conexion.createStatement();

			// La ejecución de la consulta se realiza a través del objeto Statement y se
			// recibe en forma de objeto
			// de tipo ResultSet, que puede ser navegado para descubrir todos los registros
			// obtenidos por la consulta

			// Cierre de los elementos
			s.close();
			conexion.close();
		} catch (ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
			ex.printStackTrace();
		} catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
