package capitulo08.Ejercicio01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class ControladorVenta extends ControladorGeneral {
	/**
	 * 
	 */
	public static Venta findPrimerVenta() {
		Venta v = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from venta order by id limit 1");
			if (rs.next()) {
				v = new Venta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getFloat(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	/**
	 * 
	 */
	public static Venta findSiguienteVenta(int idAnterior) {
		Venta v = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from venta where id > " + idAnterior + " order by id asc limit 1");
			if (rs.next()) {
				v = new Venta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getFloat(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;

	}

	/**
	 * 
	 */
	public static int borrarVenta(int id) {
		int rowAffected = 0;
		Venta v = new Venta();
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery("select id from venta order by id limit 1");
			// Menor id
			if (rs.next()) {
				if (id == rs.getInt(1)) {
					ResultSet rs3 = s.executeQuery("select * from venta where id > " + id + " order by id asc limit 1");
					if (rs3.next()) {
						v.setId(rs3.getInt(1));
						v.setIdCli(rs3.getInt(2));
						v.setIdConce(rs3.getInt(3));
						v.setIdCoche(rs3.getInt(4));
						v.setFecha(rs3.getDate(5));
						v.setPrecio(rs3.getFloat(6));
						GestionVenta.getInstance().mostrarVenta(v);
					}
				}
			} else {
				v.setId(0);
				v.setIdCli(0);
				v.setIdConce(0);
				v.setIdCoche(0);
				v.setFecha(null);
				v.setPrecio(0);
				GestionVenta.getInstance().mostrarVenta(v);
			}
			ResultSet rs2 = s.executeQuery("select id from venta order by id desc limit 1");
			// Mayor id
			if (rs2.next()) {
				if (id == rs2.getInt(1)) {
					ResultSet rs4 = s
							.executeQuery("select * from venta where id < " + id + " order by id desc limit 1");
					if (rs4.next()) {
						v.setId(rs4.getInt(1));
						v.setIdCli(rs4.getInt(2));
						v.setIdConce(rs4.getInt(3));
						v.setIdCoche(rs4.getInt(4));
						v.setFecha(rs4.getDate(5));
						v.setPrecio(rs4.getFloat(6));
						GestionVenta.getInstance().mostrarVenta(v);
					}
				}
			} else {
				v.setId(0);
				v.setIdCli(0);
				v.setIdConce(0);
				v.setIdCoche(0);
				v.setFecha(null);
				v.setPrecio(0);
				GestionVenta.getInstance().mostrarVenta(v);
			}
			rowAffected = s.executeUpdate("delete from venta where id = " + id + ";");
			return rowAffected;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo borrar el registro, código de error: " + e.getErrorCode(),
					"Gestion de ventas", 0);
		}
		return rowAffected;
	}

	/**
	 * 
	 */
	public static int actualizarVenta(Venta v) {
		int rowAffected = 0;
		int idMax = 0;
		try {
			Date date = v.getFecha();
			SimpleDateFormat sdfSalida = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select max(id) from venta;");
			if (rs.next()) {
				idMax = (rs.getInt(1) + 1);
			}
			// si entra en este if quiere decir k voy a insertar
			if (v.getId() == 0) {
				rowAffected = s
						.executeUpdate("insert into venta values(" + idMax + "," + v.getIdCli() + "," + v.getIdConce()
								+ "," + v.getIdCoche() + ",'" + sdfSalida.format(date) + "'," + v.getPrecio() + ");");
			} else {
				// si entra en este else quiere decir k voy a actualizar
				rowAffected = s.executeUpdate(
						"update venta set idCliente = " + v.getIdCli() + "," + "idConcesionario = " + v.getIdConce()
								+ ", idCoche = " + v.getIdCoche() + ",fecha = '" + sdfSalida.format(date)
								+ "',precioVenta = " + v.getPrecio() + " where id = " + v.getId() + ";");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Actualización o inserción incorrecta, código de error: " + e.getErrorCode(), "Gestion de ventas",
					0);
		}
		return rowAffected;
	}

	/**
	* 
	*/
	public static Venta findAnteriorVenta(int idSiguiente) {
		Venta v = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s
					.executeQuery("select * from venta where id < " + idSiguiente + " order by id desc limit 1");
			if (rs.next()) {
				v = new Venta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getFloat(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;

	}

	/**
	 * 
	 * @return
	 */
	public static void listadoClientes(List<Cliente> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from cliente;");
			while (rs.next()) {
				l.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getBoolean(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public static void listadoConcesionarios(List<Concesionario> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from concesionario;");
			while (rs.next()) {
				l.add(new Concesionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public static void listadoCoches(List<Coche> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from coche;");
			while (rs.next()) {
				l.add(new Coche(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static String findApllNomCliente(int id) {
		String str = "";
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"select CONCAT(cliente.nombre, ' ' ,cliente.apellidos) from cliente,venta where cliente.id = venta.idCliente and cliente.id = "
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
	 * @param id
	 * @return
	 */
	public static String findNombreConce(int id) {
		String str = "";
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"select concesionario.nombre from concesionario,venta where concesionario.id = venta.idConcesionario and concesionario.id = "
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
	 * @param id
	 * @return
	 */
	public static String findNombreCoche(int id) {
		String str = "";
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(
					"select CONCAT(coche.modelo, ' ' ,coche.color) from coche,venta where coche.id = venta.idCoche and coche.id = "
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
	public static Venta findUltimoVenta() {
		Venta v = null;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from venta order by id desc limit 1");
			if (rs.next()) {
				v = new Venta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getFloat(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;

	}

}
