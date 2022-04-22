package capitulo07.Ejercicio02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

import capitulo07.EjercicioCRUDCompleto.SupertipoGestion;

public class GestionCoche extends SupertipoGestion{
	static Scanner sc = new Scanner(System.in);

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int opcion = 0;
		do {
			System.out.println("\n0.-Salir");
			System.out.println("1.-Listado de coche");
			System.out.println("2.-Crear un coche");
			System.out.println("3.-Modificar un coche");
			System.out.println("4.-Eliminar un coche");
			opcion = sc.nextInt();
			switch (opcion) {
			case 0:
				break;
			case 1:
				listarCoches();
				break;
			case 2:
				crearCoches();
				break;
			case 3:
				actualizarCoches();
				break;
			case 4:
				borrarCoches();
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}

		} while (opcion != 0);
	}

	/**
	 * 
	 */
	private static void borrarCoches() {
		System.out.println("\n");
		int id = 0;
		long time = 0, time2 = 0;
		int rowAffected;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			System.out.println("Dame el id del coche a eliminar: ");
			id = sc.nextInt();
			Date d = new Date();
			time = d.getTime();
			rowAffected = s.executeUpdate("delete from coche where id = " + id + ";");
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
	private static void actualizarCoches() {
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
	private static void crearCoches() {
		System.out.println("\n");
		int id = 0, idFab = 0;
		long time = 0, time2 = 0;
		int rowAffected;
		String color = "", bastidor = "", modelo = "";
		Connection con;
		System.out.println("Dime el modelo: ");
		modelo = sc.next();
		System.out.println("Dime el bastidor: ");
		bastidor = sc.next();
		System.out.println("Dime el color: ");
		color = sc.next();
		try {
			con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			Statement s2 = con.createStatement();
			Date d = new Date();
			time = d.getTime();
			ResultSet rs = s.executeQuery("select max(id) from coche");
			rs.next();
			id = rs.getInt(1);

			ResultSet rs2 = s2.executeQuery("select * from fabricante");

			while (rs2.next()) {
				System.out.println(rs2.getInt(1) + "\t" + rs2.getString(2) + "\t" + rs2.getString(3));
			}

			System.out.println("Dime el id del fabricante: ");
			idFab = sc.nextInt();
			rowAffected = s.executeUpdate("insert into coche values(" + (id + 1) + "," + idFab + "," + "'"
					+ bastidor + "'" + "," + "'" + modelo + "'" + "," + "'" + color + "'" + ");");
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
	private static void listarCoches() {
		long time = 0, time2 = 0;
		try {
			System.out.println("\n");
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			Date d = new Date();
			time = d.getTime();
			ResultSet rs = s.executeQuery("select * from coche");
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
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
						+ rs.getString(4) + "\t" + rs.getString(5));
			}
			System.out.println("\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
