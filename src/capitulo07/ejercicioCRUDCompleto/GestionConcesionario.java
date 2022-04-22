package capitulo07.ejercicioCRUDCompleto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class GestionConcesionario extends SupertipoGestion {
	static Scanner sc = new Scanner(System.in);

	/**
	 * 
	 */
	public static void borrarConcesionario() {
		System.out.println("\n");
		int id = 0;
		long time = 0, time2 = 0;
		int rowAffected;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			System.out.println("Dame el id del concesionario a eliminar: ");
			id = sc.nextInt();
			Date d = new Date();
			time = d.getTime();
			rowAffected = s.executeUpdate("delete from concesionario where id = " + id + ";");
			Date dd = new Date();
			time2 = dd.getTime();
			System.out.println(Math.abs(time - time2) / 1000f + " time taken in seconds\n");
			System.out.println(rowAffected + " fila/s afectada/s");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	public static void actualizarConcesionario() {
		System.out.println("\n");
		int id = 0;
		long time = 0, time2 = 0;
		int rowAffected;
		String newNombre = "";
		String newCif = "";
		String newLocalidad = "";
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();

			System.out.println("Dame el id del concesionario a modificar: ");
			id = sc.nextInt();
			System.out.println("Dame el nuevo nombre del concesionario: ");
			newNombre = sc.next();
			System.out.println("Dame el nuevo cif del concesionario: ");
			newCif = sc.next();
			System.out.println("Dame la localidad del concesionario a modificar: ");
			newLocalidad = sc.next();
			Date d = new Date();
			time = d.getTime();
			rowAffected = s.executeUpdate("update concesionario set nombre = " + "'" + newNombre + "'" + "," + "cif = "
					+ "'" + newCif + "'" + "," + "localidad=" + "'" + newLocalidad + "'" + " where id = " + id + ";");
			Date dd = new Date();
			time2 = dd.getTime();
			System.out.println(Math.abs(time - time2) / 1000f + " time taken in seconds\n");
			System.out.println(rowAffected + " fila/s afectada/s");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	public static void crearConcesionario() {
		System.out.println("\n");
		int id = 0;
		long time = 0, time2 = 0;
		int rowAffected;
		String cif = "", nombre = "", localidad = "";
		Connection con;
		id = maxIdEnTabla("concesionario");
		System.out.println("Dime el cif: ");
		cif = sc.next();
		System.out.println("Dime el nombre: ");
		nombre = sc.next();
		System.out.println("Dime la localidad: ");
		localidad = sc.next();
		try {
			con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			Date d = new Date();
			time = d.getTime();
			rowAffected = s.executeUpdate("insert into concesionario values(" + id + "," + "'" + cif + "'" + "," + "'"
					+ nombre + "'" + "," + "'" + localidad + "'" + ");");
			Date dd = new Date();
			time2 = dd.getTime();
			System.out.println(Math.abs(time - time2) / 1000f + " time taken in seconds");
			System.out.println(rowAffected + " fila/s afectada/s");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static void listarConcesionario() {
		long time = 0, time2 = 0;
		try {
			System.out.println("\n");
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			Date d = new Date();
			time = d.getTime();
			ResultSet rs = s.executeQuery("select * from concesionario");
			Date dd = new Date();
			time2 = dd.getTime();
			System.out.println(Math.abs(time - time2) / 1000f + " time taken in seconds");
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("\n-------------------------------------------------------------");
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.print(rsmd.getColumnLabel(i) + "\t");
			}
			System.out.println("\n-------------------------------------------------------------");
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
			}
			System.out.println("\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
