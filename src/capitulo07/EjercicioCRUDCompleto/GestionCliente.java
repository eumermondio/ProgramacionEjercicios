package capitulo07.EjercicioCRUDCompleto;

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

public class GestionCliente {
	static Scanner sc = new Scanner(System.in);

	/**
	 * 
	 */
	public static void borrarClientes() {
		System.out.println("\n");
		int id = 0;
		long time = 0, time2 = 0;
		int rowAffected;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			System.out.println("Dame el id del cliente a eliminar: ");
			id = sc.nextInt();
			Date d = new Date();
			time = d.getTime();
			rowAffected = s.executeUpdate("delete from cliente where id = " + id + ";");
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
	public static void actualizarClientes() {
		System.out.println("\n");
		int id = 0;
		String nombre = "", apellidos = "", localidad = "", dni = "", fechaNac = "";
		String newNombre = "", newApellidos = "", newLocalidad = "", newDni = "", newFechaNac = "";

		System.out.println("Introduce id del cliente: ");
		id = sc.nextInt();

		try {
			Statement s = ConnectionManager.getConexion().createStatement();
			ResultSet rs = s.executeQuery("select * from cliente where id=" + id);
			if (rs.next()) {
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
				localidad = rs.getString("localidad");
				dni = rs.getString("dniNie");
				fechaNac = rs.getString("fechaNac");
			}

			newNombre = JOptionPane.showInputDialog("Nombre (" + nombre + ") (Intro para mantener): ");
			if (!newNombre.trim().equals("")) {
				nombre = newNombre;
			}

			newApellidos = JOptionPane.showInputDialog("Apellidos (" + apellidos + ") (Intro para mantener): ");

			if (!newApellidos.trim().equals("")) {
				apellidos = newApellidos;
			}

			newLocalidad = JOptionPane.showInputDialog("Localidad (" + localidad + ") (Intro para mantener): ");

			if (!newLocalidad.trim().equals("")) {
				localidad = newLocalidad;
			}

			newDni = JOptionPane.showInputDialog("DNI (" + dni + ") (Intro para mantener): ");

			if (!newDni.trim().equals("")) {
				dni = newDni;
			}

			newFechaNac = JOptionPane.showInputDialog(
					"FechaNac (" + fechaNac + ") (Intro para mantener) (Introducir en formato dd/MM/yyyy): ");

			if (!newFechaNac.trim().equals("")) {
				fechaNac = newFechaNac;
			}

			SimpleDateFormat sdfEntrada = new SimpleDateFormat("dd/MM/yyyy");

			Date date = new Date();
			try {
				date = sdfEntrada.parse(fechaNac);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			SimpleDateFormat sdfSalida = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			int registrosAfectados = s.executeUpdate("update cliente set nombre='" + nombre + "', apellidos='"
					+ apellidos + "' " + "," + " localidad='" + localidad + "', dniNie = '" + dni + "' ,fechaNac = '"
					+ sdfSalida.format(date) + "' where id=" + id);
			System.out.println(registrosAfectados + " registros afectados");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	public static void crearClientes() {
		System.out.println("\n");
		int id = 0;
		boolean activo = false;
		String fechaNac = "";
		long time = 0, time2 = 0;
		int rowAffected;
		String nombre = "", apellidos = "", localidad = "", dni = "";
		Connection con;
		System.out.println("Dime el nombre: ");
		nombre = sc.next();
		System.out.println("Dime el apellido: ");
		apellidos = sc.next();
		System.out.println("Dime la localidad: ");
		localidad = sc.next();
		System.out.println("Dime el DNI: ");
		dni = sc.next();
		System.out.println("Dime la fecha de nacimiento: ");
		fechaNac = sc.next();

		SimpleDateFormat sdfEntrada = new SimpleDateFormat("dd/MM/yyyy");

		Date date = new Date();
		try {
			date = sdfEntrada.parse(fechaNac);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		SimpleDateFormat sdfSalida = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			Date d = new Date();
			time = d.getTime();
			ResultSet rs = s.executeQuery("select max(id) from cliente");
			rs.next();
			id = rs.getInt(1);

			rowAffected = s.executeUpdate(
					"insert into cliente values(" + (id + 1) + ",'" + nombre + "'," + "'" + apellidos + "'" + "," + "'"
							+ localidad + "'" + "," + "'" + dni + "'," + "'" + sdfSalida.format(date) + "',1" + ");");
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
	public static void listarClientes() {
		long time = 0, time2 = 0;
		try {
			System.out.println("\n");
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			Date d = new Date();
			time = d.getTime();
			ResultSet rs = s.executeQuery("select * from cliente");
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
						+ rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getDate(6) + "\t" + rs.getBoolean(7));
			}
			System.out.println("\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
