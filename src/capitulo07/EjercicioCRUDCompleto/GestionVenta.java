package capitulo07.EjercicioCRUDCompleto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

public class GestionVenta {
	static Scanner sc = new Scanner(System.in);

	/**
	 * 
	 */
	public static void borrarVentas() {
		System.out.println("\n");
		int id = 0;
		long time = 0, time2 = 0;
		int rowAffected;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			System.out.println("Dame el id de la venta a eliminar: ");
			id = sc.nextInt();
			Date d = new Date();
			time = d.getTime();
			rowAffected = s.executeUpdate("delete from venta where id = " + id + ";");
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
	public static void actualizarVentas() {
		System.out.println("\n");
		int id = 0, idFab = 0;
		String bastidor = "", modelo = "", color = "";
		String nuevoBastidor = "", nuevoModelo = "", nuevoColor = "";

		System.out.println("Introduce id del coche: ");
		id = sc.nextInt();

		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			ResultSet rs = s.executeQuery("select * from coche where id=" + id);
			if (rs.next()) {
				bastidor = rs.getString("bastidor");
				modelo = rs.getString("modelo");
				color = rs.getString("color");
			}

			nuevoBastidor = JOptionPane.showInputDialog("Bastidor (" + bastidor + ") (Intro para mantener): ");
			if (!nuevoBastidor.trim().equals("")) {
				bastidor = nuevoBastidor;
			}

			nuevoModelo = JOptionPane.showInputDialog("Modelo (" + modelo + ") (Intro para mantener): ");

			if (!nuevoModelo.trim().equals("")) {
				modelo = nuevoModelo;
			}

			nuevoColor = JOptionPane.showInputDialog("Color (" + color + ") (Intro para mantener): ");

			if (!nuevoColor.trim().equals("")) {
				color = nuevoColor;
			}

			int registrosAfectados = s.executeUpdate("update coche set bastidor='" + bastidor + "', modelo='" + modelo
					+ "' " + "," + " color='" + color + "' " + "where id=" + id);
			System.out.println(registrosAfectados + " registros afectados");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	public static void crearVentas() {
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

			ResultSet rs2 = s2.executeQuery("select * from coche");

			while (rs2.next()) {
				System.out.println(rs2.getInt(1) + "\t" + rs2.getString(2) + "\t" + rs2.getString(3));
			}

			System.out.println("Dime el id del coche: ");
			idFab = sc.nextInt();
			rowAffected = s.executeUpdate("insert into coche values(" + (id + 1) + "," + idFab + "," + "'" + bastidor
					+ "'" + "," + "'" + modelo + "'" + "," + "'" + color + "'" + ");");
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
	public static void listarVentas() {
		long time = 0, time2 = 0;
		try {
			System.out.println("\n");
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			Date d = new Date();
			time = d.getTime();
			ResultSet rs = s.executeQuery("select * from venta");
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
