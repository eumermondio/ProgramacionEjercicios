package examenes.examen20220516.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import examenes.examen20220509.ConnectionManager;
import examenes.examen20220509.entidades.Idioma;
import examenes.examen20220509.entidades.Pais;
import examenes.examen20220509.entidades.Usuario;

public class Controlador {
	/**
	 * 
	 * @return
	 */
	public static void listadoPaises(List<Pais> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from pais;");
			while (rs.next()) {
				l.add(new Pais(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public static void listadoIdiomas(Pais p, List<Idioma> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from idioma where idPais = " + p.getId());
			while (rs.next()) {
				l.add(new Idioma(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public static String traduccionChkBox(Idioma i) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			if (i != null) {
				ResultSet rs = s.executeQuery("select * from acuerdo where idIdioma = " + i.getId() + ";");

				if (rs.next()) {
					return rs.getString(2);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Hubo un fallo en la traducción";
	}

	/**
	 * 
	 */
	public static int maxId(String tabla) {
		int id = 0;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select max(id) from " + tabla);
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (id + 1);
	}

	/**
	 * 
	 */
	public static boolean comprobarUser(String user) {
		int c = 0;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from usuario where usuario = '" + user + "'");
			if (rs.next()) {
				c++;
			}
			if (c != 0) {
				JOptionPane.showMessageDialog(null, "El nombre de usuario está en uso");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 
	 */
	public static int guardar(Usuario u) {
		int registrosAfectados = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conexion = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost/altausuarios?serverTimezone=UTC", "java", "Abcdefgh.1");
			PreparedStatement ps = (PreparedStatement) conexion
					.prepareStatement("insert into usuario values(?,?,?,?,?)");

			ps.setInt(1, maxId("usuario"));
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getUsuario());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getIdIdioma());

			registrosAfectados = ps.executeUpdate();
			ps.close();

			// Cierre de los elementos
			conexion.close();
		} catch (

		ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
			ex.printStackTrace();
		} catch (SQLException ex) {
			System.out.println("Error en la ejecuci�n SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
		return registrosAfectados;
	}
}
