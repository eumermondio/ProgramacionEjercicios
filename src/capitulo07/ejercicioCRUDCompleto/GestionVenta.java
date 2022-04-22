package capitulo07.ejercicioCRUDCompleto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		int id = 0, idCli = 0, idCon = 0, idCo = 0;
		float precio = 0;
		String fecha = "";
		String nuevaFecha = "", nuevoPrecio = "";

		System.out.println("Introduce id de la venta: ");
		id = sc.nextInt();

		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			ResultSet rs = s.executeQuery("select * from venta where id=" + id);
			if (rs.next()) {
				precio = rs.getInt("precioVenta");
				fecha = rs.getString("fecha");
			}

			nuevoPrecio = JOptionPane.showInputDialog("Precio (" + precio + ") (Intro para mantener): ");
			if (Float.parseFloat(nuevoPrecio) != precio) {
				precio = Float.parseFloat(nuevoPrecio);
			}

			nuevaFecha = JOptionPane.showInputDialog(
					"Fecha (" + fecha + ") (Intro para mantener) (Introducir en formato dd/MM/yyyy): ");

			if (!nuevaFecha.trim().equals("")) {
				fecha = nuevaFecha;
			}

			SimpleDateFormat sdfSalida = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date date = new Date();
			try {
				date = sdfSalida.parse(fecha);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			int registrosAfectados = s.executeUpdate("update venta set precioVenta=" + precio + ", fecha='"
					+ sdfSalida.format(date) + "' " + "where id=" + id);
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
		int id = 0, idCli = 0, idCon = 0, idCo = 0;
		float precio = 0;
		long time = 0, time2 = 0;
		int rowAffected;
		String fecha = "";
		Connection con;
		System.out.println("Dime la fecha: ");
		fecha = sc.next();
		System.out.println("Dime el precio de venta: ");
		precio = sc.nextFloat();

		SimpleDateFormat sdfEntrada = new SimpleDateFormat("dd/MM/yyyy");

		Date date = new Date();
		try {
			date = sdfEntrada.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		SimpleDateFormat sdfSalida = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			Statement s2 = con.createStatement();
			Statement s3 = con.createStatement();
			Statement s4 = con.createStatement();
			Date d = new Date();
			time = d.getTime();
			ResultSet rs = s.executeQuery("select max(id) from venta");
			rs.next();
			id = rs.getInt(1);
//
			ResultSet rs2 = s2.executeQuery("select * from cliente");

			while (rs2.next()) {
				System.out.println(
						rs2.getInt(1) + "\t" + rs2.getString(2) + "\t" + rs2.getString(3) + "\t" + rs2.getString(4)
								+ "\t" + rs2.getString(5) + "\t" + rs2.getDate(6) + "\t" + rs2.getBoolean(7));
			}

			System.out.println("Dime el id del cliente: ");
			idCli = sc.nextInt();
//
			ResultSet rs3 = s3.executeQuery("select * from concesionario");

			while (rs3.next()) {
				System.out.println(
						rs3.getInt(1) + "\t" + rs3.getString(2) + "\t" + rs3.getString(3) + "\t" + rs3.getString(4));
			}

			System.out.println("Dime el id del concesionario: ");
			idCon = sc.nextInt();
//
			ResultSet rs4 = s4.executeQuery("select * from coche");

			while (rs4.next()) {
				System.out.println(rs4.getInt(1) + "\t" + rs4.getString(2) + "\t" + rs4.getString(3) + "\t"
						+ rs4.getString(4) + "\t" + rs4.getString(5));
			}

			System.out.println("Dime el id del coche: ");
			idCo = sc.nextInt();

			//
			rowAffected = s.executeUpdate("insert into venta values(" + (id + 1) + "," + idCli + "," + idCon + ","
					+ idCo + ",'" + sdfSalida.format(date) + "'," + precio + ");");
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
				System.out.println(rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4) + "\t"
						+ rs.getString(5) + "\t" + rs.getFloat(6));
			}
			System.out.println("\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
