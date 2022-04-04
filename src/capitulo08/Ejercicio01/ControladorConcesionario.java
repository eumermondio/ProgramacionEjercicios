package capitulo08.Ejercicio01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ControladorConcesionario {
	/**
	 * 
	 */
	public static Concesionario findPrimerConcesionario() {
		Concesionario c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from concesionario order by id limit 1");
			if (rs.next()) {
				c = new Concesionario(rs.getInt("id"), rs.getString("cif"), rs.getString("nombre"),
						rs.getString("localidad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * 
	 */
	public static Concesionario findSiguienteConcesionario(int idAnterior) {
		Concesionario c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from concesionario where id > " + idAnterior + " order by id asc limit 1");
			if (rs.next()) {
				c = new Concesionario(rs.getInt("id"), rs.getString("cif"), rs.getString("nombre"),
						rs.getString("localidad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}

	/**
	 * 
	 */
	public static int borrarConcesionario(int id) {
		int rowAffected = 0;
		Concesionario c = new Concesionario();
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery("select id from concesionario order by id limit 1");
			// Menor id
			if (rs.next()) {
				if (id == rs.getInt(1)) {
					ResultSet rs3 = s
							.executeQuery("select * from concesionario where id > " + id + " order by id asc limit 1");
					if (rs3.next()) {
						c.setId(rs3.getInt(1));
						c.setCif(rs3.getString(2));
						c.setNombre(rs3.getString(3));
						c.setLocalidad(rs3.getString(4));
						GestionConcesionario.getInstance().mostrarConcesionario(c);
					}
				}
			} else {
				c.setId(0);
				c.setCif("0");
				c.setNombre("0");
				c.setLocalidad("0");
				GestionConcesionario.getInstance().mostrarConcesionario(c);
			}
			ResultSet rs2 = s.executeQuery("select id from concesionario order by id desc limit 1");
			// Mayor id
			if (rs2.next()) {
				if (id == rs2.getInt(1)) {
					ResultSet rs4 = s
							.executeQuery("select * from concesionario where id < " + id + " order by id desc limit 1");
					if (rs4.next()) {
						c.setId(rs4.getInt(1));
						c.setCif(rs4.getString(2));
						c.setNombre(rs4.getString(3));
						c.setLocalidad(rs4.getString(4));
						GestionConcesionario.getInstance().mostrarConcesionario(c);
					}
				}
			} else {
				c.setId(0);
				c.setCif("0");
				c.setNombre("0");
				c.setLocalidad("0");
				GestionConcesionario.getInstance().mostrarConcesionario(c);
			}
			rowAffected = s.executeUpdate("delete from concesionario where id = " + id + ";");
			return rowAffected;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo borrar el registro, código de error: " + e.getErrorCode(),
					"Gestion de fabricantes", 0);
		}
		return rowAffected;
	}

	/**
	 * 
	 */
	public static int actualizarConcesionario(Concesionario c) {
		int rowAffected = 0;
		int idMax = 0;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select max(id) from concesionario;");
			if (rs.next()) {
				idMax = (rs.getInt(1) + 1);
			}
			// si entra en este if quiere decir k voy a insertar
			if (c.getId() == 0) {
				rowAffected = s.executeUpdate("insert into concesionario values(" + idMax + "," + "'" + c.getCif() + "'"
						+ "," + "'" + c.getNombre() + "','" + c.getLocalidad() + "');");
			} else {
				// si entra en este else quiere decir k voy a actualizar
				rowAffected = s.executeUpdate("update concesionario set nombre = " + "'" + c.getNombre() + "'" + ","
						+ "cif = " + "'" + c.getCif() + "', localidad = '" + c.getLocalidad() + "' where id = "
						+ c.getId() + ";");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Actualización o inserción incorrecta, código de error: " + e.getErrorCode(),
					"Gestion de concesionarios", 0);
		}
		return rowAffected;
	}

	/**
	* 
	*/
	public static Concesionario findAnteriorConcesionario(int idSiguiente) {
		Concesionario c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"select * from concesionario where id < " + idSiguiente + " order by id desc limit 1");
			if (rs.next()) {
				c = new Concesionario(rs.getInt("id"), rs.getString("cif"), rs.getString("nombre"),
						rs.getString("localidad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}

	/**
	 * 
	 */
	public static Concesionario findUltimoConcesionario() {
		Concesionario c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from concesionario order by id desc limit 1");
			if (rs.next()) {
				c = new Concesionario(rs.getInt("id"), rs.getString("cif"), rs.getString("nombre"),
						rs.getString("localidad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}

}
