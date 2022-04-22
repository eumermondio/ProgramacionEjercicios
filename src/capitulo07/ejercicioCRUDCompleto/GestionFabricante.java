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

public class GestionFabricante extends SupertipoGestion {
	static Scanner sc = new Scanner(System.in);

	/**
	 * 
	 */
	public static void borrarFabricantes() {
		System.out.println("\n");
		int id = 0;
		long time = 0, time2 = 0;
		int rowAffected;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			System.out.println("Dame el id del fabricante a eliminar: ");
			id = sc.nextInt();
			Date d = new Date();
			time = d.getTime();
			rowAffected = s.executeUpdate("delete from fabricante where id = " + id + ";");
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
	public static void actualizarFabricantes() {
		System.out.println("\n");
		int id = 0;
		long time = 0, time2 = 0;
		int rowAffected;
		String newNombre = "";
		String newCif = "";
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			System.out.println("Dame el id del fabricante a modificar: ");
			id = sc.nextInt();
			System.out.println("Dame el nuevo nombre del fabricante: ");
			newNombre = sc.next();
			System.out.println("Dame el nuevo cif del fabricante: ");
			newCif = sc.next();
			Date d = new Date();
			time = d.getTime();
			rowAffected = s.executeUpdate("update fabricante set nombre = " + "'" + newNombre + "'" + "," + "cif = "
					+ "'" + newCif + "'" + " where id = " + id + ";");
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
	public static void crearFabricantes() {
		System.out.println("\n");
		int id = 0;
		long time = 0, time2 = 0;
		int rowAffected;
		String cif = "", nombre = "";
		Connection con;
		System.out.println("Dime el id: ");
		id = sc.nextInt();
		System.out.println("Dime el cif: ");
		cif = sc.next();
		System.out.println("Dime el nombre: ");
		nombre = sc.next();
		try {
			con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			Date d = new Date();
			time = d.getTime();
			rowAffected = s.executeUpdate(
					"insert into fabricante values(" + id + "," + "'" + cif + "'" + "," + "'" + nombre + "'" + ");");
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
	public static void listarFabricantes() {
		long time = 0, time2 = 0;
		try {
			System.out.println("\n");
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			Date d = new Date();
			time = d.getTime();
			ResultSet rs = s.executeQuery("select * from fabricante");
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
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}
			System.out.println("\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
