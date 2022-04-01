package capitulo08.Ejercicio01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

public class ControladorCoche {
	/**
	 * 
	 */
	public static Coche findPrimerCoche() {
		Coche c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from coche order by id limit 1");
			if (rs.next()) {
				c = new Coche(rs.getInt("id"), rs.getInt("idfabricante"), rs.getString("bastidor"),
						rs.getString("modelo"), rs.getString("color"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static String findNombreFabricante(int id) {
		String str = "";
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"select fabricante.nombre from coche,fabricante where coche.idfabricante = fabricante.id and coche.id = "
							+ id);
			if (rs.next()) {
				str = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 
	 */
	public static Coche findSiguienteCoche(int idAnterior) {
		Coche c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from coche where id > " + idAnterior + " order by id asc limit 1");
			if (rs.next()) {
				c = new Coche(rs.getInt("id"), rs.getInt("idfabricante"), rs.getString("bastidor"),
						rs.getString("modelo"), rs.getString("color"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}

	/**
	 * 
	 */
	public static int borrarCoche(int id) {
		int rowAffected = 0;
		Coche c = new Coche();
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery("select id from coche order by id limit 1");
			// Menor id
			if (rs.next()) {
				if (id == rs.getInt(1)) {
					ResultSet rs3 = s.executeQuery("select * from coche where id > " + id + " order by id asc limit 1");
					if (rs3.next()) {
						c.setId(rs3.getInt(1));
						c.setIdFab(rs3.getInt(2));
						c.setBastidor(rs3.getString(3));
						c.setModelo(rs3.getString(4));
						c.setColor(rs3.getString(5));
						GestionCoche.getInstance().mostrarCoche(c);
					}
				}
			} else {
				c.setId(0);
				c.setIdFab(0);
				c.setBastidor("");
				c.setModelo("");
				c.setColor("");
				GestionCoche.getInstance().mostrarCoche(c);
			}
			ResultSet rs2 = s.executeQuery("select id from coche order by id desc limit 1");
			// Mayor id
			if (rs2.next()) {
				if (id == rs2.getInt(1)) {
					ResultSet rs4 = s
							.executeQuery("select * from coche where id < " + id + " order by id desc limit 1");
					if (rs4.next()) {
						c.setId(rs4.getInt(1));
						c.setIdFab(rs4.getInt(2));
						c.setBastidor(rs4.getString(3));
						c.setModelo(rs4.getString(4));
						c.setColor(rs4.getString(5));
						GestionCoche.getInstance().mostrarCoche(c);
					}
				}
			} else {
				c.setId(0);
				c.setIdFab(0);
				c.setBastidor("");
				c.setModelo("");
				c.setColor("");
				GestionCoche.getInstance().mostrarCoche(c);
			}
			rowAffected = s.executeUpdate("delete from coche where id = " + id + ";");
			return rowAffected;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo borrar el registro, código de error: " + e.getErrorCode(),
					"Gestion de coches", 0);
		}
		return rowAffected;
	}

	/**
	 * 
	 */
	public static int actualizarCoche(Coche c) {
		int rowAffected = 0;
		int idMax = 0;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select max(id) from coche;");
			if (rs.next()) {
				idMax = (rs.getInt(1) + 1);
			}
			// si entra en este if quiere decir k voy a insertar
			if (c.getId() == 0) {
				rowAffected = s.executeUpdate("insert into coche values(" + idMax + "," + c.getIdFab() + "," + "'"
						+ c.getBastidor() + "','" + c.getModelo() + "','" + c.getColor() + "');");
			} else {
				// si entra en este else quiere decir k voy a actualizar
				rowAffected = s.executeUpdate("update coche set idfabricante = " + "'" + c.getIdFab() + "'" + ","
						+ "bastidor = " + "'" + c.getBastidor() + "', modelo = '" + c.getModelo() + "', color = '"
						+ c.getColor() + "' where id = " + c.getId() + ";");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Actualización o inserción incorrecta, código de error: " + e.getErrorCode(), "Gestion de coches",
					0);
		}
		return rowAffected;
	}

	/**
	 * 
	 * @return
	 */
	public static void listadoFabricantes(List<Fabricante> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from fabricante;");
			while (rs.next()) {
				l.add(new Fabricante(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	* 
	*/
	public static Coche findAnteriorCoche(int idSiguiente) {
		Coche c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from coche where id < " + idSiguiente + " order by id desc limit 1");
			if (rs.next()) {
				c = new Coche(rs.getInt("id"), rs.getInt("idfabricante"), rs.getString("bastidor"),
						rs.getString("modelo"), rs.getString("color"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}

	/**
	 * 
	 */
	public static Coche findUltimoCoche() {
		Coche c = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from coche order by id desc limit 1");
			if (rs.next()) {
				c = new Coche(rs.getInt("id"), rs.getInt("idfabricante"), rs.getString("bastidor"),
						rs.getString("modelo"), rs.getString("color"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}

}
