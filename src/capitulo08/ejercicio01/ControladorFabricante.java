package capitulo08.ejercicio01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ControladorFabricante extends ControladorGeneral {
	/**
	 * 
	 */
	public static Fabricante findPrimerFabricante() {
		Fabricante f = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from fabricante order by id limit 1");
			if (rs.next()) {
				f = new Fabricante(rs.getInt("id"), rs.getString("cif"), rs.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	/**
	 * 
	 */
	public static Fabricante findSiguienteFabricante(int idAnterior) {
		Fabricante f = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from fabricante where id > " + idAnterior + " order by id asc limit 1");
			if (rs.next()) {
				f = new Fabricante(rs.getInt("id"), rs.getString("cif"), rs.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;

	}

	/**
	 * 
	 */
	public static int borrarFabricante(int id) {
		int rowAffected = 0;
		Fabricante f = new Fabricante();
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery("select id from fabricante order by id limit 1");
			// Menor id
			if (rs.next()) {
				if (id == rs.getInt(1)) {
					ResultSet rs3 = s
							.executeQuery("select * from fabricante where id > " + id + " order by id asc limit 1");
					if (rs3.next()) {
						f.setId(rs3.getInt(1));
						f.setCif(rs3.getString(2));
						f.setNombre(rs3.getString(3));
						GestionFabricante.getInstance().mostrarFabricante(f);
					}
				}
			} else {
				f.setId(0);
				f.setCif("0");
				f.setNombre("0");
				GestionFabricante.getInstance().mostrarFabricante(f);
			}
			ResultSet rs2 = s.executeQuery("select id from fabricante order by id desc limit 1");
			// Mayor id
			if (rs2.next()) {
				if (id == rs2.getInt(1)) {
					ResultSet rs4 = s
							.executeQuery("select * from fabricante where id < " + id + " order by id desc limit 1");
					if (rs4.next()) {
						f.setId(rs4.getInt(1));
						f.setCif(rs4.getString(2));
						f.setNombre(rs4.getString(3));
						GestionFabricante.getInstance().mostrarFabricante(f);
					}
				}
			} else {
				f.setId(0);
				f.setCif("0");
				f.setNombre("0");
				GestionFabricante.getInstance().mostrarFabricante(f);
			}
			rowAffected = s.executeUpdate("delete from fabricante where id = " + id + ";");
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
	public static int actualizarFabricantes(Fabricante f) {
		int rowAffected = 0;
		int idMax = 0;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select max(id) from fabricante;");
			if (rs.next()) {
				idMax = (rs.getInt(1) + 1);
			}
			// si entra en este if quiere decir k voy a insertar
			if (f.getId() == 0) {
				rowAffected = s.executeUpdate("insert into fabricante values(" + idMax + "," + "'" + f.getCif() + "'"
						+ "," + "'" + f.getNombre() + "'" + ");");
			} else {
				// si entra en este else quiere decir k voy a actualizar
				rowAffected = s.executeUpdate("update fabricante set nombre = " + "'" + f.getNombre() + "'" + ","
						+ "cif = " + "'" + f.getCif() + "'" + " where id = " + f.getId() + ";");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Actualización o inserción incorrecta, código de error: " + e.getErrorCode(),
					"Gestion de fabricantes", 0);
		}
		return rowAffected;
	}

	/**
	* 
	*/
	public static Fabricante findAnteriorFabricante(int idSiguiente) {
		Fabricante f = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from fabricante where id < " + idSiguiente + " order by id desc limit 1");
			if (rs.next()) {
				f = new Fabricante(rs.getInt("id"), rs.getString("cif"), rs.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;

	}

	/**
	 * 
	 */
	public static Fabricante findUltimoFabricante() {
		Fabricante f = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from fabricante order by id desc limit 1");
			if (rs.next()) {
				f = new Fabricante(rs.getInt("id"), rs.getString("cif"), rs.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;

	}

}
