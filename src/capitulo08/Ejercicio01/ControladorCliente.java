package capitulo08.Ejercicio01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ControladorCliente extends ControladorGeneral {
	/**
	 * 
	 */
	public static Cliente findPrimerCliente() {
		Cliente c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from cliente order by id limit 1");
			if (rs.next()) {
				c = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * 
	 */
	public static Cliente findSiguienteCliente(int idAnterior) {
		Cliente c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from cliente where id > " + idAnterior + " order by id asc limit 1");
			if (rs.next()) {
				c = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}

	/**
	 * 
	 */
	public static int borrarCliente(int id) {
		int rowAffected = 0;
		Cliente c = new Cliente();
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery("select id from cliente order by id limit 1");
			// Menor id
			if (rs.next()) {
				if (id == rs.getInt(1)) {
					ResultSet rs3 = s
							.executeQuery("select * from cliente where id > " + id + " order by id asc limit 1");
					if (rs3.next()) {
						c.setId(rs3.getInt(1));
						c.setNombre(rs3.getString(2));
						c.setApellidos(rs3.getString(3));
						c.setLocalidad(rs3.getString(4));
						c.setDni(rs3.getString(5));
						c.setFechaNac(rs3.getString(6));
						c.setActivo(rs3.getBoolean(7));
						GestionCliente.getInstance().mostrarCliente(c);
					}
				}
			} else {
				c.setId(0);
				c.setNombre("");
				c.setApellidos("");
				c.setLocalidad("");
				c.setDni("");
				c.setFechaNac(null);
				c.setActivo(false);
				GestionCliente.getInstance().mostrarCliente(c);
			}
			ResultSet rs2 = s.executeQuery("select id from cliente order by id desc limit 1");
			// Mayor id
			if (rs2.next()) {
				if (id == rs2.getInt(1)) {
					ResultSet rs4 = s
							.executeQuery("select * from cliente where id < " + id + " order by id desc limit 1");
					if (rs4.next()) {
						c.setId(rs4.getInt(1));
						c.setNombre(rs4.getString(2));
						c.setApellidos(rs4.getString(3));
						c.setLocalidad(rs4.getString(4));
						c.setDni(rs4.getString(5));
						c.setFechaNac(rs4.getString(6));
						c.setActivo(rs4.getBoolean(7));
						GestionCliente.getInstance().mostrarCliente(c);
					}
				}
			} else {
				c.setId(0);
				c.setNombre("");
				c.setApellidos("");
				c.setLocalidad("");
				c.setDni("");
				c.setFechaNac(null);
				c.setActivo(false);
				GestionCliente.getInstance().mostrarCliente(c);
			}
			rowAffected = s.executeUpdate("delete from cliente where id = " + id + ";");
			return rowAffected;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo borrar el registro, código de error: " + e.getErrorCode(),
					"Gestion de clientes", 0);
		}
		return rowAffected;
	}

	/**
	 * 
	 */
	public static int actualizarCliente(Cliente c) {
		int rowAffected = 0;
		int idMax = 0;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select max(id) from cliente;");
			if (rs.next()) {
				idMax = (rs.getInt(1) + 1);
			}
			// si entra en este if quiere decir k voy a insertar
			if (c.getId() == 0) {
				rowAffected = s.executeUpdate("insert into cliente values(" + idMax + "," + "'" + c.getNombre() + "'"
						+ "," + "'" + c.getApellidos() + "','" + c.getLocalidad() + "','" + c.getDni() + "','"
						+ c.getFechaNac() + "'," + c.isActivo() + ");");
			} else {
				// si entra en este else quiere decir k voy a actualizar
				rowAffected = s.executeUpdate("update cliente set nombre = " + "'" + c.getNombre() + "'" + ","
						+ "apellidos = " + "'" + c.getApellidos() + "', localidad = '" + c.getLocalidad()
						+ "',dniNie = '" + c.getDni() + "',fechaNac = '" + c.getFechaNac() + "',activo = "
						+ c.isActivo() + " where id = " + c.getId() + ";");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Actualización o inserción incorrecta, código de error: " + e.getErrorCode(), "Gestion de clientes",
					0);
		}
		return rowAffected;
	}

	/**
	* 
	*/
	public static Cliente findAnteriorCliente(int idSiguiente) {
		Cliente c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from cliente where id < " + idSiguiente + " order by id desc limit 1");
			if (rs.next()) {
				c = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}

	/**
	 * 
	 */
	public static Cliente findUltimoCliente() {
		Cliente c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from cliente order by id desc limit 1");
			if (rs.next()) {
				c = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}

}
