package examenes.examen20220509.controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import examenes.examen20220509.ConnectionManager;
import examenes.examen20220509.entidades.Municipio;
import examenes.examen20220509.entidades.Provincia;


public class Controlador {
	/**
	 * 
	 * @return
	 */
	public static void listadoProvincias(List<Provincia> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from provincia;");
			while (rs.next()) {
				l.add(new Provincia(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static void filtrarMunicipio(String cadena, List<Municipio> l) {
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from municipio where nombre like '%" + cadena + "%';");
			while (rs.next()) {
				l.add(new Municipio(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static int guardarDatos(Municipio m) {
		int rowAffected = 0;
		try {
			Connection con = ConnectionManager.getConexion();
			Statement s = con.createStatement();
			rowAffected = s.executeUpdate("update municipio set idProvincia = " + m.getIdProvincia()
					+ " , codMunicipio = " + m.getCodMunicipio() + " , nombre = '" + m.getNombre() + "' where id = "
					+ m.getId() + " ;");

		} catch (

		SQLException e) {
			JOptionPane.showMessageDialog(null, "Actualización incorrecta, código de error: " + e.getErrorCode(),
					"Gestion de municipios", JOptionPane.ERROR_MESSAGE);
		}
		return rowAffected;
	}
}
