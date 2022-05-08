package pruebasVarias.pruebaBBDD.controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import pruebasVarias.pruebaBBDD.ConnectionManager;
import pruebasVarias.pruebaBBDD.entidades.Idioma;
import pruebasVarias.pruebaBBDD.entidades.Pais;

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
	public static String traducirCheck(Idioma i) {
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
		return "Fallo en la traducción";
	}

//	/**
//	 * 
//	 * @return
//	 */
//	public static void mostrarIdiomasDeUnPais(Pais p, List<Idioma> l) {
//		try {
//			Connection con = ConnectionManager.getConexion();
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery("select * from idioma where idPais = " + p.getId() + ";");
//			while (rs.next()) {
//				l.add(new Idioma(rs.getInt(1), rs.getString(2), rs.getInt(3)));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

//	/**
//	 * 
//	 */
//	public static int guardarDatos(Usuario u) {
//		int rowAffected = 0;
//		try {
//			Connection con = ConnectionManager.getConexion();
//			Statement s = con.createStatement();
//			rowAffected = s.executeUpdate("update municipio set idProvincia = " + m.getIdProvincia()
//					+ " , codMunicipio = " + m.getCodMunicipio() + " , nombre = '" + m.getNombre() + "' where id = "
//					+ m.getId() + " ;");
//
//		} catch (
//
//		SQLException e) {
//			JOptionPane.showMessageDialog(null, "Actualización incorrecta, código de error: " + e.getErrorCode(),
//					"Gestion de municipios", JOptionPane.ERROR_MESSAGE);
//		}
//		return rowAffected;
//	}
}
